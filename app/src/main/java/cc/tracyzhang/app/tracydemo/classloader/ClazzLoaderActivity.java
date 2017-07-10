package cc.tracyzhang.app.tracydemo.classloader;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import dalvik.system.DexClassLoader;

import java.io.File;
import java.lang.reflect.Method;

import cc.tracyzhang.app.tracydemo.R;

/**
 * Created by zl on 17-7-10.
 */

public class ClazzLoaderActivity extends AppCompatActivity {

  private static final String TAG = "ClazzLoaderActivity";

  TextView tv;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.clazz_loader_activity);

    tv = (TextView)findViewById(R.id.tv);

  }

  public void onClick(View v){

    File jarFile = new File(getExternalCacheDir(),"hello_dex.jar");
    if(!jarFile.exists()){
      Log.e(TAG, "onClick: jar file not exists");
      tv.setText("jar file not exists");
      return;
    }
    DexClassLoader loader = new DexClassLoader(jarFile.getAbsolutePath(),jarFile.getParent(),null,getClassLoader());
    try{
      Class cls = loader.loadClass("com.tracy.demo.SayAndroid");
      Object obj = cls.newInstance();
      Method method = cls.getMethod("sayHi");
      String result = (String)method.invoke(obj);

      tv.setText(result);
      Log.e(TAG, "onClick: class load & invoke success");
    }catch (Throwable e){
      Log.e(TAG, "onClick: "+e);
      tv.setText(e.toString());
    }

  }

}
