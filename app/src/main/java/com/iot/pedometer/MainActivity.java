package com.iot.pedometer;
import android.content.Intent;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.PersistableBundle;
import android.view.View;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements SensorEventListener{
    TextView tv_sensor;
    SensorManager sm;
    Sensor sensor_step_detector;
    private ProgressBar progressBar;

    int steps=0;

    @Override
    public void onSensorChanged(SensorEvent event) {
        switch (event.sensor.getType()){
            case Sensor.TYPE_STEP_COUNTER:
                tv_sensor.setText(""+(++steps));
                progressBar.setProgress(steps);
                break;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("test","onCreateCalled");
        tv_sensor=(TextView) findViewById(R.id.textView);
        tv_sensor.setText("0");

        sm=(SensorManager) getSystemService(SENSOR_SERVICE);
        sensor_step_detector=sm.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);

        progressBar=(ProgressBar) findViewById(R.id.progressBar);

        if(sensor_step_detector !=null) {
            sm.registerListener(this,sensor_step_detector,SensorManager.SENSOR_DELAY_FASTEST);}

        ImageView imageView=(ImageView) findViewById(R.id.imageView);
        imageView.setColorFilter(Color.parseColor("#787878"));
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, setActivity.class);
                startActivity(intent);
            }
        });
        if(setActivity.context_main!=null){
            String goal2= ((setActivity)setActivity.context_main).goal;
            progressBar.setMax(Integer.parseInt(goal2));
        }




    }
}