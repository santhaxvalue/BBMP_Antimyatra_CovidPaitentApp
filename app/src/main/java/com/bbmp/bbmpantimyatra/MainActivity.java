package com.bbmp.bbmpantimyatra;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.zitlab.BBMPAntimyatra.library.MobyraClient;
import com.zitlab.palmyra.builder.CriteriaBuilder;
import com.zitlab.palmyra.http.MobyraClientBuilder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText tokennubmeredit;
    Button searchoneebutton,searchtwobutton;

    private List<ResultNew> responseList = new ArrayList<>();

    private ProgressDialog progressDialog;

    String usernamestr,passwordstr;
    SharedPreferences sh;


    // Creating an Editor object to edit(write to the file)
    SharedPreferences.Editor myEdit;


    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // Retrieving the value using its keys the file name
        // must be same in both saving and retrieving the data
        sh = getSharedPreferences("usercredentialbbmp", MODE_APPEND);
        myEdit = sh.edit();




        usernamestr = sh.getString("username", "");
        passwordstr = sh.getString("password", "");

        Log.d("username1:","username1:"+usernamestr);
        Log.d("username11:","username11:"+passwordstr);


        tokennubmeredit = (EditText)findViewById(R.id.tokennumber);
        searchoneebutton = (Button)findViewById(R.id.searchone);
        searchtwobutton = (Button)findViewById(R.id.searchtwo);

        tokennubmeredit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length()!=0){
                    searchoneebutton.setVisibility(View.GONE);
                    searchtwobutton.setVisibility(View.VISIBLE);
                }else{
                    searchoneebutton.setVisibility(View.VISIBLE);
                    searchtwobutton.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        searchtwobutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Check for Internet Connection
                if (isConnected()) {
                    String tokennumber_str = tokennubmeredit.getText().toString();
                    if(tokennumber_str.length() !=0 && !tokennumber_str.isEmpty()){

                        loadData(tokennumber_str);
                    }else{
                        Toast.makeText(MainActivity.this, "Pleae enter valid cremToken number", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_SHORT).show();
                }



            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.logout_one:
                logOutMethod();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void logOutMethod() {

        myEdit.clear().commit();
        Intent intent = new Intent(MainActivity.this,LoginActivity.class);
        startActivity(intent);

    }

    private void loadData(String tokennumber) {


        progressDialog=new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading!!!");
        progressDialog.show();


        //Setting up Mobyra Client
//        MobyraClientBuilder builder = new MobyraClientBuilder.Builder("bangalorefinalrites.in")
//                .withUsernamePassword("admin", "covid")
//                .withContext("testenv")
//                .withApiVersion("v2")
//                .withLogLevel(MobyraClientBuilder.LogLevel.BASIC)
//                .build();
        MobyraClientBuilder builder = new MobyraClientBuilder.Builder("bangalorefinalrites.in")
                .withUsernamePassword(usernamestr, passwordstr)
                .withContext("testenv")
                .withApiVersion("v2")
                .withLogLevel(MobyraClientBuilder.LogLevel.BASIC)
                .build();
        MobyraClient client = new MobyraClient(builder);

        CriteriaBuilder builder1 = new CriteriaBuilder.Builder()
                .keyValue("cremToken",tokennumber)
                .build();
        Log.d("Successful1 : ","Successful1 : "+builder.toString());

        client.query(builder1, ResultNew.class, (status, response, exception) -> {


            progressDialog.dismiss();

            try {
                responseList = response.getResult();

                Log.d("Successful : ", "Successful : " + responseList.size());
                if (responseList != null && responseList.size() > 0) {


                    Log.d("Successful1 : ", "Successful1 : " + responseList.get(0).getName());


                    Intent intent = new Intent(this, DetailsScreen.class);
                    //Create the bundle
                    Bundle bundle = new Bundle();

                    //Add your data to bundle
                    bundle.putString("id", String.valueOf(responseList.get(0).getId()));
                    bundle.putString("name", responseList.get(0).getName());
                    bundle.putString("address", responseList.get(0).getAddress());
                    bundle.putString("gender", responseList.get(0).getGender());
                    bundle.putString("religion", responseList.get(0).getReligion());
                    bundle.putString("reqStatus", responseList.get(0).getReqStatus());

                    bundle.putString("reqStatusCode", responseList.get(0).getReqStatusCode());

                    bundle.putString("yearOfBirth", responseList.get(0).getYearOfBirth());
                    bundle.putString("zone", responseList.get(0).getZone());
                    bundle.putString("causeOfDeath", responseList.get(0).getCauseOfDeath());
                    bundle.putString("placeOfDeath", responseList.get(0).getPlaceOfDeath());
                    bundle.putString("reportedBy", responseList.get(0).getReportedBy());
                    bundle.putString("mobileNumber", responseList.get(0).getMobileNumber());
                    bundle.putString("mobileNumber2", responseList.get(0).getMobileNumber2());
                    bundle.putString("aadhaar", responseList.get(0).getAadhaar());
                    bundle.putString("emailAddress", responseList.get(0).getEmailAddress());
                    bundle.putString("crematoriumName", responseList.get(0).getCrematoriumName());
                    bundle.putString("cremToken", responseList.get(0).getCremToken());
                    bundle.putString("cremDate", responseList.get(0).getCremDate());
                    bundle.putString("timeSlot", responseList.get(0).getTimeSlot());
                    bundle.putString("crematoriumCode", responseList.get(0).getCrematoriumCode());
                    bundle.putString("buSrfId", responseList.get(0).getBuSrfId());




                    //Add the bundle to the intent
                    intent.putExtras(bundle);
                    startActivity(intent);


                } else {

                    Toast.makeText(this, "Pleae enter valid cremToken number", Toast.LENGTH_SHORT).show();

                }

            }catch (NullPointerException e){
                Toast.makeText(this, "Username and Password incorrect", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
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

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}