package team1.red.zli.spookymeter.SpookyFactors;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;

/**
 * Created by admin on 13.11.2017.
 */

public class BatteryLifetime implements SpookyFactor {
    @Override
    public int getSpookyFactor(Context context) {

        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus = context.registerReceiver(null, ifilter);

        int level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);


        return 0;
    }

    @Override
    public String name() {
        return "Battery Lifetime";
    }
}
