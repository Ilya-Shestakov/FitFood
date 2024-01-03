package com.example.good_food;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Next_trains_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_trains);
    }

    public void metod_back_to_gym_power(View view){
        Intent intent = new Intent(this, Kilo_k_to_trains.class);
        startActivity(intent);
        finish();
    }

}