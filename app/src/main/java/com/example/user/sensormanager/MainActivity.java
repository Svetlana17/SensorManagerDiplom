package com.example.user.sensormanager;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    SensorAdapter sensorAdapter;
    TextView tvText;
    SensorManager sensorManager;

    List<Sensor> sensorslist;
    List<SensorDiscription> sensorDiscriptions=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.news_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorslist = sensorManager.getSensorList(Sensor.TYPE_ALL);

        for (Sensor sensor : sensorslist) {
            sensorDiscriptions.add(new SensorDiscription(sensor.getName(), String.valueOf(sensor.getType()), sensor.getVendor(), String.valueOf(sensor.getVersion()), String.valueOf(sensor.getMaximumRange()), String.valueOf(sensor.getResolution())));
        }
        sensorAdapter = new SensorAdapter(this, sensorDiscriptions);
        recyclerView.setAdapter(sensorAdapter);
        sensorAdapter.notifyDataSetChanged();
    }




}