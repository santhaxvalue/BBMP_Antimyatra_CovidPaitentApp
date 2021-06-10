package com.example.bbmpantimyatra;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zitlab.BBMPAntimyatra.library.MobyraClient;
import com.zitlab.palmyra.http.MobyraClientBuilder;

import java.util.HashMap;
import java.util.Map;

public class DetailsScreen extends AppCompatActivity {


    TextView statussubmittedtxt;
    TextView statusreachedtxt;
    TextView statuscompletedtxt;

    Button reachedbuttontxt;
    Button reachedoffbuttontxt;
    Button completebuttontxt;
    Button completedbuttonofftxt;

    LinearLayout framefourlayout;

    AlertDialog.Builder builder;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_screen);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        builder = new AlertDialog.Builder(this);
        progressDialog=new ProgressDialog(this);

        //Get the bundle
        Bundle bundle = getIntent().getExtras();


        //Extract the data…
        String idstr = bundle.getString("id");
        String cremTokenstr = bundle.getString("cremToken");
        String crematoriumCodestr = bundle.getString("crematoriumCode");


        //formate based on website screen
        String causeOfDeathstr = bundle.getString("causeOfDeath");
        String namestr = bundle.getString("name");
        String yearOfBirthstr = bundle.getString("yearOfBirth");
        String aadhaarstr = bundle.getString("aadhaar");
        String placeOfDeathstr = bundle.getString("placeOfDeath");
        String genderstr = bundle.getString("gender");
        String religionstr = bundle.getString("religion");
        String zonestr = bundle.getString("zone");
        String busrfnostr = bundle.getString("buSrfId");


        String reportedBystr = bundle.getString("reportedBy");
        String mobileNumberstr = bundle.getString("mobileNumber");
        String mobileNumberstr2 = bundle.getString("mobileNumber2");
        String emailAddressstr = bundle.getString("emailAddress");


        String crematoriumNamestr = bundle.getString("crematoriumName");
        String cremDatestr = bundle.getString("cremDate");
        String timeSlotstr = bundle.getString("timeSlot");


        String reqStatusstr = bundle.getString("reqStatus");



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        framefourlayout = findViewById(R.id.framefour);

        TextView namevaltxt = findViewById(R.id.nameval);
        TextView completedtxt = findViewById(R.id.completed);
        TextView reachedtxt = findViewById(R.id.reached);
        TextView cremtokenvaltxt = findViewById(R.id.cremtokenval);

        TextView causeofdeathvaltxt = findViewById(R.id.causeofdeathval);
        TextView birthyearvaltxt = findViewById(R.id.birthyearval);
        TextView aadhaarvaltxt = findViewById(R.id.aadhaarval);
        TextView placeofdeathvaltxt = findViewById(R.id.placeofdeathval);
        TextView gendervaltxt = findViewById(R.id.genderval);
        TextView religionvaltxt = findViewById(R.id.religionval);
        TextView bbmpzonevaltxt = findViewById(R.id.bbmpzoneval);
        TextView busrfnovaltxt = findViewById(R.id.busrfnoval);
        TextView ambulancerequiredvaltxt = findViewById(R.id.ambulancerequiredval);
        TextView nametwovaltxt = findViewById(R.id.nametwoval);
        TextView mobilenumbervaltxt = findViewById(R.id.mobilenumberval);
        TextView additionalmobilevaltxt = findViewById(R.id.additionalmobileval);
        TextView emailaddressvaltxt = findViewById(R.id.emailaddressval);

        TextView crematoriumvaltxt = findViewById(R.id.crematoriumval);
        TextView cremdatevaltxt = findViewById(R.id.cremdateval);
        TextView cremslotvaltxt = findViewById(R.id.cremslotval);

        statussubmittedtxt = findViewById(R.id.statussubmitted);
        statusreachedtxt = findViewById(R.id.statusreached);
        statuscompletedtxt = findViewById(R.id.statuscompleted);

        reachedbuttontxt = findViewById(R.id.reached);
        reachedoffbuttontxt = findViewById(R.id.reachedoff);
        completebuttontxt = findViewById(R.id.completed);
        completedbuttonofftxt = findViewById(R.id.completedoff);

        framefourlayout.setVisibility(View.GONE);

        statuscompletedtxt.setVisibility(View.GONE);
        statusreachedtxt.setVisibility(View.GONE);
        statussubmittedtxt.setVisibility(View.GONE);

        reachedbuttontxt.setVisibility(View.GONE);
        reachedoffbuttontxt.setVisibility(View.GONE);
        completebuttontxt.setVisibility(View.GONE);
        completedbuttonofftxt.setVisibility(View.GONE);

