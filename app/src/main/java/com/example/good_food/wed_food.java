package com.example.good_food;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class wed_food extends AppCompatActivity {

    private WebView webView;

    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wed_food);

        dialog = new Dialog(wed_food.this);

        webView = findViewById(R.id.webViev);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl("https://rsport.ria.ru/20220514/kaloriynost-1788483172.html");
        webView.setWebViewClient(new WebViewClient());

    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }


    public void imageButton_go_home_in_rezim_method(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    public void imageButton_go_trains_in_rezim_method(View view){
        Intent intent = new Intent(this, Kilo_k_to_trains.class);
        startActivity(intent);
        finish();
    }
    public void imageButton_go_settings_in_rezim_method(View view){
        dialog.setContentView(R.layout.activity_settings);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }
    public void imageButton_go_challenge_in_rezim_method(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    public void imageButton_go_food_in_rezim_method(View view){
        Intent intent = new Intent(this, Kk_in_food.class);
        startActivity(intent);
        finish();
    }


}