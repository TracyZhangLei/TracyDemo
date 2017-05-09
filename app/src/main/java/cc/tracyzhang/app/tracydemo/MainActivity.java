package cc.tracyzhang.app.tracydemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.jingdong.sdk.permission.PermissionHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        ListView lv = (ListView) findViewById(R.id.listView);
        final MainAdapter adapter = new MainAdapter(this);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(MainActivity.this, ((Item)adapter.getItem(position)).cls));
            }
        });
        PermissionHelper.install(getApplication());
        PermissionHelper.hasGrantedPhoneState();

        ViewPager vp = new ViewPager(this);
        vp.setAdapter(null);
    }
}
