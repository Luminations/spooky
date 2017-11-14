package team1.red.zli.spookymeter.SpookyFactors;


import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/**
 * Created by admin on 13.11.2017.
 */

public class Darkness implements SpookyFactor {
    public int value = 0;

    @Override
    public int getSpookyFactor(Context context) {

        SensorManager sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        Sensor lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        if (lightSensor == null) {
            value = 5;
        } else {

            sensorManager.registerListener(lightSensorEventListener,
                    lightSensor,
                    SensorManager.SENSOR_DELAY_NORMAL);


        }
        return value;
    }


    SensorEventListener lightSensorEventListener
            = new SensorEventListener() {

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

//            value = (int)(10/accuracy);
        }

        public void onSensorChanged(SensorEvent event) {

            if (event.sensor.getType() == Sensor.TYPE_LIGHT) {
                float currentReading = event.values[0];
                if(currentReading == 0){
                    currentReading = 1;
                }
                value = (int) (100/currentReading);
            }
        }
    };

    @Override
    public String name() {
        return "Darkness";
    }
}
