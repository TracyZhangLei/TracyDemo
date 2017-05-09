package cc.tracyzhang.app.tracydemo.memory;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * User: zhanglei115
 * Date: 16-8-9
 * Description:
 */
public class MemoryActivity extends AppCompatActivity{

    String[] obj;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        MemUtil.cxt = this;

        Button btn = new Button(this);
        btn.setText("点我试试");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obj = new String[1000];
                for(int i=0;i<obj.length;i++){
                    obj[i] = String.valueOf("String:"+i);
                }
            }
        });
        setContentView(btn);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MemUtil.cxt = null;
    }
}
