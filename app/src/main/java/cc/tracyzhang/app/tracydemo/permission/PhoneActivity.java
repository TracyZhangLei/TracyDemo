package cc.tracyzhang.app.tracydemo.permission;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by zl on 16-12-23.
 */

public class PhoneActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);

        Button call = new Button(this);
        call.setText("Call_Phone");
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:18201051438"));
                startActivity(intent);
            }
        });
        ll.addView(call);

        Button dial = new Button(this);
        dial.setText("Dial_Phone");
        dial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:18201051438"));
                startActivity(intent);
            }
        });
        ll.addView(dial);

        setContentView(ll);

    }
}
