package com.github.martinlacorrona.pacmangame;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {
    private WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE;
        decorView.setSystemUiVisibility(uiOptions);

        wv = new WebView(this);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadUrl("https://martinlacorrona.github.io/pacman-game/");
        wv.setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView view, String url) {
                showGame();
            }
        });

        setContentView(R.layout.loading);
    }

    private void showGame() {
        wv.setVisibility(View.INVISIBLE);
        setContentView(wv);
        wv.setVisibility(View.VISIBLE);
    }
}
