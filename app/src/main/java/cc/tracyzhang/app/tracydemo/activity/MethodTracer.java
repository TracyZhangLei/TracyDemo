package cc.tracyzhang.app.tracydemo.activity;

/**
 * Created by zl on 17-10-30.
 */

import android.util.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MethodTracer {

  private static final String TAG = MethodTracer.class.getSimpleName();

  @Before("execution (protected void cc.tracyzhang.app.tracydemo.activity.ActivityA.onCreate(android.os.Bundle))")
  public void adviceOnCreate(JoinPoint joinPoint) {
    Log.w(TAG, "adviceOnCreate: ======ActivityA.onCreate()======="+joinPoint.toString());
  }

  @Before("call(* cc.tracyzhang.app.tracydemo.activity.ActivityA.method1(..))")
  public void bb(){
    Log.w(TAG, "bb:======before method1 ");
  }

}
