package cc.tracyzhang.app.tracydemo.service;

import android.content.IntentFilter;

import cc.tracyzhang.app.tracydemo.broadcast.KillProcessReceiver;

/**
 * Created by zl on 17-10-10.
 */

public class Child2Service extends BaseService {

	@Override
	public void onCreate() {
		super.onCreate();

		IntentFilter filter = new IntentFilter();
		filter.addAction("cc.tracyzhang.app.tracydemo.broadcast.close1111");
		KillProcessReceiver receiver = new KillProcessReceiver();
		registerReceiver(receiver,filter);

	}

}
