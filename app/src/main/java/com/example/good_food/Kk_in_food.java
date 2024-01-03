package com.example.good_food;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class  Kk_in_food extends AppCompatActivity{

    Dialog dialog;
    EditText edit_text_kasha;
    EditText edit_text_tvorog;
    EditText edit_text_soup;
    Button btn_see_more_food;
    TextView kasha;
    EditText edit_text_rise, edit_text_fish, edit_text_chikem_or_meat, edit_text_grecha, edit_text_tea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kk_in_food);

        dialog = new Dialog(Kk_in_food.this);

        btn_see_more_food = findViewById(R.id.btn_see_more_food);
        kasha = findViewById(R.id.kasha);

        edit_text_kasha = findViewById(R.id.edit_text_kasha);
        edit_text_tvorog = findViewById(R.id.edit_text_tvorog);
        edit_text_soup = findViewById(R.id.edit_text_soup);
        edit_text_rise = findViewById(R.id.edit_text_rise);
        edit_text_fish = findViewById(R.id.edit_text_fish);
        edit_text_chikem_or_meat = findViewById(R.id.edit_text_chikem_or_meat);
        edit_text_grecha = findViewById(R.id.edit_text_grecha);
        edit_text_tea = findViewById(R.id.edit_text_tea);

    }

    public void btn_save_food_method(View view){
        try {

            String kasha_str = edit_text_kasha.getText().toString();
            String tvorog_str = edit_text_tvorog.getText().toString();
            String soup_str = edit_text_soup.getText().toString();
            String rise_str = edit_text_rise.getText().toString();
            String fish_str = edit_text_fish.getText().toString();
            String meat_str = edit_text_chikem_or_meat.getText().toString();
            String grecha_str = edit_text_grecha.getText().toString();
            String tea_str = edit_text_tea.getText().toString();

            int kasha_num = Integer.parseInt(kasha_str);
            int tvorog_num = Integer.parseInt(tvorog_str);
            int soup_num = Integer.parseInt(soup_str);
            int rise_num = Integer.parseInt(rise_str);
            int fish_num = Integer.parseInt(fish_str);
            int meat_num = Integer.parseInt(meat_str);
            int grecha_num = Integer.parseInt(grecha_str);
            int tea_num = Integer.parseInt(tea_str);

            int result_kashs = (kasha_num / 100) * 95;
            int result_tvorog = (tvorog_num / 100) * 103;
            int result_soup = (soup_num / 100) * 47;
            int result_rise = (rise_num / 100) * 300;
            int result_fish = (fish_num / 100) * 120;
            int result_meat = (meat_num / 100) * 170;
            int result_grecha = (grecha_num / 100) * 310;
            int result_tea = (tea_num / 100) * 79;

            int result_food = result_grecha + result_fish + result_soup + result_tvorog + result_kashs + result_tea + result_meat + result_rise;

            Toast.makeText(this, "Данные сохранены", Toast.LENGTH_SHORT).show();

            String result_food_str = String.valueOf(result_food);

            FileOutputStream fileOutputStream = null;
            fileOutputStream = openFileOutput("user_data_2.txt", MODE_PRIVATE);
            fileOutputStream.write((result_food_str).getBytes());
            fileOutputStream.close();

            edit_text_kasha.setText("0");
            edit_text_tvorog.setText("0");
            edit_text_soup.setText("0");
            edit_text_rise.setText("0");
            edit_text_fish.setText("0");
            edit_text_chikem_or_meat.setText("0");
            edit_text_grecha.setText("0");
            edit_text_tea.setText("0");

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Error: №213dw09", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void imageButton_go_home_in_food(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void btn_see_more_food_method(View view){
//        Toast.makeText(this, "Error: №213dw09", Toast.LENGTH_SHORT).show();

        dialog.setContentView(R.layout.activity_wind_to_web_food);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable((Color.TRANSPARENT)));
        dialog.show();


        Button btn_on_wind_to_web_exit, btn_on_wind_to_web_go;
        btn_on_wind_to_web_exit = dialog.findViewById(R.id.btn_on_wind_to_web_exit);
        btn_on_wind_to_web_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });

        btn_on_wind_to_web_go = dialog.findViewById(R.id.btn_on_wind_to_web_go);
        btn_on_wind_to_web_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start_go_to_web_food();
            }
        });

    }

    public void method_check_data_user(View view){

        dialog.setContentView(R.layout.activity_food_user_check);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

        Button btn_check_in_user_data;
        btn_check_in_user_data = dialog.findViewById(R.id.btn_check_in_user_data);
        btn_check_in_user_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realiz_method_saving_users_data();
            }
        });
    }

    public void realiz_method_saving_users_data(){
        EditText edit_text_user_check_kk = dialog.findViewById(R.id.edit_text_user_check_kk);

        FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = openFileOutput("user_data_2.txt", MODE_PRIVATE);
                fileOutputStream.write((String.valueOf(edit_text_user_check_kk.getText())).getBytes());
                fileOutputStream.close();
                Toast.makeText(this, "Данные сохранены", Toast.LENGTH_SHORT).show();
                edit_text_user_check_kk.setText("0");
            } catch (IOException e) {
                Toast.makeText(this, "SISTEM_Error", Toast.LENGTH_SHORT).show();
            }

    }

    public void start_go_to_web_food(){
        Intent intent = new Intent(this, wed_food.class);
        startActivity(intent);
        finish();
    }

    public void imageButton_go_trains_in_food(View view){
        Intent intent = new Intent(this, Kilo_k_to_trains.class);
        startActivity(intent);
        finish();
    }

    public void btn_settings_in_food(View view){
        dialog.setContentView(R.layout.activity_settings);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

    public void btn_itogs_in_food_method(View view){
        Intent intent = new Intent(this, Itogs.class);
        startActivity(intent);
        finish();
    }

}