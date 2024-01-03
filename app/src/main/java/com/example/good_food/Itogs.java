package com.example.good_food;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Itogs extends AppCompatActivity {

    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itogs);
        dialog = new Dialog(Itogs.this);
    }

    public void imageButton_go_home_in_food(View view){
        Intent intent = new Intent(this, MainActivity.class);
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

    public void btn_food_in_gl_method(View view){
        Intent intent = new Intent(this, Kk_in_food.class);
        startActivity(intent);
        finish();
    }

    public void imageButton5_in_food_method(View view){
        Intent intent = new Intent(this, Kk_in_food.class);
        startActivity(intent);
        finish();
    }

    String stringBuffer_str = "0";
    public String nu_kak_bu_nado_to_chell(){
        try {
            //
            FileInputStream fileInputStream = openFileInput("user_data.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            StringBuffer stringBuffer = new StringBuffer();
            String lines = "";

            while ((lines = bufferedReader.readLine()) != null) {
                stringBuffer.append(lines);
            }

            stringBuffer_str = String.valueOf(stringBuffer);

        } catch (IOException e){
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }

        return stringBuffer_str;

    }
    String stringBuffer2_str = "0";
    public String nu_kak_bu_nado_to_eat(){
        try {
            FileInputStream fileInputStream2 = openFileInput("user_data_2.txt");
            InputStreamReader inputStreamReader2 = new InputStreamReader(fileInputStream2);
            BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader2);

            StringBuffer stringBuffer2 = new StringBuffer();
            String lines2 = "";

            while ((lines2 = bufferedReader2.readLine()) != null) {
                stringBuffer2.append(lines2);
            }

            stringBuffer2_str = String.valueOf(stringBuffer2);

        } catch (IOException e){
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }
        return stringBuffer2_str;
    }

    public String nu_kak_bu_nado_to_sport(){
        String stringBuffer3_str = "0";
        try {
            FileInputStream fileInputStream3 = openFileInput("user_data_3.txt");
            InputStreamReader inputStreamReader3 = new InputStreamReader(fileInputStream3);
            BufferedReader bufferedReader3 = new BufferedReader(inputStreamReader3);

            StringBuffer stringBuffer3 = new StringBuffer();
            String lines3 = "";

            while ((lines3 = bufferedReader3.readLine()) != null) {
                stringBuffer3.append(lines3);
            }

            stringBuffer3_str = String.valueOf(stringBuffer3);

        } catch (IOException e){
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }
        return stringBuffer3_str;
    }


/**
 ПОНЕДЕЛЬНИК
*/

    public void mondey_method(View view){
        dialog.setContentView(R.layout.activity_monday_wind);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

        Button btn_go_schot_in_wind_mon = dialog.findViewById(R.id.btn_go_schot_in_wind_mon);

        btn_go_schot_in_wind_mon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            prim_data_mon();
            }
        });
    }

    public void prim_data_mon() {

        TextView now_chall_in_mon = dialog.findViewById(R.id.now_chall_in_mon);
        TextView now_result_in_mon = dialog.findViewById(R.id.now_result_in_mon);
        TextView now_itog_in_mon = dialog.findViewById(R.id.now_itog_in_mon);
        TextView now_trains_in_mon = dialog.findViewById(R.id.now_trains_in_mon);

        Integer stringBuffer2_int = Integer.parseInt(nu_kak_bu_nado_to_eat());
        Integer stringBuffer3_int = Integer.parseInt(nu_kak_bu_nado_to_sport());

        now_chall_in_mon.setText(nu_kak_bu_nado_to_chell());
        now_result_in_mon.setText(nu_kak_bu_nado_to_eat());
        now_trains_in_mon.setText(nu_kak_bu_nado_to_sport());

        // StringBuffer - Цель
        // StringBuffer2 - Съедено
        // StringBuffer3 - потрачено

        //расчёт strB_4 - итоговый результат

        FileOutputStream fileOutputStream = null;

        if (stringBuffer2_int >= stringBuffer3_int){
            int razj = stringBuffer2_int - stringBuffer3_int;
//для проверки  Toast.makeText(this, String.valueOf(rezn_itog_sk_potracheno), Toast.LENGTH_SHORT).show();
            now_itog_in_mon.setText("За сегодня вы набрали " + razj + " калорий");
            try {
                fileOutputStream = openFileOutput("user_data_monday.txt", MODE_PRIVATE);
                fileOutputStream.write((String.valueOf(razj)).getBytes());
                fileOutputStream.close();

                Toast.makeText(this, "Данные записаны в системе", Toast.LENGTH_SHORT).show();
            } catch (IOException e){
                Toast.makeText(this, "Error 21f2%w2#11", Toast.LENGTH_SHORT).show();
            }
        } else if (stringBuffer3_int >= stringBuffer2_int) {
            int pohudel = stringBuffer3_int - stringBuffer2_int;
            int pohudel_otr = stringBuffer2_int - stringBuffer3_int;
            now_itog_in_mon.setText("За сегодня вы потратили " + pohudel + " калорий");

            try {
                fileOutputStream = openFileOutput("user_data_monday.txt", MODE_PRIVATE);
                fileOutputStream.write((String.valueOf(pohudel_otr)).getBytes());
                fileOutputStream.close();

                Toast.makeText(this, "Данные записаны в системе", Toast.LENGTH_SHORT).show();
            } catch (IOException e){
                Toast.makeText(this, "Error 21f2%w2#11", Toast.LENGTH_SHORT).show();
            }

        }
    }



    /**
     * ВТОРНИК
     */

    public void tuesday_method(View view){
        dialog.setContentView(R.layout.activity_thuesday_wind);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

        Button btn_go_schot_in_wind_thu = dialog.findViewById(R.id.btn_go_schot_in_wind_thu);

        btn_go_schot_in_wind_thu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prim_data_thu();
            }
        });
    }

    public void prim_data_thu(){

        TextView now_chall_in_mon = dialog.findViewById(R.id.now_chall_in_thu);
        TextView now_result_in_mon = dialog.findViewById(R.id.now_result_in_thu);
        TextView now_itog_in_mon = dialog.findViewById(R.id.now_itog_in_mon);
        TextView now_trains_in_mon = dialog.findViewById(R.id.now_trains_in_thu);


        Integer stringBuffer_int = Integer.parseInt(nu_kak_bu_nado_to_chell());
        Integer stringBuffer2_int = Integer.parseInt(nu_kak_bu_nado_to_eat());
        Integer stringBuffer3_int = Integer.parseInt(nu_kak_bu_nado_to_sport());

        now_chall_in_mon.setText(nu_kak_bu_nado_to_chell());
        now_result_in_mon.setText(nu_kak_bu_nado_to_eat());
        now_trains_in_mon.setText(nu_kak_bu_nado_to_sport());

        // StringBuffer - Цель
        // StringBuffer2 - Съедено
        // StringBuffer3 - потрачено

        //расчёт strB_4 - итоговый результат

        FileOutputStream fileOutputStream = null;

        if (stringBuffer2_int >= stringBuffer3_int){
            int razj = stringBuffer2_int - stringBuffer3_int;
//для проверки  Toast.makeText(this, String.valueOf(rezn_itog_sk_potracheno), Toast.LENGTH_SHORT).show();
            now_itog_in_mon.setText("За сегодня вы набрали " + razj + " калорий");
            try {
                fileOutputStream = openFileOutput("user_data_thuesday.txt", MODE_PRIVATE);
                fileOutputStream.write((String.valueOf(razj)).getBytes());
                fileOutputStream.close();

                Toast.makeText(this, "Данные записаны в системе", Toast.LENGTH_SHORT).show();
            } catch (IOException e){
                Toast.makeText(this, "Error 21f2%w2#11", Toast.LENGTH_SHORT).show();
            }
        } else if (stringBuffer3_int >= stringBuffer2_int) {
            int pohudel = stringBuffer3_int - stringBuffer2_int;
            int pohudel_otr = stringBuffer2_int - stringBuffer3_int;
            now_itog_in_mon.setText("За сегодня вы потратили " + pohudel + " калорий");

            try {
                fileOutputStream = openFileOutput("user_data_thuesday.txt", MODE_PRIVATE);
                fileOutputStream.write((String.valueOf(pohudel_otr)).getBytes());
                fileOutputStream.close();

                Toast.makeText(this, "Данные записаны в системе", Toast.LENGTH_SHORT).show();
            } catch (IOException e){
                Toast.makeText(this, "Error 21f2%w2#11", Toast.LENGTH_SHORT).show();
            }

        }
    }


   /**
    * СРЕДА
    */

   public void thursday_method(View view){
       dialog.setContentView(R.layout.activity_thursday_wind);
       dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
       dialog.show();

       Button btn_go_schot_in_wind_mon = dialog.findViewById(R.id.btn_go_schot_in_wind_thur);

       btn_go_schot_in_wind_mon.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               prim_data_thur();
           }
       });
   }

   public void prim_data_thur(){
       TextView now_chall_in_mon = dialog.findViewById(R.id.now_chall_in_mon);
       TextView now_result_in_mon = dialog.findViewById(R.id.now_result_in_mon);
       TextView now_itog_in_mon = dialog.findViewById(R.id.now_itog_in_mon);
       TextView now_trains_in_mon = dialog.findViewById(R.id.now_trains_in_mon);


       Integer stringBuffer_int = Integer.parseInt(nu_kak_bu_nado_to_chell());
       Integer stringBuffer2_int = Integer.parseInt(nu_kak_bu_nado_to_eat());
       Integer stringBuffer3_int = Integer.parseInt(nu_kak_bu_nado_to_sport());

       now_chall_in_mon.setText(nu_kak_bu_nado_to_chell());
       now_result_in_mon.setText(nu_kak_bu_nado_to_eat());
       now_trains_in_mon.setText(nu_kak_bu_nado_to_sport());

       // StringBuffer - Цель
       // StringBuffer2 - Съедено
       // StringBuffer3 - потрачено

       //расчёт strB_4 - итоговый результат

       FileOutputStream fileOutputStream = null;

       if (stringBuffer2_int >= stringBuffer3_int){
           int razj = stringBuffer2_int - stringBuffer3_int;
//для проверки  Toast.makeText(this, String.valueOf(rezn_itog_sk_potracheno), Toast.LENGTH_SHORT).show();
           now_itog_in_mon.setText("За сегодня вы набрали " + razj + " калорий");
           try {
               fileOutputStream = openFileOutput("user_data_thursday.txt", MODE_PRIVATE);
               fileOutputStream.write((String.valueOf(razj)).getBytes());
               fileOutputStream.close();

               Toast.makeText(this, "Данные записаны в системе", Toast.LENGTH_SHORT).show();
           } catch (IOException e){
               Toast.makeText(this, "Error 21f2%w2#11", Toast.LENGTH_SHORT).show();
           }
       } else if (stringBuffer3_int >= stringBuffer2_int) {
           int pohudel = stringBuffer3_int - stringBuffer2_int;
           int pohudel_otr = stringBuffer2_int - stringBuffer3_int;
           now_itog_in_mon.setText("За сегодня вы потратили " + pohudel + " калорий");

           try {
               fileOutputStream = openFileOutput("user_data_thursday.txt", MODE_PRIVATE);
               fileOutputStream.write((String.valueOf(pohudel_otr)).getBytes());
               fileOutputStream.close();

               Toast.makeText(this, "Данные записаны в системе", Toast.LENGTH_SHORT).show();
           } catch (IOException e){
               Toast.makeText(this, "Error 21f2%w2#11", Toast.LENGTH_SHORT).show();
           }

       }
   }


    /**
     * ЧЕТВЕРГ
     */


    public void thoursday_method(View view){
        dialog.setContentView(R.layout.activity_thoursday_wind);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

        Button btn_go_schot_in_wind_thour = dialog.findViewById(R.id.btn_go_schot_in_wind_thour);

        btn_go_schot_in_wind_thour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prim_data_thour();
            }
        });
    }

    public void prim_data_thour(){
        TextView now_chall_in_mon = dialog.findViewById(R.id.now_chall_in_mon);
        TextView now_result_in_mon = dialog.findViewById(R.id.now_result_in_mon);
        TextView now_itog_in_mon = dialog.findViewById(R.id.now_itog_in_mon);
        TextView now_trains_in_mon = dialog.findViewById(R.id.now_trains_in_mon);


        Integer stringBuffer2_int = Integer.parseInt(nu_kak_bu_nado_to_eat());
        Integer stringBuffer3_int = Integer.parseInt(nu_kak_bu_nado_to_sport());

        now_chall_in_mon.setText(nu_kak_bu_nado_to_chell());
        now_result_in_mon.setText(nu_kak_bu_nado_to_eat());
        now_trains_in_mon.setText(nu_kak_bu_nado_to_sport());

        // StringBuffer - Цель
        // StringBuffer2 - Съедено
        // StringBuffer3 - потрачено

        //расчёт strB_4 - итоговый результат

        FileOutputStream fileOutputStream = null;

        if (stringBuffer2_int >= stringBuffer3_int){
            int razj = stringBuffer2_int - stringBuffer3_int;
//для проверки  Toast.makeText(this, String.valueOf(rezn_itog_sk_potracheno), Toast.LENGTH_SHORT).show();
            now_itog_in_mon.setText("За сегодня вы набрали " + razj + " калорий");
            try {
                fileOutputStream = openFileOutput("user_data_thoursday.txt", MODE_PRIVATE);
                fileOutputStream.write((String.valueOf(razj)).getBytes());
                fileOutputStream.close();

                Toast.makeText(this, "Данные записаны в системе", Toast.LENGTH_SHORT).show();
            } catch (IOException e){
                Toast.makeText(this, "Error 21f2%w2#11", Toast.LENGTH_SHORT).show();
            }
        } else if (stringBuffer3_int >= stringBuffer2_int) {
            int pohudel = stringBuffer3_int - stringBuffer2_int;
            int pohudel_otr = stringBuffer2_int - stringBuffer3_int;
            now_itog_in_mon.setText("За сегодня вы потратили " + pohudel + " калорий");

            try {
                fileOutputStream = openFileOutput("user_data_thoursday.txt", MODE_PRIVATE);
                fileOutputStream.write((String.valueOf(pohudel_otr)).getBytes());
                fileOutputStream.close();

                Toast.makeText(this, "Данные записаны в системе", Toast.LENGTH_SHORT).show();
            } catch (IOException e){
                Toast.makeText(this, "Error 21f2%w2#11", Toast.LENGTH_SHORT).show();
            }

        }
    }

    /**
     * ПЯТНИЦА
     */

    public void friday_method(View view){
        dialog.setContentView(R.layout.activity_frieday_wind);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

        Button btn_go_schot_in_wind_friday = dialog.findViewById(R.id.btn_go_schot_in_wind_friday);

        btn_go_schot_in_wind_friday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prim_data_friday();
            }
        });
    }

    public void prim_data_friday(){
        TextView now_chall_in_mon = dialog.findViewById(R.id.now_chall_in_mon);
        TextView now_result_in_mon = dialog.findViewById(R.id.now_result_in_mon);
        TextView now_itog_in_mon = dialog.findViewById(R.id.now_itog_in_mon);
        TextView now_trains_in_mon = dialog.findViewById(R.id.now_trains_in_mon);


        Integer stringBuffer2_int = Integer.parseInt(nu_kak_bu_nado_to_eat());
        Integer stringBuffer3_int = Integer.parseInt(nu_kak_bu_nado_to_sport());

        now_chall_in_mon.setText(nu_kak_bu_nado_to_chell());
        now_result_in_mon.setText(nu_kak_bu_nado_to_eat());
        now_trains_in_mon.setText(nu_kak_bu_nado_to_sport());

        // StringBuffer - Цель
        // StringBuffer2 - Съедено
        // StringBuffer3 - потрачено

        //расчёт strB_4 - итоговый результат

        FileOutputStream fileOutputStream = null;

        if (stringBuffer2_int >= stringBuffer3_int){
            int razj = stringBuffer2_int - stringBuffer3_int;
//для проверки  Toast.makeText(this, String.valueOf(rezn_itog_sk_potracheno), Toast.LENGTH_SHORT).show();
            now_itog_in_mon.setText("За сегодня вы набрали " + razj + " калорий");
            try {
                fileOutputStream = openFileOutput("user_data_friday.txt", MODE_PRIVATE);
                fileOutputStream.write((String.valueOf(razj)).getBytes());
                fileOutputStream.close();

                Toast.makeText(this, "Данные записаны в системе", Toast.LENGTH_SHORT).show();
            } catch (IOException e){
                Toast.makeText(this, "Error 21f2%w2#11", Toast.LENGTH_SHORT).show();
            }
        } else if (stringBuffer3_int >= stringBuffer2_int) {
            int pohudel = stringBuffer3_int - stringBuffer2_int;
            int pohudel_otr = stringBuffer2_int - stringBuffer3_int;
            now_itog_in_mon.setText("За сегодня вы потратили " + pohudel + " калорий");

            try {
                fileOutputStream = openFileOutput("user_data_friday.txt", MODE_PRIVATE);
                fileOutputStream.write((String.valueOf(pohudel_otr)).getBytes());
                fileOutputStream.close();

                Toast.makeText(this, "Данные записаны в системе", Toast.LENGTH_SHORT).show();
            } catch (IOException e){
                Toast.makeText(this, "Error 21f2%w2#11", Toast.LENGTH_SHORT).show();
            }

        }
    }


    /**
     * СУББОТА
     */

    public void soturday_method(View view){
        dialog.setContentView(R.layout.activity_soturday_wind);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

        Button btn_go_schot_in_wind_soturday = dialog.findViewById(R.id.btn_go_schot_in_wind_soturday);

        btn_go_schot_in_wind_soturday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prim_data_soturday();
            }
        });
    }

    public void prim_data_soturday(){
        TextView now_chall_in_mon = dialog.findViewById(R.id.now_chall_in_mon);
        TextView now_result_in_mon = dialog.findViewById(R.id.now_result_in_mon);
        TextView now_itog_in_mon = dialog.findViewById(R.id.now_itog_in_mon);
        TextView now_trains_in_mon = dialog.findViewById(R.id.now_trains_in_mon);


        Integer stringBuffer2_int = Integer.parseInt(nu_kak_bu_nado_to_eat());
        Integer stringBuffer3_int = Integer.parseInt(nu_kak_bu_nado_to_sport());

        now_chall_in_mon.setText(nu_kak_bu_nado_to_chell());
        now_result_in_mon.setText(nu_kak_bu_nado_to_eat());
        now_trains_in_mon.setText(nu_kak_bu_nado_to_sport());

        // StringBuffer - Цель
        // StringBuffer2 - Съедено
        // StringBuffer3 - потрачено

        //расчёт strB_4 - итоговый результат

        FileOutputStream fileOutputStream = null;

        if (stringBuffer2_int >= stringBuffer3_int){
            int razj = stringBuffer2_int - stringBuffer3_int;
//для проверки  Toast.makeText(this, String.valueOf(rezn_itog_sk_potracheno), Toast.LENGTH_SHORT).show();
            now_itog_in_mon.setText("За сегодня вы набрали " + razj + " калорий");
            try {
                fileOutputStream = openFileOutput("user_data_soturday.txt", MODE_PRIVATE);
                fileOutputStream.write((String.valueOf(razj)).getBytes());
                fileOutputStream.close();

                Toast.makeText(this, "Данные записаны в системе", Toast.LENGTH_SHORT).show();
            } catch (IOException e){
                Toast.makeText(this, "Error 21f2%w2#11", Toast.LENGTH_SHORT).show();
            }
        } else if (stringBuffer3_int >= stringBuffer2_int) {
            int pohudel = stringBuffer3_int - stringBuffer2_int;
            int pohudel_otr = stringBuffer2_int - stringBuffer3_int;
            now_itog_in_mon.setText("За сегодня вы потратили " + pohudel + " калорий");

            try {
                fileOutputStream = openFileOutput("user_data_soturday.txt", MODE_PRIVATE);
                fileOutputStream.write((String.valueOf(pohudel_otr)).getBytes());
                fileOutputStream.close();

                Toast.makeText(this, "Данные записаны в системе", Toast.LENGTH_SHORT).show();
            } catch (IOException e){
                Toast.makeText(this, "Error 21f2%w2#11", Toast.LENGTH_SHORT).show();
            }

        }
    }


    /**
     * ВОСКРЕСЕНЬЕ
     */

    public void sunday_method(View view){
        dialog.setContentView(R.layout.activity_sunday_wind);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

        Button btn_go_schot_in_wind_sunday = dialog.findViewById(R.id.btn_go_schot_in_wind_sunday);

        btn_go_schot_in_wind_sunday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prim_data_sunday();
            }
        });
    }

    public void prim_data_sunday(){
        TextView now_chall_in_mon = dialog.findViewById(R.id.now_chall_in_mon);
        TextView now_result_in_mon = dialog.findViewById(R.id.now_result_in_mon);
        TextView now_itog_in_mon = dialog.findViewById(R.id.now_itog_in_mon);
        TextView now_trains_in_mon = dialog.findViewById(R.id.now_trains_in_mon);


        Integer stringBuffer2_int = Integer.parseInt(nu_kak_bu_nado_to_eat());
        Integer stringBuffer3_int = Integer.parseInt(nu_kak_bu_nado_to_sport());

        now_chall_in_mon.setText(nu_kak_bu_nado_to_chell());
        now_result_in_mon.setText(nu_kak_bu_nado_to_eat());
        now_trains_in_mon.setText(nu_kak_bu_nado_to_sport());

        // StringBuffer - Цель
        // StringBuffer2 - Съедено
        // StringBuffer3 - потрачено

        //расчёт strB_4 - итоговый результат

        FileOutputStream fileOutputStream = null;

        if (stringBuffer2_int >= stringBuffer3_int){
            int razj = stringBuffer2_int - stringBuffer3_int;
//для проверки  Toast.makeText(this, String.valueOf(rezn_itog_sk_potracheno), Toast.LENGTH_SHORT).show();
            now_itog_in_mon.setText("За сегодня вы набрали " + razj + " калорий");
            try {
                fileOutputStream = openFileOutput("user_data_sunday.txt", MODE_PRIVATE);
                fileOutputStream.write((String.valueOf(razj)).getBytes());
                fileOutputStream.close();

                Toast.makeText(this, "Данные записаны в системе", Toast.LENGTH_SHORT).show();
            } catch (IOException e){
                Toast.makeText(this, "Error 21f2%w2#11", Toast.LENGTH_SHORT).show();
            }
        } else if (stringBuffer3_int >= stringBuffer2_int) {
            int pohudel = stringBuffer3_int - stringBuffer2_int;
            int pohudel_otr = stringBuffer2_int - stringBuffer3_int;
            now_itog_in_mon.setText("За сегодня вы потратили " + pohudel + " калорий");

            try {
                fileOutputStream = openFileOutput("user_data_sunday.txt", MODE_PRIVATE);
                fileOutputStream.write((String.valueOf(pohudel_otr)).getBytes());
                fileOutputStream.close();

                Toast.makeText(this, "Данные записаны в системе", Toast.LENGTH_SHORT).show();
            } catch (IOException e){
                Toast.makeText(this, "Error 21f2%w2#11", Toast.LENGTH_SHORT).show();
            }

        }
    }


    /**
     * ПОКАЗАТЬ РЕЗУЛЬТАТ
     */

    public void pokaz_resoult(View view){
        dialog.setContentView(R.layout.activity_result_wind_all_pro_gg);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

        Button proizv_reschets = dialog.findViewById(R.id.proizv_reschets);

        proizv_reschets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proizv_resoult();
            }
        });

    }

    public void proizv_resoult(){
        //Toast.makeText(this, "Prov-1", Toast.LENGTH_SHORT).show();

        try {

            //Понедельник считывание данных

            FileInputStream fileInputStream_mon = openFileInput("user_data_monday.txt");
            InputStreamReader inputStreamReader_mon = new InputStreamReader(fileInputStream_mon);
            BufferedReader bufferedReader_mon = new BufferedReader(inputStreamReader_mon);

            StringBuffer stringBuffer_monay = new StringBuffer();
            String lines_monday = "";

            while ((lines_monday = bufferedReader_mon.readLine()) != null) {
                stringBuffer_monay.append(lines_monday);
            }

            int stringBuffer_monay_int = Integer.parseInt(String.valueOf(stringBuffer_monay));



            //Вторник считывание данных

            FileInputStream fileInputStream_thu = openFileInput("user_data_thuesday.txt");
            InputStreamReader inputStreamReader_thu = new InputStreamReader(fileInputStream_thu);
            BufferedReader bufferedReader_thu = new BufferedReader(inputStreamReader_thu);

            StringBuffer stringBuffer_thues = new StringBuffer();
            String lines_thues = "";

            while ((lines_thues = bufferedReader_thu.readLine()) != null) {
                stringBuffer_thues.append(lines_thues);
            }

            int stringBuffer_thues_int = Integer.parseInt(String.valueOf(stringBuffer_thues));


            //Среда считывание данных

            FileInputStream fileInputStream_thur = openFileInput("user_data_thursday.txt");
            InputStreamReader inputStreamReader_thur = new InputStreamReader(fileInputStream_thur);
            BufferedReader bufferedReader_thur = new BufferedReader(inputStreamReader_thur);

            StringBuffer stringBuffer_thurs = new StringBuffer();
            String lines_thurs = "";

            while ((lines_thurs = bufferedReader_thur.readLine()) != null) {
                stringBuffer_thurs.append(lines_thurs);
            }

            int stringBuffer_thursday_int = Integer.parseInt(String.valueOf(stringBuffer_thurs));


            //Четверг считывание данных

            FileInputStream fileInputStream_thour = openFileInput("user_data_thoursday.txt");
            InputStreamReader inputStreamReader_thour = new InputStreamReader(fileInputStream_thour);
            BufferedReader bufferedReader_thour = new BufferedReader(inputStreamReader_thour);

            StringBuffer stringBuffer_thours = new StringBuffer();
            String lines_thours = "";

            while ((lines_thours = bufferedReader_thour.readLine()) != null) {
                stringBuffer_thours.append(lines_thours);
            }

            int stringBuffer_thoursday_int = Integer.parseInt(String.valueOf(stringBuffer_thours));




            //Пятница считывание данных

            FileInputStream fileInputStream_friday = openFileInput("user_data_friday.txt");
            InputStreamReader inputStreamReader_friday = new InputStreamReader(fileInputStream_friday);
            BufferedReader bufferedReader_friday = new BufferedReader(inputStreamReader_friday);

            StringBuffer stringBuffer_friday = new StringBuffer();
            String lines_friday = "";

            while ((lines_friday = bufferedReader_friday.readLine()) != null) {
                stringBuffer_friday.append(lines_friday);
            }

            int stringBuffer_friday_int = Integer.parseInt(String.valueOf(stringBuffer_friday));



            //Суббота считывание данных

            FileInputStream fileInputStream_soturday = openFileInput("user_data_soturday.txt");
            InputStreamReader inputStreamReader_soturday = new InputStreamReader(fileInputStream_soturday);
            BufferedReader bufferedReader_soturday = new BufferedReader(inputStreamReader_soturday);

            StringBuffer stringBuffer_soturday = new StringBuffer();
            String lines_soturday = "";

            while ((lines_soturday = bufferedReader_soturday.readLine()) != null) {
                stringBuffer_soturday.append(lines_soturday);
            }

            int stringBuffer_soturday_int = Integer.parseInt(String.valueOf(stringBuffer_soturday));



            //Воскресенье считывание данных

            FileInputStream fileInputStream_sun = openFileInput("user_data_sunday.txt");
            InputStreamReader inputStreamReader_sun = new InputStreamReader(fileInputStream_sun);
            BufferedReader bufferedReader_sun = new BufferedReader(inputStreamReader_sun);

            StringBuffer stringBuffer_sun = new StringBuffer();
            String lines_sun = "";

            while ((lines_sun = bufferedReader_sun.readLine()) != null) {
                stringBuffer_sun.append(lines_sun);
            }

            int stringBuffer_sun_int = Integer.parseInt(String.valueOf(stringBuffer_sun));


            //КОНЕЦ СЧИТЫВАНИЯ

            FileInputStream fileInputStream = openFileInput("user_data.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            StringBuffer stringBuffer_it = new StringBuffer();
            String lines = "";

            while ((lines = bufferedReader.readLine()) != null) {
                stringBuffer_it.append(lines);
            }

            stringBuffer_str = String.valueOf(stringBuffer_it);

            int RESULT = stringBuffer_monay_int + stringBuffer_thues_int + stringBuffer_thursday_int + stringBuffer_thoursday_int + stringBuffer_friday_int + stringBuffer_soturday_int + stringBuffer_sun_int;

            TextView itog_for_chell = dialog.findViewById(R.id.itog_for_chell);

            if (Integer.parseInt(stringBuffer_str) >= RESULT){
                itog_for_chell.setText("Цель: " + stringBuffer_str + "\nуспешно");
            } else {
                itog_for_chell.setText("Цель:" + stringBuffer_str + "\n провал!");
            }

            TextView osn_text = dialog.findViewById(R.id.osn_text);

            if (RESULT < 0){
                int Res_int = RESULT * -1;
                osn_text.setText("Вы похудели на " + Res_int + " колорий");
            } else if (RESULT > 0){
                osn_text.setText("Вы набрали "+RESULT+" колорий");
            } else {
                osn_text.setText("Вес не изменился");
            }

//            Toast.makeText(this, String.valueOf(RESULT), Toast.LENGTH_SHORT).show();


            TextView monday_res = dialog.findViewById(R.id.monday_result);
            monday_res.setText(String.valueOf(stringBuffer_monay_int));

            TextView vtornik_res = dialog.findViewById(R.id.vtornik_result);
            vtornik_res.setText(String.valueOf(stringBuffer_thues_int));

            TextView sreda_result = dialog.findViewById(R.id.sreda_result);
            sreda_result.setText(String.valueOf(stringBuffer_thursday_int));

            TextView chetverg_res = dialog.findViewById(R.id.chetv_result);
            chetverg_res.setText(String.valueOf(stringBuffer_thoursday_int));

            TextView friday_res = dialog.findViewById(R.id.friday_result);
            friday_res.setText(String.valueOf(stringBuffer_friday_int));

            TextView subbota_result = dialog.findViewById(R.id.subbota_result);
            subbota_result.setText(String.valueOf(stringBuffer_soturday_int));

            TextView sunday_res = dialog.findViewById(R.id.sunday_result);
            sunday_res.setText(String.valueOf(stringBuffer_sun_int));



        } catch (IOException e){
            Toast.makeText(this, "SISTEM_Error", Toast.LENGTH_SHORT).show();
        }
    
    }
}