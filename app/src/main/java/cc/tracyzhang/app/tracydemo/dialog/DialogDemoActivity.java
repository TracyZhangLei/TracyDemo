package cc.tracyzhang.app.tracydemo.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.ref.SoftReference;

/**
 * User: zhanglei115
 * Date: 16-5-31
 * Description:
 */
public class DialogDemoActivity extends AppCompatActivity {

    private static final String TAG = "DialogDemoActivity";
    Handler h;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        h = new Handler();
        Button b = new Button(this);
        b.setText("popup Dialog");
        b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                SoftReference<Dialog> dr = new SoftReference<Dialog>(new Dialog(DialogDemoActivity.this));
                if(null!=dr.get()){
                    TextView msg = new TextView(DialogDemoActivity.this);
                    msg.setText("msg");
                    dr.get().setContentView(msg);
                    dr.get().setOnDismissListener(new DialogInterface.OnDismissListener() {
                        @Override
                        public void onDismiss(DialogInterface dialog) {
                            Log.d(TAG, "onDismiss:");
                        }
                    });
                    dr.get().setOnCancelListener(new DialogInterface.OnCancelListener() {
                        @Override
                        public void onCancel(DialogInterface dialog) {
                            Log.d(TAG, "onCancel: ");
                        }
                    });
                    dr.get().show();
                }
                h.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        DialogDemoActivity.this.finish();
                    }
                },2000);
            }
        });
        setContentView(b);
    }
}
