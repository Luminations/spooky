package team1.red.zli.spookymeter.SpookyFactors;

/**
 * Created by admin on 13.11.2017.
 */
import android.content.Context;

import java.util.Calendar;
import java.util.Date;

public class Time implements SpookyFactor {
    @Override
    public int getSpookyFactor(Context context) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        long howMany = (c.getTimeInMillis()-System.currentTimeMillis());
        int time = (int) (72 -(((howMany / 1000) / 60) / 10));
        if (time < 0) time *= -1;
        return time;
    }


    @Override
    public String name() {
        return "Time";
    }
}
