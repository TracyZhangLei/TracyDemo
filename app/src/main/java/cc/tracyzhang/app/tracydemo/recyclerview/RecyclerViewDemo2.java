package cc.tracyzhang.app.tracydemo.recyclerview;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cc.tracyzhang.app.tracydemo.R;
import cc.tracyzhang.app.tracydemo.recyclerview.RecyclerViewDemo2.MyHolder.OnLongClickListener;

/**
 * Created by zl on 17-5-9.
 */

public class RecyclerViewDemo2 extends AppCompatActivity {


  RecyclerView rv;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    rv = new RecyclerView(this);
    final List<String> data = new ArrayList<>();
    data.add("Tracy");
    data.add("Kobe");
    data.add("Jordan");
    data.add("Iversion");
    data.add("Carter");
    data.add("Tim");
    data.add("Zhang Lei");
    for(int i=1; i<20;i++)
      data.add("Other "+i);
    rv.setAdapter(new MyAdapter(data,this));

    GridLayoutManager mLayoutManager = new GridLayoutManager(this, 3);
    mLayoutManager.setSpanSizeLookup(new SpanSizeLookup() {
      @Override
      public int getSpanSize(int position) {
        if (position % 3 ==0)
          return 2;
        return 1;
      }
    });

    rv.setLayoutManager(mLayoutManager);

    setContentView(rv);

  }

  static class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{

    public TextView item;
    OnClickListener listener;
    OnLongClickListener longClickListener;

    public void setLongClickListener(OnLongClickListener longClickListener) {
      this.longClickListener = longClickListener;
    }

    public void setListener(OnClickListener listener) {
      this.listener = listener;
    }

    public MyHolder(final View itemView) {
      super(itemView);
      item = (TextView)itemView.findViewById(R.id.tv);
      item.setOnClickListener(this);
      item.setOnLongClickListener(this);
    }

    @Override
    public void onClick(View v) {
      if(null != listener){
        listener.onClick(v);
      }
      Log.w( "Holder: ", getLayoutPosition()+"," + getAdapterPosition());
    }

    @Override
    public boolean onLongClick(View v) {
      if(null != longClickListener){
        longClickListener.onLongClick(v);
      }
      return true;
    }

    interface OnClickListener{
      void onClick(View v);
    }

    interface OnLongClickListener{
      void onLongClick(View v);
    }

  }

  static class MyAdapter extends RecyclerView.Adapter<MyHolder>{

    List<String> data;
    Context cxt;

    public MyAdapter(List<String> data,Context cxt) {
      this.data = data;
      this.cxt = cxt;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      MyHolder holder = new MyHolder(LayoutInflater.from(cxt).inflate(R.layout.recycler_item2, parent, false));
      return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {
      holder.item.setText(data.get(position));
      holder.setListener(new MyHolder.OnClickListener(){
        @Override
        public void onClick(View v) {
          Toast.makeText(cxt,"Hi, "+data.get(position),Toast.LENGTH_SHORT).show();
          Log.d("Click",data.get(position));
        }
      });

      holder.setLongClickListener(new OnLongClickListener() {
        @Override
        public void onLongClick(View v) {
          Toast.makeText(cxt,"LongClick, "+data.get(position),Toast.LENGTH_SHORT).show();
          Log.d("LongClick",data.get(position));
        }
      });

    }

    @Override
    public int getItemCount() {
      if(null == data) return 0;
      return data.size();
    }
  }

}
