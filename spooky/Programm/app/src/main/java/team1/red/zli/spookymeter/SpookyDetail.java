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

            ProgressBar progressBar = findViewById(R.id.progressBar2);
            progressBar.setMax(30);
            ArrayList<Integer> spookyDetails = (ArrayList<Integer>) msg.obj;
            progressBar.setProgress(spookyDetails.get(5));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spooky_detail);

        SpookyThread spookyFactorThread = new SpookyThread(handler);
        spookyFactorThread.start();

    }
}
