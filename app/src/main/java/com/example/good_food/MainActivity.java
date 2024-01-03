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
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity{

    public EditText editText;
    public String editText_2;

    public TextView title_view_kalkul_kal;

    public Button btn_new_challenge;
    public ImageButton btn_settings_in_gl;
    public Dialog dialog, dialog_show, dialog_show_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_new_challenge = findViewById(R.id.btn_challenge_save);
        btn_settings_in_gl = findViewById(R.id.btn_settings_in_gl);

        dialog = new Dialog(MainActivity.this);
        dialog_show = new Dialog(MainActivity.this);
        dialog_show_2 = new Dialog(MainActivity.this);

        btn_settings_in_gl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settings_btn_in_gl();
            }
        });

        btn_new_challenge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showWindDialog();
            }
        });



    }

    //Кнопки целей - начало


    private void showWindDialog() {

        dialog.setContentView(R.layout.dialog_window_chalenge);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        editText = dialog.findViewById(R.id.new_challenge_kk_edit_text);
        editText_2 = editText.getText().toString();

        dialog.show();

        Button btn_save_in_window_dialog;
        btn_save_in_window_dialog = dialog.findViewById(R.id.btn_save_new_challenge);
        btn_save_in_window_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save_info();
            }
        });
    }

    public void save_info(){

        editText = dialog.findViewById(R.id.new_challenge_kk_edit_text);
        editText_2 = editText.getText().toString();

        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = openFileOutput("user_data.txt", MODE_PRIVATE);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            fileOutputStream.write((editText_2).getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            fileOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Toast.makeText(MainActivity.this, "Данные успешно сохренены в базу данных!", Toast.LENGTH_SHORT).show();
        dialog.cancel();
    }

    public void showWindDialog_p2(View view) {

        dialog.setContentView(R.layout.dialog_window_challenge_show);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        TextView text_12 = dialog.findViewById(R.id.text_u_challenge_in_window_show);

        try {
            FileInputStream fileInputStream = openFileInput("user_data.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            StringBuffer stringBuffer = new StringBuffer();
            String lines = "";

            while ((lines = bufferedReader.readLine()) != null) {
                stringBuffer.append(lines);
            }

            text_12.setText("Ваша цель: " + stringBuffer);

        } catch (IOException e) {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }

        dialog.show();
    }


    //Кнопки целей - конец




    public void metod_kk_on_train(View view){
        Intent intent = new Intent(this, Kilo_k_to_trains.class);
        startActivity(intent);
    }

    public void metod_kk_on_train_in_gl(View view){
        Intent intent = new Intent(this, Kilo_k_to_trains.class);
        startActivity(intent);
    }

    public void settings_btn_in_gl(){
        dialog_show_2.setContentView(R.layout.activity_settings);
        dialog_show_2.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog_show_2.show();
    }

    public void btn_kk_in_food_goToLay(View view){
        Intent intent = new Intent(this, Kk_in_food.class);
        startActivity(intent);
    }

    public void btn_food_in_gl_method(View view){
        Intent intent = new Intent(this, Kk_in_food.class);
        startActivity(intent);
    }

    public void method_go_to_rezim_of_food_in_gl(View view){
        Intent intent = new Intent(this, Rezym_pitaniya.class);
        startActivity(intent);
    }

    public void btn_itogs_in_gl_method(View view){
        Intent intent = new Intent(this, Itogs.class);
        startActivity(intent);
    }

    public void kalendar_btn_method(View view){
        Intent intent = new Intent(this, Itogs.class);
        startActivity(intent);
    }



}

//
//
//    public void new_challenge_kk_metod(View view){
//        EditText editText = findViewById(R.id.new_challenge_kk_edit_text);
//
//        String editText_2 = editText.getText().toString();
//
////записаь в файл и создание, начало
//        FileOutputStream fileOutputStream = null;
//        try {
//            fileOutputStream = openFileOutput("user_data.txt", MODE_PRIVATE);
//            fileOutputStream.write((editText_2).getBytes());
//            fileOutputStream.close();
//
//            Toast.makeText(this, "Данные записаны в системе", Toast.LENGTH_SHORT).show();
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
////записаь в файл и создание, конец
//
//
////чтение с файла, начало
//        TextView kk_number_in_metod = findViewById(R.id.kk_number);
//
//        try {
//            FileInputStream fileInputStream = openFileInput("user_data.txt");
//
//
//            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
//            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//
//            StringBuffer stringBuffer = new StringBuffer();
//            String lines = "";
//
//            while ((lines = bufferedReader.readLine()) != null) {
//                stringBuffer.append(lines);
//            }
//
//            kk_number_in_metod.setText(stringBuffer);
//
//
//
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
////чтение с файла, конец
//
//
//    }


//
//    public void new_challenge_kk_metod_show(View view){
//
//        try {
//            FileInputStream fileInputStream = openFileInput("user_data.txt");
//            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
//            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//
//            StringBuffer stringBuffer = new StringBuffer();
//            String lines = "";
//
//            while ((lines = bufferedReader.readLine()) != null) {
//                stringBuffer.append(lines);
//            }
//
//            Toast.makeText(this, stringBuffer, Toast.LENGTH_LONG).show();
//
//
//
//
//        } catch (IOException e) {
//            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    public void ShowInfoAlert(String text){
//        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//        builder.setTitle("Ваша последняя цель:");
//        builder.setIcon(getDrawable(R.drawable.gym_power_icone));
//
//        builder.setMessage(text);
//        builder.setCancelable(false);
//
//        builder.setNegativeButton("Закрыть", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int which) {
//                dialogInterface.cancel();
//            }
//        });
//
//        AlertDialog dialog = builder.create();
//        dialog.show();
//    }
