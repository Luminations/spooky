package team1.red.zli.spookymeter.SpookyFactors;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.Task;

/**
 * Created by admin on 13.11.2017.
 */

public class SpookyLocation implements SpookyFactor {
    private FusedLocationProviderClient mFusedLocationClient;
    Task<android.location.Location> locationTask;
    int alitude;
    @Override
    public int getSpookyFactor(Context context) {
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(context);

        boolean perm1 = ContextCompat.checkSelfPermission( context, Manifest.permission.ACCESS_FINE_LOCATION ) != PackageManager.PERMISSION_GRANTED;
        boolean perm2 = ContextCompat.checkSelfPermission( context, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED;

        if ( Build.VERSION.SDK_INT >= 23 &&
                ContextCompat.checkSelfPermission( context, Manifest.permission.ACCESS_FINE_LOCATION ) != PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission( context, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {








        }else {
            locationTask = mFusedLocationClient.getLastLocation();
            alitude = 58;
        }


        return alitude;
    }

    @Override
    public String name() {
        return "SpookyLocation";
    }
}
