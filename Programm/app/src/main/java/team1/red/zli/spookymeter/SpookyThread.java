package team1.red.zli.spookymeter;

import android.content.Context;
import android.os.Handler;

import java.util.ArrayList;

import team1.red.zli.spookymeter.SpookyFactors.BatteryLifetime;
import team1.red.zli.spookymeter.SpookyFactors.Darkness;
import team1.red.zli.spookymeter.SpookyFactors.Location;
import team1.red.zli.spookymeter.SpookyFactors.Sound;
import team1.red.zli.spookymeter.SpookyFactors.SpookyDate;
import team1.red.zli.spookymeter.SpookyFactors.SpookyFactor;
import team1.red.zli.spookymeter.SpookyFactors.Time;

/**
 * Created by admin on 13.11.2017.
 */

public class SpookyThread extends Thread{

    Handler handler;
    ArrayList<SpookyFactor> spookyFactors;
    ArrayList<Integer> spookyDetails;
    int spookyness;
    Context context;
    SpookyThread(Handler handler, Context context) {
        this.handler = handler;
        this.context = context;
        spookyDetails = new ArrayList<>();
        spookyFactors = new ArrayList<>();
        spookyFactors.add(new BatteryLifetime());
        spookyFactors.add(new Darkness());
        spookyFactors.add(new Location());
        spookyFactors.add(new Sound());
        spookyFactors.add(new SpookyDate());
        spookyFactors.add(new Time());
    }

    @Override
    public void run() {
        while (true){
            spookyness = 0;

            for (int i = 0; i < spookyFactors.size(); i++){
                int spookyAmount = spookyFactors.get(i).getSpookyFactor(context);
                spookyness += spookyAmount;
                spookyDetails.add(spookyAmount);
            }

            handler.obtainMessage(spookyness, spookyDetails).sendToTarget();
            try {
                this.sleep(50);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
