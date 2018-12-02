package com.example.mohsin.emergencyapp;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by mohsinhussain on 21/05/2017.
 */


class CustomAdapter3 extends ArrayAdapter {


    public CustomAdapter3(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }


    public CustomAdapter3(Context context, List<Whereyatt> listitems) {
        super(context, R.layout.contact_row, listitems);

    }
}




