package cc.tracyzhang.app.tracydemo.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import cc.tracyzhang.app.tracydemo.R;
import cc.tracyzhang.app.tracydemo.databinding.model.User;

public class DataBindingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cc.tracyzhang.app.tracydemo.databinding.DatabindingMainBinding binding = DataBindingUtil.setContentView(this, R.layout.databinding_main);
        final User user = new User();
        user.firstName = "tracy";
        user.lastName = "mcgrady";
        binding.setUser(user);

        User user2 = new User();
        user2.firstName = "tracy  2";
        user2.lastName = "mcgrady   2";
        binding.setUser2(user2);

        User user3 = new User();
        user3.firstName = "friend";
        user3.isFriend = true;
        binding.setUser3(user3);


        User user4 = new User();
        user4.firstName = "enemy";
        user4.isFriend = false;
        binding.setUser4(user4);

        binding.setHandler(new MyHandler(){
            @Override
            public void onClickFriend(View view) {
                super.onClickFriend(view);
                user.setFirstName("changed");
            }

            @Override
            public void onClickEnemy(View view) {
                super.onClickEnemy(view);
                user.setFirstName("tracy");
            }
        });


    }
}
