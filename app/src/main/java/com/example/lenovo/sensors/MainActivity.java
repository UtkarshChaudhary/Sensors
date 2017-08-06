package com.example.lenovo.sensors;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import static android.hardware.Sensor.TYPE_ACCELEROMETER;
import static android.hardware.Sensor.TYPE_ALL;
import static android.hardware.Sensor.TYPE_LIGHT;
import static android.provider.MediaStore.ACTION_IMAGE_CAPTURE;

public class MainActivity extends AppCompatActivity implements SensorEventListener{

    SensorManager mSensorManager;
    private static final int REQUEST_IMAGE_CAPTURE = 100;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//       SensorManager sensorManager=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
//
//
//        List<Sensor> sensors=sensorManager.getSensorList(TYPE_ALL);
//        //TO get sensors list in the mobile
//
//        for(Sensor sensor:sensors){
//            Log.d("sensor",sensor.getName());
//        }
//
//        Sensor accSensor=sensorManager.getDefaultSensor(TYPE_ACCELEROMETER);
//        //to get default sensor corresponding to accelerometer if our device don't have accelerometer sensor than its value will be null
//
//        sensorManager.registerListener(this,accSensor,SensorManager.SENSOR_DELAY_NORMAL);
//        //SENSOR_DELAY_NORMAL denotes time after which we need reading of sensor
//        Sensor lightSensor=sensorManager.getDefaultSensor(TYPE_LIGHT);
//        if(lightSensor!=null){
//            sensorManager.registerListener(this,lightSensor,SensorManager.SENSOR_DELAY_NORMAL);
//        }
        imageView=(ImageView)findViewById(R.id.imageView);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
//        float x=event.values[0];
//        float y=event.values[1];
//        float z=event.values[2];

//        float lux=event.values[0];
//        textView.setText(lux +"lx");
    }
public void openCamera(View view){
    Intent takePictureIntent=new Intent();
    takePictureIntent.setAction(ACTION_IMAGE_CAPTURE);
    startActivityForResult(takePictureIntent,REQUEST_IMAGE_CAPTURE);
}
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_IMAGE_CAPTURE&&resultCode==RESULT_OK&&data!=null){
            Bitmap bitmap=(Bitmap)data.getExtras().get("data");
            //bitmap is a format to store image
            imageView.setImageBitmap(bitmap);
        }
    }
}
