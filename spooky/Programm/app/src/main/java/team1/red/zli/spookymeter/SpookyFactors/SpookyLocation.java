package team1.red.zli.spookymeter.SpookyFactors;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

/**
 * Created by admin on 13.11.2017.
 */

public class SpookyLocation implements SpookyFactor{


    private FusedLocationProviderClient mFusedLocationClient;
    int alitude;


    public SpookyLocation(){

    }

    @Override
    public int getSpookyFactor(Context context) {
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(context);




        if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {

            Task location = mFusedLocationClient.getLastLocation();
            while (!location.isSuccessful()) {
                try {
                    Thread.sleep(16);
                } catch (InterruptedException e) {
                    System.err.print("fuck offfff");
                }
            }
            return (int)((Location)location.getResult()).getAltitude();

        } else {

            alitude = 0;
        }



        return alitude;
    }

    @Override
    public String name() {
        return "SpookyLocation";
    }
}
