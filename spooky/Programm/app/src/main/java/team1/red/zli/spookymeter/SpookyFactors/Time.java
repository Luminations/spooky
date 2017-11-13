package team1.red.zli.spookymeter.SpookyFactors;

/**
 * Created by admin on 13.11.2017.
 */
import java.util.Calendar;
import java.util.Date;

public class Time implements SpookyFactor {
    @Override
    public int getSpookyFactor() {
        Date currentTime = Calendar.getInstance().getTime();
        System.out.println(currentTime);
        return 0;
    }


    @Override
    public String name() {
        return "Time";
    }
}
