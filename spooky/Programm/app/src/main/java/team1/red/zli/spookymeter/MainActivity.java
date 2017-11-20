package team1.red.zli.spookymeter;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

import team1.red.zli.spookymeter.SpookyFactors.SpookyFactor;

public class MainActivity extends AppCompatActivity {
    private final Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            ProgressBar pb = (ProgressBar) findViewById(R.id.vprogressbar);
            pb.setProgress(msg.what);
        }
    };

    int spooky;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button next = (Button) findViewById(R.id.button2);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), SpookyDetail.class);
                startActivityForResult(myIntent, 0);
            }
        });
        SpookyThread spookyFactorThread = new SpookyThread(handler, this);
        spookyFactorThread.start();

    }

    }


