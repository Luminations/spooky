package team1.red.zli.spookymeter.SpookyFactors;

import android.content.Context;

/**
 * Created by admin on 13.11.2017.
 */

public class Location implements SpookyFactor {
    @Override
    public int getSpookyFactor(Context context) {
        return 0;
    }

    @Override
    public String name() {
        return "Location";
    }
}
