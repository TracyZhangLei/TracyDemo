package cc.tracyzhang.app.tracydemo.andfix;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import cc.tracyzhang.app.tracydemo.DemoApplication;

/**
 * User: zhanglei115
 * Date: 16-5-27
 * Description:
 */
public class AndFixActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final String msg = "Fix";

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    DemoApplication.getInstance().getPatchManager().addPatch("/sdcard/out.apatch");
//                    File file = new File("/sdcard/out.apatch");
//                    if(file.exists())
//                        file.delete();
                    Log.d("App","apatch loaded.......");
                }catch (Exception e){
                    Log.d("App","apatch load　fail "+e.toString());
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                    Log.d("App", msg+" log");
                    Log.d("App", msg+" add.....");
            }}).start();

        TextView t = new TextView(this);
        t.setText(msg);
        setContentView(t);

        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();
    }

}
