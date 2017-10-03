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

public class ActivityB extends BaseActivity {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Button btn = new Button(this);
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
//				try{
//					Thread.sleep(11 *1000);
//				}catch (Throwable e){e.printStackTrace();}
				startActivity(new Intent(ActivityB.this,ActivityC.class));
			}
		});
		btn.setText("This is B, Click to Start C");
		setContentView(btn);

	}
}
