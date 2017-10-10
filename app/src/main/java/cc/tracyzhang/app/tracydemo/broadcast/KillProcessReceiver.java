package cc.tracyzhang.app.tracydemo.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.util.Log;

/**
 * Created by zl on 17-10-10.
 */

public class KillProcessReceiver extends BroadcastReceiver {

	private static final String TAG = "KillProcessReceiver";

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.w(TAG, "onReceive: "+ Process.myPid()+",action:"+intent.getAction());
		if(intent.getAction().equals("cc.tracyzhang.app.tracydemo.broadcast.close")){
			Log.w(TAG, "onReceive: kill process:"+Process.myPid());
			Process.killProcess(Process.myPid());
			System.exit(0);
		}
	}
}
