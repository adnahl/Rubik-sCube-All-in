package com.example.adnan.rubikscubeallin;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

public class MainActivity extends ActionBarActivity {

    private WebView mWebView;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Start
        mWebView = (WebView) findViewById(R.id.webView);
        // Active Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        // Url load for the App (WebView)
        //mWebView.loadUrl("http://rubikscube.nosaber.com/inicio.html");
        // Forzamos el webview para que abra los enlaces internos dentro de la la APP
        mWebView.setWebViewClient(new WebViewClient());
        // Forzamos el webview para que abra los enlaces externos en el navegador
        mWebView.setWebViewClient(new MyAppWebViewClient());
        // End

        img = (ImageView)findViewById(R.id.img_logo);
    }

        //----------ES
        public void esWeb(View V){
            img.setVisibility(View.INVISIBLE);
            mWebView.loadUrl("http://rubikscube.nosaber.com/indexES.html");
        }

        //----------EN
        public void enWEB(View V) {
            img.setVisibility(View.INVISIBLE);
            mWebView.loadUrl("http://rubikscube.nosaber.com/indexEN.html");
        }


    @Override
    // Detectar cuando se presiona el botón de retroceso
    public void onBackPressed() {
        if(mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
