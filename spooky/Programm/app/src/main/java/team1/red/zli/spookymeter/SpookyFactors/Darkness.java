package team1.red.zli.spookymeter.SpookyFactors;


import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by admin on 13.11.2017.
 */

public class Darkness  implements SpookyFactor {
    public int value = 0;
    @Override
    public int getSpookyFactor(Context context) {
//        SensorManager sensorManager
//                = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
//        Sensor lightSensor
//                = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
//
//        if (lightSensor == null){
//            value = 5;
//        }else{
//
//            sensorManager.registerListener(lightSensorEventListener,
//                    lightSensor,
//                    SensorManager.SENSOR_DELAY_NORMAL);
//
//
//        }
        return value;
    }



//
//    SensorEventListener lightSensorEventListener
//            = new SensorEventListener() {
//
//        @Override
//        public void onAccuracyChanged(Sensor sensor, int accuracy) {
//            // TODO Auto-generated method stub
//
//        }
//
//        public void onSensorChanged(SensorEvent event) {
//            // TODO Auto-generated method stub
//            if (event.sensor.getType() == Sensor.TYPE_LIGHT) {
//                float currentReading = event.values[0];
//                value =  (int)currentReading;
//            }
//        }
//    };
    @Override
    public String name() {
        return "Darkness";
    }
}
