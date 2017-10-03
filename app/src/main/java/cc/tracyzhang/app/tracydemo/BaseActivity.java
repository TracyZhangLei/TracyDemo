package cc.tracyzhang.app.tracydemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by zl on 17-10-2.
 */

public class BaseActivity extends Activity {

	private static final String TAG = "BaseActivity";
	private String name;

	protected void log(String s){
		if(null == name) {
			String t = this.toString();
			name = " {"+t.substring(t.lastIndexOf(".")+1)+"(TaskId:"+getTaskId()+")} ";
		}
		Log.i(TAG, this.name+s);
	}

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		log("onCreate");
	}

	@Override
	protected void onStart() {
		super.onStart();
		log("onStart");
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		log("onRestart");
	}

	@Override
	protected void onResume() {
		super.onResume();
		log("onResume");
	}

	@Override
	protected void onPostResume() {
		super.onPostResume();
		log("onPostResume");
	}

	@Override
	protected void onNewIntent(Intent intent) {
		super.onNewIntent(intent);
		log("onNewIntent");
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		log("onSaveInstanceState");
	}

	@Override
	protected void onPause() {
		super.onPause();
		log("onPause");
	}

	@Override
	protected void onUserLeaveHint() {
		super.onUserLeaveHint();
		log("onUserLeaveHint");
	}

	@Override
	protected void onStop() {
		super.onStop();
		log("onStop");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		log("onDestroy");
	}

	@Override
	public void onTrimMemory(int level) {
		super.onTrimMemory(level);
		log("onTrimMemory:"+level);
	}
}
