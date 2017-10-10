package cc.tracyzhang.app.tracydemo.broadcast;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

import cc.tracyzhang.app.tracydemo.BaseActivity;
import cc.tracyzhang.app.tracydemo.service.Child1Service;
import cc.tracyzhang.app.tracydemo.service.Child2Service;

/**
 * Created by zl on 17-10-10.
 */

public class ReceiverActivity extends BaseActivity {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		LinearLayout ll = new LinearLayout(this);
		ll.setOrientation(LinearLayout.VERTICAL);

		Button btn = new Button(this);
		btn.setText("开进程child1 Service");
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startService(new Intent(ReceiverActivity.this, Child1Service.class));
			}
		});
		ll.addView(btn);


		Button btn2 = new Button(this);
		btn2.setText("开进程child2 Service");
		btn2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startService(new Intent(ReceiverActivity.this, Child2Service.class));
			}
		});
		ll.addView(btn2);

		//local不能跨进程
		Button btn3 = new Button(this);
		btn3.setText("Local发送广播，杀死进程");
		btn3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				LocalBroadcastManager.getInstance(getApplication()).sendBroadcast(new Intent("cc.tracyzhang.app.tracydemo.broadcast.close"));
			}
		});
		ll.addView(btn3);

		Button btn4 = new Button(this);
		btn4.setText("发送广播，杀死进程");
		btn4.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				sendBroadcast(new Intent("cc.tracyzhang.app.tracydemo.broadcast.close"));
			}
		});
		ll.addView(btn4);



		setContentView(ll);

	}
}
