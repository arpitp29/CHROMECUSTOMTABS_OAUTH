package com.viewpoint.googlecustomtabexample;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.support.customtabs.CustomTabsClient;
import android.support.customtabs.CustomTabsIntent;
import android.support.customtabs.CustomTabsServiceConnection;
import android.support.customtabs.CustomTabsSession;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import helper.CustomTabActivityHelper;

public class MainActivity extends AppCompatActivity {

    String tag="mylogs";
    CustomTabsClient mClient;
    CustomTabsServiceConnection mCustomTabsServiceConnection;

    CustomTabsSession mCustomTabsSession;
    String CUSTOM_TAB_PACKAGE_NAME="com.android.chrome";
    CustomTabsIntent customTabsIntent;
    //String URL="http://10.0.1.31/test/testlaunch2.html";
    String URL ="https://en.wikipedia.org/wiki/Main_Page";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCustomTabsServiceConnection = new CustomTabsServiceConnection() {
            @Override
            public void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
                //Pre-warming
                mClient = customTabsClient;
                mClient.warmup(0L);
                mCustomTabsSession = mClient.newSession(null);
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                mClient = null;
            }
        };


        CustomTabsClient.bindCustomTabsService(MainActivity.this,CUSTOM_TAB_PACKAGE_NAME, mCustomTabsServiceConnection);

        customTabsIntent = new CustomTabsIntent.Builder(mCustomTabsSession)
                .setToolbarColor(ContextCompat.getColor(this, R.color.colorPrimary))
                .setShowTitle(true)
                .enableUrlBarHiding()
                .build();
    }

    public void connect(View v){
        customTabsIntent.launchUrl(MainActivity.this, Uri.parse(URL));

        Log.d("mylogs","connect button");
       /* CustomTabsIntent customTabsIntent = new CustomTabsIntent.Builder().build();
        Uri uri=Uri.parse(URL);
        CustomTabActivityHelper.openCustomTab(this, customTabsIntent, uri,
                new CustomTabActivityHelper.CustomTabFallback() {
                    @Override
                    public void openUri(Activity activity, Uri uri) {
                        Log.d("mylogs","opening"+uri.toString());
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);

                    }
                });
*/
    }



}
