package cc.tracyzhang.app.tracydemo.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by zl on 17-10-10.
 */

public class BaseService extends Service {

	private static final String TAG = "BaseService";

	@Nullable
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		Log.i(TAG, "onCreate: "+getClass().getSimpleName());
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.i(TAG, "onStartCommand: "+getClass().getSimpleName());
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		Log.i(TAG, "onDestroy: "+getClass().getSimpleName());
		super.onDestroy();
	}
}
