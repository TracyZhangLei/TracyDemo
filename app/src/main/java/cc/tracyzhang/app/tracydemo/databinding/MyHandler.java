package cc.tracyzhang.app.tracydemo.databinding;

import android.view.View;
import android.widget.Toast;

/**
 * User: zhanglei115
 * Date: 16-5-16
 * Description:
 */
public class MyHandler {

    public void onClickFriend(View view){
        Toast.makeText(view.getContext(),"Hello friend",Toast.LENGTH_LONG).show();
    }
    public void onClickEnemy(View view){
        Toast.makeText(view.getContext(),"====enemy===",Toast.LENGTH_LONG).show();
    }

}
