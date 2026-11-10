package com.sabaros.asphalteneon;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebResourceRequest;
import android.widget.FrameLayout;
public class MainActivity extends Activity {
    private WebView web;
    @Override public void onCreate(Bundle saved) {
        super.onCreate(saved);
        FrameLayout frame = new FrameLayout(this);
        frame.setBackgroundColor(0xff10151b);
        frame.setOnApplyWindowInsetsListener((v, insets) -> {
            v.setPadding(insets.getSystemWindowInsetLeft(), insets.getSystemWindowInsetTop(), insets.getSystemWindowInsetRight(), insets.getSystemWindowInsetBottom());
            return insets;
        });
        web = new WebView(this);
        web.setBackgroundColor(0xff10151b);
        web.getSettings().setJavaScriptEnabled(true);
        web.getSettings().setDomStorageEnabled(true);
        web.getSettings().setAllowContentAccess(false);
        web.getSettings().setAllowFileAccess(false);
        web.setWebViewClient(new WebViewClient() {
            @Override public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return !request.getUrl().toString().startsWith("file:///android_asset/");
            }
        });
        frame.addView(web, new FrameLayout.LayoutParams(-1,-1));
        setContentView(frame);
        frame.requestApplyInsets();
        web.loadUrl("file:///android_asset/index.html");
    }
    @Override protected void onPause() {
        web.evaluateJavascript("if(typeof state!=='undefined' && state==='running') pause();", null);
        web.onPause(); super.onPause();
    }
    @Override protected void onResume() { super.onResume(); if(web!=null) web.onResume(); }
    @Override protected void onDestroy() { web.destroy(); super.onDestroy(); }
}
