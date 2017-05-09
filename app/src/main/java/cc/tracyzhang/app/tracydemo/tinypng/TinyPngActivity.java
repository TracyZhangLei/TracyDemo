package cc.tracyzhang.app.tracydemo.tinypng;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import cc.tracyzhang.app.tracydemo.R;

/**
 * User: zhanglei115
 * Date: 16-8-30
 * Description:
 */
public class TinyPngActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView lv = new ListView(getApplicationContext());
        lv.setAdapter(new MyAdapter(getApplicationContext()));
        setContentView(lv);
    }

    private static class MyAdapter extends BaseAdapter{

        Context cxt;

        int[] imgIds = new int[]{
                R.drawable.worthbuy_product_mask,
                R.drawable.worthbuy_product_mask,
                R.drawable.worthbuy_product_mask,
                R.drawable.worthbuy_product_mask,
                R.drawable.worthbuy_product_mask,
                R.drawable.worthbuy_product_mask,
                R.drawable.worthbuy_product_mask,
                R.drawable.worthbuy_product_mask,
                R.drawable.worthbuy_product_mask,
                R.drawable.worthbuy_product_mask,
                R.drawable.worthbuy_product_mask,
                R.drawable.worthbuy_product_mask,
                R.drawable.worthbuy_product_mask,
                R.drawable.worthbuy_product_mask,
                R.drawable.worthbuy_product_mask,
                R.drawable.worthbuy_product_mask,
                R.drawable.worthbuy_product_mask,
                R.drawable.worthbuy_product_mask,
                R.drawable.worthbuy_product_mask,
                R.drawable.worthbuy_product_mask,
                R.drawable.worthbuy_product_mask
        };

        public MyAdapter(Context cxt) {
            this.cxt = cxt;
        }

        @Override
        public int getCount() {
            return imgIds.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Holder h;
            if(null == convertView){
                h = new Holder();
                convertView = LayoutInflater.from(cxt).inflate(R.layout.tiny_items,null);
                h.img = (ImageView) convertView.findViewById(R.id.img);
                convertView.setTag(h);
            }else{
                h = (Holder)convertView.getTag();
            }
            h.img.setImageResource(imgIds[position]);
            return convertView;
        }
    }

    private static class Holder {
        ImageView img;
    }



}
