package cc.tracyzhang.app.tracydemo.looper;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.util.Log;
import android.util.Printer;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * Created by zl on 17-8-24.
 */

public class LooperActivity extends Activity {

  Handler h = new Handler();

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Button btn = new Button(this);
    btn.setText("Start");
    Looper.getMainLooper().setMessageLogging(new Printer() {
      @Override
      public void println(String x) {
        Log.d("looper", "println: "+x);
      }
    });

    btn.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        for (int i =0 ;i<10;i++){
          h.sendEmptyMessage(i);
        }
      }
    });
    setContentView(btn);
  }
}
