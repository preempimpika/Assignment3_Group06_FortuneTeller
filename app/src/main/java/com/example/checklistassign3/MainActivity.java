package com.example.checklistassign3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.util.Log;
import android.content.Context;
import android.content.DialogInterface;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;
    private int randomNumber;

    private Handler handler;
   // private Sensor accelerometer;
    private static final int POLL_INTERVAL = 500;
    private static final int shake_threshold = 20;
 //   private TextView randomTextView;
    SensorInfo sensor_info = new SensorInfo();
    Boolean shown_dialog = false;

    private Runnable pollTask = new Runnable() {
        public void run() {
            showDialog();
            handler.postDelayed(pollTask, POLL_INTERVAL);

        }
    }; //class for threshold

    @SuppressLint({"ServiceCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
 //       randomTextView = findViewById(R.id.RandomTextView);

        handler = new Handler(Looper.getMainLooper());

        // Get a reference to the TextView
//        randomTextView = findViewById(R.id.RandomTextView);

        // Start checking for shake events
//        startShakeDetection();
    } //end of onCreate

//    private void startShakeDetection() {
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                generateRandomNumber();
//                // Adjust the delay time based on your requirements
//                handler.postDelayed(this, 1000); // Check for shake every 1000 milliseconds (1 second)
//            }
//        }, 1000); // Initial delay before checking for shake events
//    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        int type = sensorEvent.sensor.getType();
        if (type == Sensor.TYPE_ACCELEROMETER) {
            sensor_info.accX = sensorEvent.values[0];
            sensor_info.accY = sensorEvent.values[1];
            sensor_info.accZ = sensorEvent.values[2];
        }
    //  no work from here
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    private void generateRandomNumber() {
        randomNumber = (int) (Math.random() * 28) + 1;
       // Log.d("RandomNumber", "Generated random number: " + randomNumber);
        // Do something with the random number
    }
    public void showDialog() {
        Resources res = getResources();
        final String[] oracle = res.getStringArray(R.array.oracle);
            if ((Math.abs(sensor_info.accX) > shake_threshold) ||
                (Math.abs(sensor_info.accY) > shake_threshold) ||
               (Math.abs(sensor_info.accZ) > shake_threshold))
            {
                if (!shown_dialog)
                {
                    shown_dialog = true;
                    generateRandomNumber();
                    final AlertDialog.Builder viewDialog = new AlertDialog.Builder(this);
                    viewDialog.setTitle("Your Prophecy is");
                    viewDialog.setIcon(R.drawable.logo);
                    if (randomNumber == 1)
                    {
                        viewDialog.setMessage( randomNumber+ " " +oracle[0] );

                    }
                    else if(randomNumber == 2){
                        viewDialog.setMessage( randomNumber+ " " +oracle[1] );

                    }
                    else if(randomNumber == 3){
                        viewDialog.setMessage( randomNumber+ " " +oracle[2] );

                    }
                    else if(randomNumber == 4){
                        viewDialog.setMessage( randomNumber+ " " +oracle[3] );

                    }
                    else if(randomNumber == 5){
                        viewDialog.setMessage( randomNumber+ " " +oracle[4] );

                    }
                    else if(randomNumber == 6){
                        viewDialog.setMessage( randomNumber+ " " +oracle[5] );

                    }
                    else if(randomNumber == 7){
                        viewDialog.setMessage( randomNumber+ " " +oracle[6] );

                    }
                    else if(randomNumber == 8){
                        viewDialog.setMessage( randomNumber+ " " +oracle[7] );

                    }
                    else if(randomNumber == 9){
                        viewDialog.setMessage( randomNumber+ " " +oracle[8] );

                    }
                    else if(randomNumber == 10){
                        viewDialog.setMessage( randomNumber+ " " +oracle[9] );

                    }
                    else if(randomNumber == 11){
                        viewDialog.setMessage( randomNumber+ " " +oracle[10] );

                    }
                    else if(randomNumber == 12){
                        viewDialog.setMessage( randomNumber+ " " +oracle[11] );

                    }
                    else if(randomNumber == 13){
                        viewDialog.setMessage( randomNumber+ " " +oracle[12] );

                    }
                    else if(randomNumber == 14){
                        viewDialog.setMessage( randomNumber+ " " +oracle[13] );

                    }
                    else if(randomNumber == 15){
                        viewDialog.setMessage( randomNumber+ " " +oracle[14] );

                    }
                    else if(randomNumber == 16){
                        viewDialog.setMessage( randomNumber+ " " +oracle[15] );
                    }
                    else if(randomNumber == 17){
                        viewDialog.setMessage( randomNumber+ " " +oracle[16] );
                    }
                    else if(randomNumber == 18){
                        viewDialog.setMessage( randomNumber+ " " +oracle[17] );
                    }
                    else if(randomNumber == 19){
                        viewDialog.setMessage( randomNumber+ " " +oracle[18] );
                    }
                    else if(randomNumber == 20){
                        viewDialog.setMessage( randomNumber+ " " +oracle[19] );
                    }
                    else if(randomNumber == 21){
                        viewDialog.setMessage( randomNumber+ " " +oracle[20] );
                    }
                    else if(randomNumber == 22){
                        viewDialog.setMessage( randomNumber+ " " +oracle[21] );
                    }
                    else if(randomNumber == 23){
                        viewDialog.setMessage( randomNumber+ " " +oracle[22] );
                    }
                    else if(randomNumber == 24){
                        viewDialog.setMessage( randomNumber+ " " +oracle[23] );
                    }
                    else if(randomNumber == 25){
                        viewDialog.setMessage( randomNumber+ " " +oracle[24] );
                    }
                    else if(randomNumber == 26){
                        viewDialog.setMessage( randomNumber+ " " +oracle[25] );
                    }
                    else if(randomNumber == 27){
                        viewDialog.setMessage( randomNumber+ " " + oracle[26] );
                    }
                    else if(randomNumber == 28){
                        viewDialog.setMessage( randomNumber+ " " + oracle[27] );
                    }

  //                  viewDialog.setMessage("The random number is " + randomNumber);
                    viewDialog.setPositiveButton("Ok",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                    shown_dialog = false;
                                }
                            });
                    viewDialog.show();
                }
            }
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);
        handler.postDelayed(pollTask, POLL_INTERVAL);

    }



    @Override
    protected void onPause() {
        super.onPause();
        // Unregister the sensor listener when the activity is paused
        sensorManager.unregisterListener(this);
        handler.removeCallbacks(pollTask);
    }

    static class SensorInfo{
        float accX, accY, accZ;
    }//end class SensorInfo
}