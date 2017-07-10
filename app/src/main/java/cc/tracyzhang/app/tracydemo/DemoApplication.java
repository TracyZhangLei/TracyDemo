package cc.tracyzhang.app.tracydemo;

import android.app.Application;

import com.jingdong.sdk.permission.PermissionHelper;

/**
 * User: zhanglei115
 * Date: 16-5-27
 * Description:
 */
public class DemoApplication extends Application {

    private static DemoApplication instance;

    public static DemoApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        PermissionHelper.install(this);
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                patchManager = new PatchManager(instance);
//                patchManager.init(BuildConfig.VERSION_NAME);
//                patchManager.loadPatch();
//            }
//        }).start();
    }
}
