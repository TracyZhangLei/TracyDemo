package cc.tracyzhang.app.tracydemo.rxjava;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import cc.tracyzhang.app.tracydemo.R;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by zl on 17-5-17.
 */

public class RxJavaDemo extends Activity {

  private static final String TAG = "RxJavaDemo";

  String[] names = {"tracy", "kobe"};

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.rx_java);

    Observable.fromArray(names).subscribe(new Observer<String>() {
      @Override
      public void onSubscribe(@NonNull Disposable d) {
        Log.d(TAG, "onSubscribe: " + d);
      }

      @Override
      public void onNext(@NonNull String s) {
        Log.d(TAG, "onNext: " + s);
      }

      @Override
      public void onError(@NonNull Throwable e) {
        Log.d(TAG, "onError: " + e);
      }

      @Override
      public void onComplete() {
        Log.d(TAG, "onComplete: ");
      }
    });

    new Thread(new Runnable() {
      @Override
      public void run() {
        t2();
      }
    }).start();

    Log.d(TAG, "onCreate: "+Thread.currentThread().getName());

//    Observable.just(names).map(s->s.hashCode()).subscribe(i-> Log.d(TAG, "onCreate: "+i));


    Observable.just("one","two").map(new Function<String, String>() {
      @Override
      public String apply(@NonNull String s) throws Exception {
        return s+":";
      }
    }).take(1).subscribe(new Observer<String>() {
      @Override
      public void onSubscribe(@NonNull Disposable d) {
        
      }

      @Override
      public void onNext(@NonNull String s) {
        Log.d(TAG, "onNext: 111====>"+s);
      }

      @Override
      public void onError(@NonNull Throwable e) {

      }

      @Override
      public void onComplete() {

      }
    });

  }

  private void t2(){

    Observable.fromArray(names).map(new Function<String, String>() {
      @Override
      public String apply(@NonNull String s) throws Exception {
        return s.toUpperCase();
      }
    }).subscribeOn(Schedulers.newThread()).subscribe(new Observer<String>() {
      @Override
      public void onSubscribe(@NonNull Disposable d) {
        Log.d(TAG, "onSubscribe: "+Thread.currentThread().getName());
        try {
          Thread.sleep(10 * 1000);
        }catch (Throwable e){}
      }

      @Override
      public void onNext(@NonNull String s) {
        Log.d(TAG, "onNext: "+Thread.currentThread().getName());
        Log.d(TAG, "onNext: "+s);
      }

      @Override
      public void onError(@NonNull Throwable e) {

      }

      @Override
      public void onComplete() {
        Log.d(TAG, "onComplete: "+Thread.currentThread().getName());
      }
    });
  }
}
