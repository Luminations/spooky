package team1.red.zli.spookymeter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import team1.red.zli.spookymeter.SpookyFactors.SpookyFactor;

public class MainActivity extends AppCompatActivity {

    ArrayList<SpookyFactor> spookyFactors;
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

        spookyFactors = new ArrayList<>();



    }
}
