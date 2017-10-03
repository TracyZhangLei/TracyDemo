package cc.tracyzhang.app.tracydemo.permission;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.jingdong.sdk.permission.PermissionHelper;
import com.jingdong.sdk.permission.PermissionHelper.PermissionResultCallBack;

/**
 * Created by zl on 16-12-23.
 */

public class PhoneActivity extends AppCompatActivity {

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

        Button external = new Button(this);
        external.setText("Storage");
        external.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PermissionHelper.hasGrantedExternalStorage(PhoneActivity.this,
                    new PermissionResultCallBack() {
                        @Override
                        public void onGranted() {
                            super.onGranted();
                        }

                        @Override
                        public void onDenied() {
                            super.onDenied();
                        }
                    });
            }
        });
        ll.addView(external);


        Button alertWindow = new Button(this);
        alertWindow.setText("AlertWindow");
        alertWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
              intent.setData(Uri.parse("package:cc.tracyzhang.app.tracydemo"));
                startActivity(intent);



            }
        });
        ll.addView(alertWindow);


        setContentView(ll);

    }

  @Override
  protected void onResume() {
    super.onResume();
    if(VERSION.SDK_INT>=23)
      Log.d("permission", "onResume: "+Settings.canDrawOverlays(getApplication()));
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if(VERSION.SDK_INT>=23)
      Log.d("permission", "onRequestPermissionsResult: "+Settings.canDrawOverlays(getApplication()));
  }

  @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionHelper.onRequestPermissionsResult(this,requestCode,permissions,grantResults);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        PermissionHelper.onActivityDestroy();
    }
}
