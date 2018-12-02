package com.example.mohsin.emergencyapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.support.v4.app.ActivityCompat;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.location.Address;
import android.location.Geocoder;
import android.media.Image;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static String TAG = "PermissionAudio";
    private static String TAG1 = "PermissionCall";
    private static String TAG2 = "PermissionContact";
    private static String TAG3 = "PermissionFineLocation";
    private static String TAG4 = "PermissionCoarseLocation";
    private static String TAG5 = "PermissionSMS";

    private static final int RECORD_REQUEST_CODE = 101;


    ImageView settingButton;
    ImageView policeButton;
    ImageView lonelyButton;
    ImageView litButton;
    ImageView scaredButton;
    TextView customButton;
    public String cityName ="city not found";
    MyDBHandler dbHandler;

    public String police = "Police Encounter";
    public String lonely = "Lonely";
    public String lit = "its Lit";
    public String scared = "Scared";
    public String custom = "custom";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int permission = ContextCompat.checkSelfPermission(this,
                Manifest.permission.RECORD_AUDIO);

        settingButton = (ImageView) findViewById(R.id.setting);
        policeButton = (ImageView) findViewById(R.id.pl);
        lonelyButton = (ImageView) findViewById(R.id.l);
        litButton = (ImageView) findViewById(R.id.lit);
        scaredButton = (ImageView) findViewById(R.id.s);
        customButton = (TextView) findViewById(R.id.c);


        final SharedPreferences sharedpref1 = getSharedPreferences("permission", Context.MODE_PRIVATE);
        //Toast.makeText(getBaseContext(),boopolice,Toast.LENGTH_SHORT).show();



        MyDBHandler db1 = new MyDBHandler(this,null, null, 1);







        // String stateName = addresses.get(0).getAddressLine(1);
        // String countryName = addresses.get(0).getAddressLine(2);
        //  nameOfLocation = ConvertPointToLocation(stringLatitude,stringLongitude);


        dbHandler = new MyDBHandler(this, null, null, 1);

        settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, Setting.class));


            }
        });

        policeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //  AlertDialog.Builder alertDialog = new AlertDialog.Builder(getBaseContext());

                //  AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getApplicationContext());


                AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                builder1.setMessage("Do you want to?");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "Message",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {


                                Intent intent = new Intent(MainActivity.this, MessageSend.class);
                                intent.putExtra("product", police);
                                startActivity(intent);
                                    /*
                                    AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                                    builder1.setMessage("Who do you want to call?");
                                    builder1.setCancelable(true);


                                    builder1.setPositiveButton(
                                            "Message",
                                            new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog, int id) {

                                                    AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                                                    builder1.setMessage("Do you want to?");
                                                    builder1.setCancelable(true);

                                                 boolean boopolice = sharedpref1.getBoolean("policesms",false);
                                                    if(boopolice) {
                                                        Intent smsIntent = new Intent(android.content.Intent.ACTION_VIEW);
                                                        smsIntent.setType("vnd.android-dir/mms-sms");
                                                        smsIntent.putExtra("address", "090078601");
                                                        // smsIntent.putExtra("sms_body", "i am in a police encounter at" + cityName);
                                                        smsIntent.putExtra("sms_body", "i am in a police encounter at " + cityName);
                                                        startActivity(smsIntent);
                                                    }
                                                    else{

                                                        AlertDialog.Builder builder2 = new AlertDialog.Builder(MainActivity.this);
                                                        builder2.setMessage("map is not enabled");
                                                        builder2.setCancelable(true);
                                                        AlertDialog alertuser = builder2.create();
                                                        alertuser.show();
                                                    }

                                                }
                                            });
                                    AlertDialog alert12 = builder1.create();
                                    alert12.show();
                               */
                            }
                        });

                builder1.setNegativeButton(
                        "Call",

                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent = new Intent(MainActivity.this, CallSend.class);
                                intent.putExtra("product", police);
                                startActivity(intent);
                            }
                        }
                );
                builder1.setNeutralButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();
            }
        });

        lonelyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //  AlertDialog.Builder alertDialog = new AlertDialog.Builder(getBaseContext());
                Activity mActivity = null;

                //  AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getApplicationContext());

                AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                builder1.setMessage("Do you want to?");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "Message",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {


                                Intent intent = new Intent(MainActivity.this, MessageSend.class);
                                intent.putExtra("product",lonely);
                                startActivity(intent);





                            }
                        });

                builder1.setNegativeButton(
                        "Call",

                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent = new Intent(MainActivity.this, CallSend.class);
                                intent.putExtra("product", lonely);
                                startActivity(intent);
                            }
                        }
                );

                builder1.setNeutralButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();

            }
        });
        litButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //  AlertDialog.Builder alertDialog = new AlertDialog.Builder(getBaseContext());
                Activity mActivity = null;

                //  AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getApplicationContext());

                AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                builder1.setMessage("Do you want to?");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "Message",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {


                                Intent intent = new Intent(MainActivity.this, MessageSend.class);
                                intent.putExtra("product",lit);
                                startActivity(intent);



                            }
                        });

                builder1.setNegativeButton(
                        "Call",

                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent = new Intent(MainActivity.this, CallSend.class);
                                intent.putExtra("product", lit);
                                startActivity(intent);
                            }
                        }
                );
                builder1.setNeutralButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();

            }
        });
        scaredButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //  AlertDialog.Builder alertDialog = new AlertDialog.Builder(getBaseContext());
                Activity mActivity = null;

                //  AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getApplicationContext());

                AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                builder1.setMessage("Do you want to?");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "Message",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {


                                Intent intent = new Intent(MainActivity.this, MessageSend.class);
                                intent.putExtra("product",scared);
                                startActivity(intent);



                            }
                        });

                builder1.setNegativeButton(
                        "Call",

                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent = new Intent(MainActivity.this, CallSend.class);
                                intent.putExtra("product", scared);
                                startActivity(intent);
                            }
                        }
                );

                builder1.setNeutralButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();

            }
        });
        customButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //  AlertDialog.Builder alertDialog = new AlertDialog.Builder(getBaseContext());
                Activity mActivity = null;

                //  AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getApplicationContext());

                AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                builder1.setMessage("Do you want to?");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "Message",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {


                                Intent intent = new Intent(MainActivity.this, MessageSend.class);
                                intent.putExtra("product",custom);
                                startActivity(intent);



                            }
                        });
                builder1.setNegativeButton(
                        "Call",

                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent = new Intent(MainActivity.this, CallSend.class);
                                intent.putExtra("product", custom);
                                startActivity(intent);
                            }
                        }
                );

                builder1.setNeutralButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();

            }

        });

        if (permission != PackageManager.PERMISSION_GRANTED) {
            Log.i(TAG, "Permission to record denied");
            makeRequest();
        }

        int permission1 = ContextCompat.checkSelfPermission(this,
                Manifest.permission.CALL_PHONE);

        if (permission1 != PackageManager.PERMISSION_GRANTED) {
            Log.i(TAG1, "Permission to call denied");
            makeRequest();
        }


        int permission2 = ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_CONTACTS);

        if (permission2 != PackageManager.PERMISSION_GRANTED) {
            Log.i(TAG2, "Permission to read contacts denied");
            makeRequest();
        }
        int permission3 = ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION);

        if (permission3 != PackageManager.PERMISSION_GRANTED) {
            Log.i(TAG3, "Permission to call denied");
            makeRequest();
        }



        int permission4 = ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION);

        if (permission4 != PackageManager.PERMISSION_GRANTED) {
            Log.i(TAG4, "Permission to access fine location denied");
            makeRequest();
        }

        int permission5 = ContextCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS);

        if (permission5 != PackageManager.PERMISSION_GRANTED) {
            Log.i(TAG5, "Permission to send sms denied");
            makeRequest();
        }




    }
    protected void makeRequest() {
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.RECORD_AUDIO,
                             Manifest.permission.CALL_PHONE,
                             Manifest.permission.READ_CONTACTS,
                             Manifest.permission.ACCESS_COARSE_LOCATION,
                             Manifest.permission.ACCESS_FINE_LOCATION,
                             Manifest.permission.SEND_SMS,
                },
                RECORD_REQUEST_CODE);
    }



    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case RECORD_REQUEST_CODE: {

                if (grantResults.length == 0
                        || grantResults[0] !=
                        PackageManager.PERMISSION_GRANTED) {

                    Log.i(TAG, "Permission has been denied by user");
                } else {
                    Log.i(TAG, "Permission has been granted by user");
                }
                return;
            }
        }
    }

}


