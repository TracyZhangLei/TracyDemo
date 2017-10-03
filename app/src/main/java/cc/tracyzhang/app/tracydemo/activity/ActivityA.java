package cc.tracyzhang.app.tracydemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import cc.tracyzhang.app.tracydemo.BaseActivity;

/**
 * Created by zl on 17-10-2.
 */

public class ActivityA extends BaseActivity {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Button btn = new Button(this);
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(ActivityA.this,ActivityB.class));
			}
		});
		btn.setText("This is A, Click to Start B");
		setContentView(btn);

	}
}
