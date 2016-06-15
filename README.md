# CHROMECUSTOMTABS_OAUTH
An easy example of chrome custom tabs which can be easily integrated in app for OAUTH process.


upload test.html to your server
change the links accordingly in MainActivity

###IMPORTANT -  
######customTabsIntent.intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY); 
is used for closing custom tabs as the user move to another activity

Deep linking is used here to launch a activity after a particular link is opened in chrome custom tab.
Know More : [Chrome Custom Tabs](https://developer.chrome.com/multidevice/android/customtabs)
            [Deep Linking in Android](https://developer.android.com/training/app-indexing/deep-linking.html)


