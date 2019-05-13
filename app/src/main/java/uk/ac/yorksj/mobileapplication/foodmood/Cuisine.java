package uk.ac.yorksj.mobileapplication.foodmood;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

public class Cuisine extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuisine);

        LoadURLs loadYou = new LoadURLs();
        WebView fWebView = findViewById(R.id.french_anthem);
        //these strings are the embed codes of YouTube videos
        String fVideoID = "4K1q9Ntcr5g";
        WebView aWebview = findViewById(R.id.american_anthem);
        String aVideoID = "M1wLtAXDgqg";

        loadYou.execute(fVideoID);


        nationalAnthem(fWebView, fVideoID);
        nationalAnthem(aWebview, aVideoID);





    }

    public void toastMsg(String msg) {

        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.show();

    }

    public void nationalAnthem(WebView webview, String videoID){
        webview.getSettings().setJavaScriptEnabled(true);   //have tried without JS but doesn't work
        webview.getSettings().setPluginState(WebSettings.PluginState.ON);
        webview.loadUrl("https://www.youtube.com/embed/" + videoID);
        webview.setWebChromeClient(new WebChromeClient());
    }
    public void displayToastMsg(android.view.View v) {

//        if(v == findViewById(R.id.americanflag)) {
//            toastMsg("Hello how are you today!!");
//        }
//        if(v ==findViewById(R.id.frenchflag)){
//          toastMsg("Poopy butthole");
//        }
//        else
            if(v ==findViewById(R.id.chinaFlag)){
            toastMsg("Coward");
        }
        else if(v ==findViewById(R.id.italyflag)){
            toastMsg("Supermario");
        }
        else if(v ==findViewById(R.id.indianflag)){
            toastMsg("hole");
        }
        else if(v ==findViewById(R.id.britishflag)){
            toastMsg("god save the queen");
        }

    }
  //      });
    //}

}
