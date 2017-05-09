package cc.tracyzhang.app.tracydemo.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * User: zhanglei115
 * Date: 16-9-1
 * Description:
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter<MyViewHolder> {

    public MyRecyclerAdapter() {
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
