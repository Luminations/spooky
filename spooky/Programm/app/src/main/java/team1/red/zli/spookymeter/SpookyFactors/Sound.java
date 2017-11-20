package team1.red.zli.spookymeter.SpookyFactors;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.support.v4.content.ContextCompat;

import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Created by admin on 13.11.2017.
 */

public class Sound implements SpookyFactor {
private MediaRecorder mRecorder;
    @Override
    public int getSpookyFactor(Context context) {
        System.out.println("Hello!");
        stop();
        System.out.println("Hello!2");

        if (ContextCompat.checkSelfPermission(context, Manifest.permission.RECORD_AUDIO)
                == PackageManager.PERMISSION_GRANTED) {
            System.out.println("Hello4");
            start();
            System.out.println(mRecorder);

//            Location location = mFusedLocationClient.getLastLocation().;
        } else {

            return 0;
        }

        return (int)getAmplitude();
    }



    @Override
    public String name() {
        return "Sound";
    }


    public void start() {
        if (mRecorder == null) {
            mRecorder = new MediaRecorder();
            System.out.println("Hello!4");
            mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            mRecorder.setOutputFile("/dev/null");
            try {
                mRecorder.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }
            mRecorder.start();
        }
    }

    public void stop() {/*
        if (mRecorder != null) {
            mRecorder.stop();
            mRecorder.release();
            mRecorder = null;
        }*/
    }

    public double getAmplitude() {
        if (mRecorder != null)
            return  mRecorder.getMaxAmplitude();
        else
            return 0;

    }
}