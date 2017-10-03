package cc.tracyzhang.app.tracydemo.updateicon;

import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

import cc.tracyzhang.app.tracydemo.BaseActivity;

/**
 * Created by zl on 17-10-3.
 */

public class UpdateIcon extends BaseActivity {

//	private ComponentName defaultCN;
	private ComponentName cn11 , cn22;
	private PackageManager pm;

	private void enableComponentName(ComponentName cn){
		pm.setComponentEnabledSetting(cn, PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
	}

	private void disableComponentName(ComponentName cn){
		pm.setComponentEnabledSetting(cn, PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
	}


	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		pm = getPackageManager();
//		defaultCN = getComponentName();
		cn11 = new ComponentName(getBaseContext(),  "cc.tracyzhang.activity.11");
		cn22 = new ComponentName(getBaseContext(),  "cc.tracyzhang.activity.22");

		LinearLayout ll = new LinearLayout(getApplicationContext());
		ll.setOrientation(LinearLayout.VERTICAL);
		Button btn = new Button(getApplicationContext());
		btn.setText("Update Icon11");
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				disableComponentName(cn22);
//				disableComponentName(defaultCN);
				enableComponentName(cn11);

			}
		});
		ll.addView(btn);

		Button btn2 = new Button(getApplicationContext());
		btn2.setText("Update Icon22");
		btn2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				disableComponentName(cn11);
//				disableComponentName(defaultCN);
				enableComponentName(cn22);
			}
		});
		ll.addView(btn2);

//		Button btn3 = new Button(getApplicationContext());
//		btn3.setText("Reset Normal Icon");
//		btn3.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View v) {
////				disableComponentName(cn11);
//				disableComponentName(cn22);
////				enableComponentName(defaultCN);
//			}
//		});
//		ll.addView(btn3);

		setContentView(ll);
	}
}
