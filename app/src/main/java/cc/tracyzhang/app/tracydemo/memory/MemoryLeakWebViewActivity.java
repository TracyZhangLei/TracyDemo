package cc.tracyzhang.app.tracydemo.memory;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import cc.tracyzhang.app.tracydemo.R;

/**
 * Created by zl on 17-3-14.
 */

public class MemoryLeakWebViewActivity extends Activity {

    WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_PROGRESS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_memeoryleak);

        webview = (WebView)findViewById(R.id.webView);

        webview.getSettings().setJavaScriptEnabled(true);

        final Activity activity = this;
        webview.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                activity.setProgress(progress * 1000);
            }
        });
        webview.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(activity, "Oh no! " + description, Toast.LENGTH_SHORT).show();
            }
        });

        webview.loadUrl("http://developer.android.com/");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        webview.removeAllViews();
        webview.destroy();
        webview = null;
        System.exit(0);
    }

    @Override
    public void onBackPressed() {
        if(webview.canGoBack()){
            webview.goBack();
            return;
        }
        super.onBackPressed();
    }
}
