package com.example.epidemicsimulator;

import static android.content.Context.SENSOR_SERVICE;

import android.app.Activity;
import android.app.Dialog;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

public class ExploreHandler{

    public static SensorManager manager;
    public static Sensor sensor;
    public static float prevX,prevY,prevZ;
    public static double S;
    public static long lastTime;
    public static int stepCount = 0;
    public static TextView stepText;

    public static void startExploration(Player mPlayer, Activity activity){
        Dialog dialog =  new Dialog(activity);
        dialog.setContentView(R.layout.dialog_explore);
        int width = WindowManager.LayoutParams.MATCH_PARENT;
        //initialize height
        int height = WindowManager.LayoutParams.WRAP_CONTENT;
        //set layout
        dialog.getWindow().setLayout(width,height);
        //show dialog
        dialog.show();
        stepText=dialog.findViewById(R.id.step_text);
        SensorEventListener SL= new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                long CurrentTime=System.currentTimeMillis();
                long xTime=CurrentTime-lastTime;

                if(xTime<80)return;
                float x = sensorEvent.values[0];
                float y = sensorEvent.values[1];
                float z = sensorEvent.values[2];

                float DX=x-prevX;
                float DY=y-prevY;
                float DZ=z-prevZ;

                S=Math.sqrt((Math.pow(DX,2)+Math.pow(DY,2)+Math.pow(DZ,2))/xTime*1000);
                if(S>=100 && S<=200){
                    stepCount++;
                    stepText.setText(Integer.toString(stepCount));
                }

                lastTime=CurrentTime;
                prevX=x;
                prevY=y;
                prevZ=z;

                if(stepCount>=100){dialog.dismiss();}
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };


        manager = (SensorManager) activity.getSystemService(SENSOR_SERVICE);
        sensor = manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        manager.registerListener(SL,sensor,SensorManager.SENSOR_DELAY_NORMAL);




    }





}
