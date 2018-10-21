package com.beec.ss08;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;


public class DetailPopUp  extends Activity {
    private ListView mainListView ;
    private ArrayAdapter<String> listAdapter ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailwindow);
         mainListView = (ListView) findViewById(R.id.listD);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int widht = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int)widht*8,(int)height*6);
        String[] water = new String[] { "Water must be stored in plastic containers to avoid those that break or decompose\"", "Venus", "Earth", "Mars",
                "Jupiter", "Saturn", "Uranus", "Neptune"};
        ArrayList<String> waterList = new ArrayList<String>();
        waterList.addAll( Arrays.asList(water) );

    }
}
