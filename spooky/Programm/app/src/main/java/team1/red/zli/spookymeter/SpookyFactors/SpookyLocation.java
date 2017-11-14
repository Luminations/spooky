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
import com.google.android.gms.tasks.Task;

/**
 * Created by admin on 13.11.2017.
 */

public class SpookyLocation implements SpookyFactor {


    private FusedLocationProviderClient mFusedLocationClient;
    Task<Location> locationTask;
    int alitude;
    @Override
    public int getSpookyFactor(Context context) {
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(context);




        if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {

//            Location location = mFusedLocationClient.getLastLocation().;
        } else {

            alitude = -58;
        }




        return alitude;
    }

    @Override
    public String name() {
        return "SpookyLocation";
    }
}
