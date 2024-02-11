package com.example.good_food;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Stack;

public class Kilo_k_to_trains extends AppCompatActivity {

    TextView text_sr_rashod_Kk, u_result_on_u_train_numb;

    public EditText check_hour_edit_text, check_minuts_edit_text;

    public Dialog dialog, dialog_show_2;
    public ImageButton btn_settings_in_trains;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kilo_kto_trains);
        text_sr_rashod_Kk = findViewById(R.id.text_sr_rashod_Kk_chek);
        btn_settings_in_trains = findViewById(R.id.btn_settings_in_trains);
        btn_settings_in_trains.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settings_btn_in_trains();
            }
        });

        dialog = new Dialog(Kilo_k_to_trains.this);

        u_result_on_u_train_numb = findViewById(R.id.u_result_on_u_train_numb);

        check_hour_edit_text = findViewById(R.id.check_hour_edit_text);
        check_minuts_edit_text = findViewById(R.id.check_minuts_edit_text);

        dialog_show_2 = new Dialog(Kilo_k_to_trains.this);

    }

    public void metod_gym_power_train(View view){
        text_sr_rashod_Kk.setText("400Кк/час");

        try {

            u_result_on_u_train_numb.getText().toString();

            String check_hour_edit_text_str = check_hour_edit_text.getText().toString();
            String check_minut_in_minut_str = check_minuts_edit_text.getText().toString();

            int check_hour_in_hour = Integer.parseInt(check_hour_edit_text_str);
            float check_minut_in_minut = Float.parseFloat(check_minut_in_minut_str);
            float itog_num = (((check_minut_in_minut / 60) + check_hour_in_hour) * 400);

            int itog_min_in_int = Math.round(itog_num);

            String itog_min_in_str = String.valueOf(itog_min_in_int);

            FileOutputStream fileOutputStream = null;
            fileOutputStream = openFileOutput("user_data_3.txt", MODE_PRIVATE);
            fileOutputStream.write((itog_min_in_str).getBytes());
            fileOutputStream.close();

            u_result_on_u_train_numb.setText(itog_min_in_str);

            Toast.makeText(this, "Данные сохранены", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = openFileOutput("user_data_3.txt", MODE_PRIVATE);
            } catch (FileNotFoundException ex) {
                Toast.makeText(this, "Error: №213dw09", Toast.LENGTH_SHORT).show();
            }
            try {
                fileOutputStream.write((String.valueOf(0)).getBytes());
            } catch (IOException ex) {
                Toast.makeText(this, "Error: №213dw09", Toast.LENGTH_SHORT).show();
            }
            try {
                fileOutputStream.close();
            } catch (IOException ex) {
                Toast.makeText(this, "Error: №213dw09", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void metod_gym_kross_fit_train(View view){
        text_sr_rashod_Kk.setText("550Кк/час");

        try {

            u_result_on_u_train_numb.getText().toString();

            String check_hour_edit_text_str = check_hour_edit_text.getText().toString();
            String check_minut_in_minut_str = check_minuts_edit_text.getText().toString();

            int check_hour_in_hour = Integer.parseInt(check_hour_edit_text_str);
            float check_minut_in_minut = Float.parseFloat(check_minut_in_minut_str);
            float itog_num = (((check_minut_in_minut / 60) + check_hour_in_hour) * 550);;

            int itog_min_in_int = Math.round(itog_num);

            String itog_min_in_str = String.valueOf(itog_min_in_int);

            FileOutputStream fileOutputStream = null;
            fileOutputStream = openFileOutput("user_data_3.txt", MODE_PRIVATE);
            fileOutputStream.write((itog_min_in_str).getBytes());
            fileOutputStream.close();

            u_result_on_u_train_numb.setText(itog_min_in_str);

            Toast.makeText(this, "Данные сохранены", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = openFileOutput("user_data_3.txt", MODE_PRIVATE);
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            try {
                fileOutputStream.write((String.valueOf(0)).getBytes());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            try {
                fileOutputStream.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void metod_basket_train(View view){
        text_sr_rashod_Kk.setText("380Кк/час");

        try {

            u_result_on_u_train_numb.getText().toString();

            String check_hour_edit_text_str = check_hour_edit_text.getText().toString();
            String check_minut_in_minut_str = check_minuts_edit_text.getText().toString();

            int check_hour_in_hour = Integer.parseInt(check_hour_edit_text_str);
            float check_minut_in_minut = Float.parseFloat(check_minut_in_minut_str);
            float itog_num = (((check_minut_in_minut / 60) + check_hour_in_hour) * 380);;

            int itog_min_in_int = Math.round(itog_num);

            String itog_min_in_str = String.valueOf(itog_min_in_int);

            FileOutputStream fileOutputStream = null;
            fileOutputStream = openFileOutput("user_data_3.txt", MODE_PRIVATE);
            fileOutputStream.write((itog_min_in_str).getBytes());
            fileOutputStream.close();

            u_result_on_u_train_numb.setText(itog_min_in_str);

            Toast.makeText(this, "Данные сохранены", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = openFileOutput("user_data_3.txt", MODE_PRIVATE);
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            try {
                fileOutputStream.write((String.valueOf(0)).getBytes());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            try {
                fileOutputStream.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

    }

    public void metod_tennis_train(View view){
        text_sr_rashod_Kk.setText("400Кк/час");

        try {
            u_result_on_u_train_numb.getText().toString();

            String check_hour_edit_text_str = check_hour_edit_text.getText().toString();
            String check_minut_in_minut_str = check_minuts_edit_text.getText().toString();

            int check_hour_in_hour = Integer.parseInt(check_hour_edit_text_str);
            float check_minut_in_minut = Float.parseFloat(check_minut_in_minut_str);
            float itog_num = (((check_minut_in_minut / 60) + check_hour_in_hour) * 400);;

            int itog_min_in_int = Math.round(itog_num);

            String itog_min_in_str = String.valueOf(itog_min_in_int);

            FileOutputStream fileOutputStream = null;
            fileOutputStream = openFileOutput("user_data_3.txt", MODE_PRIVATE);
            fileOutputStream.write((itog_min_in_str).getBytes());
            fileOutputStream.close();

            u_result_on_u_train_numb.setText(itog_min_in_str);

            Toast.makeText(this, "Данные сохранены", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {

            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = openFileOutput("user_data_3.txt", MODE_PRIVATE);
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            try {
                fileOutputStream.write((String.valueOf(0)).getBytes());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            try {
                fileOutputStream.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void metod_swimming_train(View view){
        text_sr_rashod_Kk.setText("230Кк/час");

        try {
            u_result_on_u_train_numb.getText().toString();

            String check_hour_edit_text_str = check_hour_edit_text.getText().toString();
            String check_minut_in_minut_str = check_minuts_edit_text.getText().toString();

            int check_hour_in_hour = Integer.parseInt(check_hour_edit_text_str);
            float check_minut_in_minut = Float.parseFloat(check_minut_in_minut_str);
            float itog_num = (((check_minut_in_minut / 60) + check_hour_in_hour) * 230);;

            int itog_min_in_int = Math.round(itog_num);

            String itog_min_in_str = String.valueOf(itog_min_in_int);

            FileOutputStream fileOutputStream = null;
            fileOutputStream = openFileOutput("user_data_3.txt", MODE_PRIVATE);
            fileOutputStream.write((itog_min_in_str).getBytes());
            fileOutputStream.close();

            u_result_on_u_train_numb.setText(itog_min_in_str);

            Toast.makeText(this, "Данные сохранены", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {

            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = openFileOutput("user_data_3.txt", MODE_PRIVATE);
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            try {
                fileOutputStream.write((String.valueOf(0)).getBytes());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            try {
                fileOutputStream.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

    }

    public void metod_footboll_train(View view){
        text_sr_rashod_Kk.setText("450Кк/час");

        try {
            u_result_on_u_train_numb.getText().toString();

            String check_hour_edit_text_str = check_hour_edit_text.getText().toString();
            String check_minut_in_minut_str = check_minuts_edit_text.getText().toString();

            int check_hour_in_hour = Integer.parseInt(check_hour_edit_text_str);
            float check_minut_in_minut = Float.parseFloat(check_minut_in_minut_str);
            float itog_num = (((check_minut_in_minut / 60) + check_hour_in_hour) * 450);;

            int itog_min_in_int = Math.round(itog_num);

            String itog_min_in_str = String.valueOf(itog_min_in_int);

            FileOutputStream fileOutputStream = null;
            fileOutputStream = openFileOutput("user_data_3.txt", MODE_PRIVATE);
            fileOutputStream.write((itog_min_in_str).getBytes());
            fileOutputStream.close();

            u_result_on_u_train_numb.setText(itog_min_in_str);

            Toast.makeText(this, "Данные сохранены", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = openFileOutput("user_data_3.txt", MODE_PRIVATE);
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            try {
                fileOutputStream.write((String.valueOf(0)).getBytes());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            try {
                fileOutputStream.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

    }


    //Нижняя часть

    public void imageButton_go_home_method(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void settings_btn_in_trains(){
        dialog.setContentView(R.layout.activity_settings);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

    public void btn_kk_in_train_goToLay_method(View view){
        Intent intent = new Intent(this, Kk_in_food.class);
        startActivity(intent);
        finish();
    }

    public void metod_next_sport_train(View view){
        dialog.setContentView(R.layout.activity_wind_to_web);
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
                start_go_to_web();
            }
        });


    }

    private void start_go_to_web() {
        Intent intent = new Intent(this, Web_activity_trains.class);
        startActivity(intent);
        finish();
    }

    public void btn_itogs_in_trains_method(View view){
        Intent intent = new Intent(this, Itogs.class);
        startActivity(intent);
        finish();
    }



    public void method_check_data_user_trains(View view){

        dialog.setContentView(R.layout.activity_trains_user_check);
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
        String edit_text_user_check_kk_tr_string = edit_text_user_check_kk.getText().toString();
        if (edit_text_user_check_kk_tr_string.isEmpty()){
            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = openFileOutput("user_data_3.txt", MODE_PRIVATE);
                fileOutputStream.write((String.valueOf(0)).getBytes());
                fileOutputStream.close();
                Toast.makeText(Kilo_k_to_trains.this, "Данные сохранены", Toast.LENGTH_SHORT).show();
                edit_text_user_check_kk.setText("0");
            } catch (IOException ew) {
                Toast.makeText(this, "SISTEM_Error", Toast.LENGTH_SHORT).show();
            }
        } else {
            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = openFileOutput("user_data_3.txt", MODE_PRIVATE);
                fileOutputStream.write((String.valueOf(edit_text_user_check_kk.getText())).getBytes());
                fileOutputStream.close();
                Toast.makeText(this, "Данные сохранены", Toast.LENGTH_SHORT).show();
                edit_text_user_check_kk.setText("0");
            } catch (IOException e) {
                Toast.makeText(this, "SISTEM_Error", Toast.LENGTH_SHORT).show();
            }
        }
    }
}