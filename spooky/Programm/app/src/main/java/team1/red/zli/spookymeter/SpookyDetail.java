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

            //time
            ProgressBar timeProgress = findViewById(R.id.progressBar2);
            timeProgress.setMax(12);
            timeProgress.setProgress(spookyDetails.get(5));

            TextView timeText = findViewById(R.id.textView3);
            timeText.setText("Time " + spookyDetails.get(5) + "/" + "12");

            //date
            ProgressBar dateProgres = findViewById(R.id.progressBar4);
            dateProgres.setMax(7);
            dateProgres.setProgress(spookyDetails.get(4));

            TextView dateText = findViewById(R.id.textView5);
            dateText.setText("Date " + spookyDetails.get(4) + "/" + "7");

            //battery
            ProgressBar batteryProgress = findViewById(R.id.progressBar);
            batteryProgress.setMax(10);
            batteryProgress.setProgress(spookyDetails.get(0));

            TextView batteryText = findViewById(R.id.textView2);
            batteryText.setText("Battery " + spookyDetails.get(0) + "/" + "10");
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
