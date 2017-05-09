package cc.tracyzhang.app.tracydemo.okhttp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.logging.Logger;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by zl on 17-1-18.
 */

public class OKHttpActivity extends AppCompatActivity {

    private static final String TAG = "OKHttpActivity";

    Logger logger = Logger.getLogger(TAG);

    OkHttpClient client;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                long t1 = System.nanoTime();
                logger.info(String.format("===========Sending request %s on %s%n%s", request.url(), chain.connection(), request.headers()));
                Response response = chain.proceed(request);
                long t2 = System.nanoTime();
                logger.info(String.format("===========Received response for %s in %.1fms%n%s", response.request().url(), (t2 - t1) / 1e6d, response.headers()));
                return response;
            }
        }).build();

        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        final EditText et = new EditText(this);
        et.setText("www.baidu.com");
        ll.addView(et);
        final TextView r = new TextView(this);
        Button btn = new Button(this);
        btn.setText("Start");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String url = "http://"+et.getText().toString();
                        Request request = new Request.Builder().url(url).build();
                        try {
                            final Response response = client.newCall(request).execute();
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if(response.isSuccessful()){
                                        Toast.makeText(getApplicationContext(),"Success!",Toast.LENGTH_SHORT).show();
                                    }else{
                                        Toast.makeText(getApplicationContext(),"Fail!",Toast.LENGTH_SHORT).show();
                                    }
                                    Log.d("ok", "onClick: response="+response.toString());
                                    r.setText(response.toString());
                                }
                            });

                        }catch (Throwable e){e.printStackTrace();}
                    }
                }).start();
            }
        });
        Button btn2 = new Button(this);
        btn2.setText("Post");
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                post("");
            }
        });
        ll.addView(btn);
        ll.addView(btn2);
        ll.addView(r);
        setContentView(ll);
    }


    private void post(final String json){
        new Thread(new Runnable(){
            @Override
            public void run() {
//                RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"),json);
//                RequestBody body = new FormBody.Builder().add("key1","v1").add("k2","v2").build();
//                Request request = new Request.Builder().post(body).url("http://www.baidu.com").build();
//                try {
//                    Response response = client.newCall(request).execute();
//                    if(response.isSuccessful()){
//                        Log.d("", "post: success !");
//                    }else{
//                        Log.d("", "post: fail !");
//                    }
//                }catch (Throwable e){
//                    e.printStackTrace();
//                }


//                Request request = new Request.Builder()
//                        .url("https://api.github.com/repos/square/okhttp/issues")
//                        .header("User-Agent", "OkHttp Headers.java")
//                        .addHeader("Accept", "application/json; q=0.5")
//                        .addHeader("Accept", "application/vnd.github.v3+json")
//                        .build();
//
//                try {
//                    Response response = client.newCall(request).execute();
//                    System.out.println("Server: " + response.header("Server"));
//                    System.out.println("Date: " + response.header("Date"));
//                    System.out.println("Vary: " + response.headers("Vary"));
//
//                    Headers headers = response.headers();
//                    for(int i=0;i<headers.size();i++){
//                        Log.d("", "headers: name="+headers.name(i)+",value="+headers.value(i));
//                    }
//                }catch (Throwable e){e.printStackTrace();}

            }
        }).start();

        Request request = new Request.Builder().url("http://www.github.com").build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e(TAG, "onFailure: "+e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i(TAG, "onResponse: "+response.toString());
            }
        });

    }

}

