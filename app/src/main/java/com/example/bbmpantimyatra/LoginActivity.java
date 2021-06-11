package com.example.bbmpantimyatra;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.zitlab.BBMPAntimyatra.library.MobyraClient;
import com.zitlab.palmyra.builder.CriteriaBuilder;
import com.zitlab.palmyra.http.MobyraClientBuilder;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    Button loginbuttonbtn;

    EditText useredit,passwordedit;
    String usernamestr,passwordstr;

    // Storing data into SharedPreferences
    SharedPreferences sharedPreferences;

    // Creating an Editor object to edit(write to the file)
    SharedPreferences.Editor myEdit;

    private ProgressDialog progressDialog;

    ImageView eyeopen,eyeclose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharedPreferences = getSharedPreferences("usercredentialbbmp",MODE_PRIVATE);
        myEdit = sharedPreferences.edit();

        loginbuttonbtn = (Button)findViewById(R.id.loginbutton);
        useredit = (EditText)findViewById(R.id.useredit);
        passwordedit = (EditText)findViewById(R.id.passwordedit);

        eyeopen = (ImageView)findViewById(R.id.eyeopen);
        eyeclose = (ImageView)findViewById(R.id.eyeclose);


        passwordedit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length()!=0){
                    eyeclose.setVisibility(View.GONE);
                    eyeopen.setVisibility(View.VISIBLE);
                }else{
                    eyeclose.setVisibility(View.VISIBLE);
                    eyeopen.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        eyeopen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(passwordedit.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())){
                    //Show Password
                    passwordedit.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else{
                    //Hide Password
                    passwordedit.setTransformationMethod(PasswordTransformationMethod.getInstance());

                }
            }
        });

        useredit.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode == KeyEvent.KEYCODE_ENTER) {
                    passwordedit.requestFocus();
                }
                return true;
            }
        });


        loginbuttonbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usernamestr = useredit.getText().toString();
                passwordstr = passwordedit.getText().toString();


                // Check for Internet Connection
                if (isConnected()) {

                    if(usernamestr != null && passwordstr != null && !usernamestr.isEmpty() && !passwordstr.isEmpty()){
                        loadData(usernamestr,passwordstr);
                    }else {
                        Toast.makeText(LoginActivity.this, "Please enter all field", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private void loadData(String usernameone,String passwordone) {

        progressDialog=new ProgressDialog(LoginActivity.this);
        progressDialog.setMessage("Loading!!!");
        progressDialog.show();

        MobyraClientBuilder builder = new MobyraClientBuilder.Builder("bangalorefinalrites.in")
                .withUsernamePassword("admin", "covid")
                .withContext("testenv")
                .withApiVersion("v2")
                .withLogLevel(MobyraClientBuilder.LogLevel.BASIC)
                .build();
        MobyraClient client = new MobyraClient(builder);

        Map<String, String> map = new HashMap<String,String>();

        client.exec(map, LoginResponse.class, (status, response, exception) -> {

            progressDialog.dismiss();

            String requestloginnamestr = response.getLoginName();

            if(requestloginnamestr != null && !requestloginnamestr.isEmpty()){


                Log.d("Successloginsuccess : ","Successfulloginsuccess : "+requestloginnamestr);

                // Storing the key and its value as the data fetched from edittext
                myEdit.putString("username", usernameone);
                myEdit.putString("password", passwordone);

                // Once the changes have been made,
                // we need to commit to apply those changes made,
                // otherwise, it will throw an error
                myEdit.commit();


                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);


            } else {

                Toast.makeText(this, "Something went wrong! Please try again", Toast.LENGTH_SHORT).show();

            }
        });

    }

    public boolean isConnected() {
        boolean connected = false;
        try {
            ConnectivityManager cm = (ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo nInfo = cm.getActiveNetworkInfo();
            connected = nInfo != null && nInfo.isAvailable() && nInfo.isConnected();
            return connected;
        } catch (Exception e) {
            Log.e("Connectivity Exception", e.getMessage());
        }
        return connected;
    }

}