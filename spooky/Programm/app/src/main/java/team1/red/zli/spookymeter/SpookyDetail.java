package team1.red.zli.spookymeter;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by admin on 13.11.2017.
 */

public class SpookyDetail extends Activity{
    private final Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            ArrayList<Integer> spookyDetails = (ArrayList<Integer>) msg.obj;

            //title
            TextView titleText = findViewById(R.id.textView2);
            titleText.setText("Spooky Details!");

            //time
            ProgressBar timeProgress = findViewById(R.id.progressBar);
            timeProgress.setMax(12);
            timeProgress.setProgress(spookyDetails.get(4));

            TextView timeText = findViewById(R.id.textView3);
            timeText.setText("Time " + spookyDetails.get(4) + "/" + "12");

            //date
            ProgressBar dateProgres = findViewById(R.id.progressBar2);
            dateProgres.setMax(7);
            dateProgres.setProgress(spookyDetails.get(3));

            TextView dateText = findViewById(R.id.textView4);
            dateText.setText("Date " + spookyDetails.get(3) + "/" + "7");

            //battery
            ProgressBar batteryProgress = findViewById(R.id.progressBar3);
            batteryProgress.setMax(10);
            batteryProgress.setProgress(spookyDetails.get(0));

            TextView batteryText = findViewById(R.id.textView5);
            batteryText.setText("Battery " + spookyDetails.get(0) + "/" + "10");

            //darkness
            ProgressBar darknessProgress = findViewById(R.id.progressBar4);
            darknessProgress.setMax(10);
            darknessProgress.setProgress(spookyDetails.get(1));

            TextView darknessText = findViewById(R.id.textView6);
            darknessText.setText("Darkness  " + spookyDetails.get(1) + "/" + "10");

            //location
            ProgressBar locationProgress = findViewById(R.id.progressBar5);
            locationProgress.setMax(10);
            locationProgress.setProgress(spookyDetails.get(2));

            TextView locationText = findViewById(R.id.textView7);
            locationText.setText("Location  " + spookyDetails.get(2) + "/" + "10");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spooky_detail);

        SpookyThread spookyFactorThread = new SpookyThread(handler, this);
        spookyFactorThread.start();

    }
}
