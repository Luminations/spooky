package team1.red.zli.spookymeter.SpookyFactors;

/**
 * Created by admin on 13.11.2017.
 */

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SpookyDate implements SpookyFactor {
    @Override
    public int getSpookyFactor() {
        int spookyFactor = 0;
        Date currentTime = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM");
        String date = sdf.format(currentTime);
        String[] spookyDates = {"31.10", "11.9", "1.12", /* This is today -> */"13.11"};
        for (String thisArray : spookyDates) {
            if(thisArray.compareTo(date) == 0){
                spookyFactor = 7;
            }
        }

        return spookyFactor;
    }


    @Override
    public String name() {
        return "Date";
    }
}
