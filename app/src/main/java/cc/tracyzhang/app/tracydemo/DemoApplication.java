package cc.tracyzhang.app.tracydemo;

import android.app.Application;

import com.alipay.euler.andfix.patch.PatchManager;

/**
 * User: zhanglei115
 * Date: 16-5-27
 * Description:
 */
public class DemoApplication extends Application {

    PatchManager patchManager;
    private static DemoApplication instance;

    public static DemoApplication getInstance() {
        return instance;
    }
    public PatchManager getPatchManager() {
        return patchManager;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        new Thread(new Runnable() {
            @Override
            public void run() {
                patchManager = new PatchManager(instance);
                patchManager.init(BuildConfig.VERSION_NAME);
                patchManager.loadPatch();
            }
        }).start();
    }
}
