package com.example.bbmpantimyatra;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

public class SplashScreen extends AppCompatActivity {

    SharedPreferences sh;



    // Creating an Editor object to edit(write to the file)
    SharedPreferences.Editor myEdit;

    String usernamestr,passwordstr;



    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // Retrieving the value using its keys the file name
        // must be same in both saving and retrieving the data
        sh = getSharedPreferences("usercredentialbbmp", MODE_APPEND);
        myEdit = sh.edit();

        usernamestr = sh.getString("username", "");
        passwordstr = sh.getString("password", "");


        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {

                if(usernamestr != null && passwordstr != null && !usernamestr.isEmpty() && !passwordstr.isEmpty()){
                    // This method will be executed once the timer is over
                    Intent i = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }else{
                    Intent intent = new Intent(SplashScreen.this,LoginActivity.class);
                    startActivity(intent);
                    finish();
                }


            }
        }, 5000);

    }
}