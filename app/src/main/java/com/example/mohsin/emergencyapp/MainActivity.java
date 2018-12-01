package com.example.mohsin.emergencyapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.support.v4.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {

    private static String TAG = "PermissionAudio";
    private static String TAG1 = "PermissionCall";
    private static String TAG2 = "PermissionContact";
    private static String TAG3 = "PermissionFineLocation";
    private static String TAG4 = "PermissionCoarseLocation";
    private static String TAG5 = "PermissionSMS";

    private static final int RECORD_REQUEST_CODE = 101;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int permission = ContextCompat.checkSelfPermission(this,
                Manifest.permission.RECORD_AUDIO);

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


