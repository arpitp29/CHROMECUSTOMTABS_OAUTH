package com.viewpoint.googlecustomtabexample;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v4.content.IntentCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

public class TestLaunch extends AppCompatActivity {

    private static final String LAUNCH_FROM_URL = "com.viewpoint.googlecustomtabexample";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_launch);


        //TextView launchInfo = (TextView)findViewById(R.id.launch_info);
/*
        Intent intent = getIntent();
        if(intent != null && intent.getAction().equals(LAUNCH_FROM_URL)){
            Bundle bundle = intent.getExtras();
            if(bundle != null){
                String msgFromBrowserUrl = bundle.getString("msg_from_browser");
                Log.d("mylogs",""+msgFromBrowserUrl);
                //launchInfo.setText(msgFromBrowserUrl);
            }
        }else{
            Log.d("mylogs","normal activity launch");
        }
  */

        List<String> params = getIntent().getData().getPathSegments();
        if(params.get(0).equals("connect")){
            Log.i("mylogs", "connect successful");
            Toast.makeText(getApplicationContext(),"Connect Successfull",Toast.LENGTH_SHORT).show();
        }else{
            Log.i("mylogs", "connect unsuccessful");
            Toast.makeText(getApplicationContext(),"Connect unSuccessfull",Toast.LENGTH_SHORT).show();

        }

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        ComponentName cn = intent.getComponent();
        Intent mainIntent = IntentCompat.makeRestartActivityTask(cn);
        startActivity(mainIntent);
    }

    }