//        Date date = new Date();
//        long timeInMillis = date.getTime();
//        studentCode.setText("SD" + timeInMillis);




        if( causeOfDeathstr != null && !causeOfDeathstr.isEmpty()){
            causeofdeathvaltxt.setText(causeOfDeathstr);
        }else {
            causeofdeathvaltxt.setText("-");
        }

        if( namestr != null && !namestr.isEmpty()){
            namevaltxt.setText(namestr);
        }else {
            namevaltxt.setText("-");
        }


        if( yearOfBirthstr != null && !yearOfBirthstr.isEmpty()){
            birthyearvaltxt.setText(yearOfBirthstr);
        }else {
            birthyearvaltxt.setText("-");
        }

        if( aadhaarstr != null && !aadhaarstr.isEmpty()){
            aadhaarvaltxt.setText(aadhaarstr);
        }else {
            aadhaarvaltxt.setText("-");
        }

        if( placeOfDeathstr != null && !placeOfDeathstr.isEmpty()){
            placeofdeathvaltxt.setText(placeOfDeathstr);
        }else {
            placeofdeathvaltxt.setText("-");
        }


        if( genderstr != null && !genderstr.isEmpty()){
            gendervaltxt.setText(genderstr);
        }else {
            gendervaltxt.setText("-");
        }

        if( religionstr != null && !religionstr.isEmpty()){
            religionvaltxt.setText(religionstr);
        }else {
            religionvaltxt.setText("-");
        }

        if( zonestr != null && !zonestr.isEmpty()){
            bbmpzonevaltxt.setText(zonestr);
        }else {
            bbmpzonevaltxt.setText("-");
        }

        if(busrfnostr != null && !busrfnostr.isEmpty()){
            busrfnovaltxt.setText(busrfnostr);
        }else {
            busrfnovaltxt.setText("-");
        }


        if( reportedBystr != null && !reportedBystr.isEmpty()){
            nametwovaltxt.setText(reportedBystr);
        }else {
            nametwovaltxt.setText("-");
        }

        if( mobileNumberstr != null && !mobileNumberstr.isEmpty()){
            mobilenumbervaltxt.setText(mobileNumberstr);
        }else {
            mobilenumbervaltxt.setText("-");
        }


        if( mobileNumberstr2 != null && !mobileNumberstr2.isEmpty()){
            additionalmobilevaltxt.setText(mobileNumberstr2);
        }else {
            additionalmobilevaltxt.setText("-");
        }

        if( emailAddressstr != null && !emailAddressstr.isEmpty()){
            emailaddressvaltxt.setText(emailAddressstr);

        }else {
            emailaddressvaltxt.setText("-");

        }

        if( crematoriumNamestr != null && !crematoriumNamestr.isEmpty()){
            crematoriumvaltxt.setText(crematoriumNamestr);

        }else {
            crematoriumvaltxt.setText("-");

        }

        if( cremDatestr != null && !cremDatestr.isEmpty()){
            cremdatevaltxt.setText(cremDatestr);

        }else {
            cremdatevaltxt.setText("-");

        }

        if( timeSlotstr != null && !timeSlotstr.isEmpty()){
            cremslotvaltxt.setText(timeSlotstr);

        }else {
            cremslotvaltxt.setText("-");

        }

        if( idstr != null && !idstr.isEmpty()){
            cremtokenvaltxt.setText(idstr);

        }else {
            cremtokenvaltxt.setText("-");

        }





        if(reqStatusstr.contains("Created")){
            statuscompletedtxt.setVisibility(View.GONE);
            statusreachedtxt.setVisibility(View.GONE);
            statussubmittedtxt.setVisibility(View.VISIBLE);

            framefourlayout.setVisibility(View.VISIBLE);

            completedbuttonofftxt.setVisibility(View.VISIBLE);
            completebuttontxt.setVisibility(View.GONE);
            reachedbuttontxt.setVisibility(View.VISIBLE);
            reachedoffbuttontxt.setVisibility(View.GONE);

        }else if(reqStatusstr.contains("Reached")){
            statuscompletedtxt.setVisibility(View.GONE);
            statusreachedtxt.setVisibility(View.VISIBLE);
            statussubmittedtxt.setVisibility(View.GONE);

            framefourlayout.setVisibility(View.VISIBLE);

            completedbuttonofftxt.setVisibility(View.GONE);
            completebuttontxt.setVisibility(View.VISIBLE);
            reachedbuttontxt.setVisibility(View.GONE);
            reachedoffbuttontxt.setVisibility(View.VISIBLE);

        }else if(reqStatusstr.contains("Cremated")){
            statuscompletedtxt.setVisibility(View.VISIBLE);
            statusreachedtxt.setVisibility(View.GONE);
            statussubmittedtxt.setVisibility(View.GONE);

            framefourlayout.setVisibility(View.GONE);

//            completedbuttonofftxt.setVisibility(View.GONE);
//            completebuttontxt.setVisibility(View.GONE);
//            reachedbuttontxt.setVisibility(View.GONE);
//            reachedoffbuttontxt.setVisibility(View.GONE);

        }


        reachedtxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Setting message manually and performing action on button click
                builder.setMessage("Are you sure to change status?")
                        .setCancelable(false)
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();

                                // Check for Internet Connection
                                if (isConnected()) {
                                    String tokennumberstr = cremtokenvaltxt.getText().toString();
                                    loadDataForReached(tokennumberstr);
                                } else {
                                    Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_SHORT).show();
                                }

                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //  Action for 'NO' Button
                                dialog.cancel();
                            }
                        });

                builder.show();


            }
        });


        completedtxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //Setting message manually and performing action on button click
                builder.setMessage("Are you sure to change status?")
                        .setCancelable(false)
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();

                                // Check for Internet Connection
                                if (isConnected()) {
                                    String tokennumberstr = cremtokenvaltxt.getText().toString();
                                    loadDataForCompleted(tokennumberstr);
                                } else {
                                    Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_SHORT).show();
                                }

                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //  Action for 'NO' Button
                                dialog.cancel();
                            }
                        });

                builder.show();

            }
        });


    }


    private void loadDataForReached(String tokennumber) {

//        progressDialog.setMessage("Loading!!!");
//        progressDialog.show();

        Log.d("Successful2: ","Successful2: "+tokennumber);

        //Setting up Mobyra Client
        MobyraClientBuilder builder = new MobyraClientBuilder.Builder("bangalorefinalrites.in")
                .withUsernamePassword("crond", "slot@123")
                .withContext("testenv")
                .withApiVersion("v2")
                .withLogLevel(MobyraClientBuilder.LogLevel.BASIC)
                .build();
        MobyraClient client = new MobyraClient(builder);

//        CriteriaBuilder builder1 = new CriteriaBuilder.Builder()
//                .keyValue("id",tokennumber)
//                .build();
        Map<String, String> map = new HashMap<String,String>();
        map.put("id", tokennumber);

        client.exec(map, ReachedResponse.class, (status, response, exception) -> {


//            progressDialog.dismiss();

            String requestStatusStr = response.getReqStatus();

            if(requestStatusStr != null && !requestStatusStr.isEmpty()){

                Toast.makeText(DetailsScreen.this,"Changed status successfully",
                        Toast.LENGTH_SHORT).show();

                statuscompletedtxt.setVisibility(View.GONE);
                statusreachedtxt.setVisibility(View.VISIBLE);
                statussubmittedtxt.setVisibility(View.GONE);

                framefourlayout.setVisibility(View.VISIBLE);

                completedbuttonofftxt.setVisibility(View.GONE);
                completebuttontxt.setVisibility(View.VISIBLE);
                reachedbuttontxt.setVisibility(View.GONE);
                reachedoffbuttontxt.setVisibility(View.VISIBLE);


            }else {
                Toast.makeText(this, "Something went wrong! Try Again later", Toast.LENGTH_SHORT).show();
            }
//
//            JSONObject jsonObject = null;
//            try {
//                 jsonObject = new JSONObject(response.toString());
//                 String reqstatuStr = jsonObject.get("reqStatus").toString();
//                Log.d("Successful211: ","Successful211: "+reqstatuStr);
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }

//            Log.d("Successful211: ","Successful211: "+responseList.size());
//            if (responseList != null && responseList.size() > 0) {
//
//
//                Log.d("Successful2 : ","Successful2 : "+responseList.get(0).getId());
//
//            } else {
//
//                Log.d("Successfulfailure : ","Successfulfailure : ");
//            }
        });


    }

    private void loadDataForCompleted(String tokennumber) {

//        progressDialog.setMessage("Loading!!!");
//        progressDialog.show();

        Log.d("Successful2: ","Successful2: "+tokennumber);

        //Setting up Mobyra Client
        MobyraClientBuilder builder = new MobyraClientBuilder.Builder("bangalorefinalrites.in")
                .withUsernamePassword("crond", "slot@123")
                .withContext("testenv")
                .withApiVersion("v2")
                .withLogLevel(MobyraClientBuilder.LogLevel.BASIC)
                .build();
        MobyraClient client = new MobyraClient(builder);

//        CriteriaBuilder builder1 = new CriteriaBuilder.Builder()
//                .keyValue("id",tokennumber)
//                .build();
        Map<String, String> map = new HashMap<String,String>();
        map.put("id", tokennumber);

        client.exec(map, CompletedResponse.class, (status, response, exception) -> {

//            progressDialog.dismiss();

            String requestStatusStr = response.getReqStatus();

            if(requestStatusStr != null && !requestStatusStr.isEmpty()){

                Toast.makeText(DetailsScreen.this,"Changed status successfully",
                        Toast.LENGTH_SHORT).show();

                statuscompletedtxt.setVisibility(View.VISIBLE);
                statusreachedtxt.setVisibility(View.GONE);
                statussubmittedtxt.setVisibility(View.GONE);

                framefourlayout.setVisibility(View.GONE);


            }else {
                Toast.makeText(this, "Something went wrong! Try Again later", Toast.LENGTH_SHORT).show();
            }






//
//            JSONObject jsonObject = null;
//            try {
//                 jsonObject = new JSONObject(response.toString());
//                 String reqstatuStr = jsonObject.get("reqStatus").toString();
//                Log.d("Successful211: ","Successful211: "+reqstatuStr);
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }

//            Log.d("Successful211: ","Successful211: "+responseList.size());
//            if (responseList != null && responseList.size() > 0) {
//
//
//                Log.d("Successful2 : ","Successful2 : "+responseList.get(0).getId());
//
//            } else {
//
//                Log.d("Successfulfailure : ","Successfulfailure : ");
//            }
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