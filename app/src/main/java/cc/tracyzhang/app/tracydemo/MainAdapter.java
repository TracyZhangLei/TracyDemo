package cc.tracyzhang.app.tracydemo;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import cc.tracyzhang.app.tracydemo.applink.AppLinkActivity;
import cc.tracyzhang.app.tracydemo.applist.AppListActivity;
import cc.tracyzhang.app.tracydemo.classloader.ClazzLoaderActivity;
import cc.tracyzhang.app.tracydemo.databinding.DataBindingActivity;
import cc.tracyzhang.app.tracydemo.databinding.MainListviewItemBinding;
import cc.tracyzhang.app.tracydemo.dialog.DialogDemoActivity;
import cc.tracyzhang.app.tracydemo.java8.Java8Activity;
import cc.tracyzhang.app.tracydemo.memory.MemoryActivity;
import cc.tracyzhang.app.tracydemo.memory.MemoryLeakWebViewActivity;
import cc.tracyzhang.app.tracydemo.okhttp.OKHttpActivity;
import cc.tracyzhang.app.tracydemo.permission.PhoneActivity;
import cc.tracyzhang.app.tracydemo.recyclerview.RecyclerViewDemo;
import cc.tracyzhang.app.tracydemo.recyclerview.RecyclerViewDemo2;
import cc.tracyzhang.app.tracydemo.rxjava.RxJavaDemo;
import cc.tracyzhang.app.tracydemo.tinypng.TinyPngActivity;
import cc.tracyzhang.app.tracydemo.toolsns.ToolsNSActivity;

/**
 * User: zhanglei115
 * Date: 16-5-13
 * Description:
 */
public class MainAdapter extends BaseAdapter{

    private Context cxt;
    private List<Item> data;
    private LayoutInflater inflater;
    private MainListviewItemBinding binding;

    public MainAdapter(Context cxt) {
        this.cxt = cxt;
        inflater = LayoutInflater.from(cxt);
        data = new ArrayList<>();
        data.add(new Item("DataBinding", DataBindingActivity.class));
        data.add(new Item("ToolsNS", ToolsNSActivity.class));
        data.add(new Item("Dialog", DialogDemoActivity.class));
        data.add(new Item("AppLink", AppLinkActivity.class));
        data.add(new Item("Memory", MemoryActivity.class));
        data.add(new Item("TinyPng Compare", TinyPngActivity.class));
        data.add(new Item("RecyclerView", RecyclerViewDemo.class));
        data.add(new Item("RecyclerView2", RecyclerViewDemo2.class));
        data.add(new Item("Permission", PhoneActivity.class));
        data.add(new Item("OKHttp", OKHttpActivity.class));
        data.add(new Item("AppList", AppListActivity.class));
        data.add(new Item("MemoryLeakWebView", MemoryLeakWebViewActivity.class));
        data.add(new Item("Java8", Java8Activity.class));
        data.add(new Item("RxJava", RxJavaDemo.class));
        data.add(new Item("ClassLoader", ClazzLoaderActivity.class));
    }

    @Override
    public int getCount() {
        return null == data? 0: data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(null == convertView){
            binding = DataBindingUtil.inflate(inflater,R.layout.main_listview_item,parent,false);
            convertView = binding.getRoot();
            convertView.setTag(binding);
        }else{
            binding = (MainListviewItemBinding) convertView.getTag();
        }
        binding.setVariable(cc.tracyzhang.app.tracydemo.BR.item,data.get(position));
        binding.setAdapter(this);
        return convertView;
    }
}

