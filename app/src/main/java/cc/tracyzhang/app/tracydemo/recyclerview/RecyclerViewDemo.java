package cc.tracyzhang.app.tracydemo.recyclerview;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cc.tracyzhang.app.tracydemo.R;

/**
 * User: zhanglei115
 * Date: 16-9-1
 * Description:
 */
public class RecyclerViewDemo extends Activity {

    RecyclerView rv;
    List<String> mDatas;
    Paint p;
    RectF rf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_demo);

        initData();
        rv = (RecyclerView) findViewById(R.id.rv);

        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rv.setAdapter(new HomeAdapter());
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.addItemDecoration(new RecyclerView.ItemDecoration() {

            @Override
            public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
                super.onDrawOver(c, parent, state);
                c.drawRect(rf,p);
            }

            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                if(parent.getChildAdapterPosition(view) != parent.getAdapter().getItemCount()-1)
                    outRect.set(10,10,10,0);
                else
                    outRect.set(10,10,10,10);
                Log.d("log",""+state.getTargetScrollPosition());
            }
        });

    }


    protected void initData()
    {
        mDatas = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++)
        {
            mDatas.add("" + (char) i);
        }
        p = new Paint();
        p.setColor(0xffff0000);
        rf = new RectF();
        rf.top = 10;
        rf.left = 10;
        rf.right = 100;
        rf.bottom = 50;
    }

    class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder>
    {

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                    RecyclerViewDemo.this).inflate(R.layout.recycler_item, parent,
                    false));
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position)
        {
            holder.tv.setText(mDatas.get(position));
        }

        @Override
        public int getItemCount()
        {
            return mDatas.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder
        {

            TextView tv;

            public MyViewHolder(View view)
            {
                super(view);
                tv = (TextView) view.findViewById(R.id.id_num);
            }
        }
    }

}
