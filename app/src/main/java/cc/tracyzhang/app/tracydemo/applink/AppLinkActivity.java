package cc.tracyzhang.app.tracydemo.applink;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * User: zhanglei115
 * Date: 16-7-27
 * Description:
 */
public class AppLinkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this,"applink 启动拉",Toast.LENGTH_LONG).show();
    }
}
