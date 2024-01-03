package com.example.good_food;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

public class Rezym_pitaniya extends AppCompatActivity {

    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rezym_pitaniya);

        dialog = new Dialog(Rezym_pitaniya.this);

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
        Intent intent = new Intent(this, Itogs.class);
        startActivity(intent);
        finish();
    }
    public void imageButton_go_food_in_rezim_method(View view){
        Intent intent = new Intent(this, Kk_in_food.class);
        startActivity(intent);
        finish();
    }

    public void go_to_wind_zavtrak_method(View view){

        dialog.setContentView(R.layout.activity_zavtrak_btn_wind);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

    }

    public void go_to_wind_launch_method(View view){

        dialog.setContentView(R.layout.activity_launch_btn_wind);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

    }

    public void go_to_wind_dinner_method(View view){
        dialog.setContentView(R.layout.activity_dinner_btn_wind);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

    public void go_to_wind_fast_food_method(View view){
        dialog.setContentView(R.layout.activity_fast_food_btn_wind);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

}