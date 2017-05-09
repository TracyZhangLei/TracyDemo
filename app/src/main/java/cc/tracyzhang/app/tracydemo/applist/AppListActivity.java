package cc.tracyzhang.app.tracydemo.applist;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by zl on 17-3-1.
 */

public class AppListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ScrollView sv = new ScrollView(this);

        TextView tv = new TextView(this);

        tv.setText(getInstallApps());

        sv.addView(tv);

        setContentView(sv);

    }

    private String getInstallApps(){
        StringBuffer sb = new StringBuffer();
        PackageManager packageManager = getPackageManager();
        List<PackageInfo> packages = packageManager.getInstalledPackages(0);
        for(int i=0;i<packages.size();i++) {
            PackageInfo packageInfo = packages.get(i);
            sb.append(packageInfo.packageName+"\n");
        }
        return sb.toString();
    }
}
