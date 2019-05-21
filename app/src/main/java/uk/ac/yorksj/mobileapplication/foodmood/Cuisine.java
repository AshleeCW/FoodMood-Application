package uk.ac.yorksj.mobileapplication.foodmood;

import android.os.Bundle;
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

        WebView fWebView = findViewById(R.id.french_anthem);
        //these strings are the embed codes of YouTube videos
        String fVideoID = "4K1q9Ntcr5g";
        WebView aWebview = findViewById(R.id.american_anthem);
        String aVideoID = "M1wLtAXDgqg";
        WebView bWebView = findViewById(R.id.british_anthem);
        String bVideoID ="I8KSAtos-dk";



 WebView cWebView = findViewById(R.id.chinese_anthem);
 String cVideoID ="UctriMuXYS0";
 WebView iWebView = findViewById(R.id.italian_anthem);
  String iVideoID ="04ckV9QueXc";
  WebView pWebView = findViewById(R.id.indian_anthem);
  String pVideoID ="HtMF973tXIY";


  //Webviews are different, lower and uppercase V, might be an issue later

        nationalAnthem(fWebView, fVideoID);
        nationalAnthem(aWebview, aVideoID);
        nationalAnthem(bWebView, bVideoID);
        nationalAnthem(cWebView, cVideoID);
        nationalAnthem(iWebView, iVideoID);
        nationalAnthem(pWebView, pVideoID);







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

////      if(v == findViewById(R.id.americanflag)) {
////            toastMsg("Hello how are you today!!");
////        }
////        if(v ==findViewById(R.id.frenchflag)){
////          toastMsg("Poopy butthole");
////        }
////        else
//            if(v ==findViewById(R.id.chinaFlag)){
//            toastMsg("Coward");
//        }
//        else if(v ==findViewById(R.id.italyflag)){
//            toastMsg("Supermario");
//        }
//        else if(v ==findViewById(R.id.indianflag)){
//            toastMsg("hole");
//        }
//       else if(v ==findViewById(R.id.britishflag)){
//            toastMsg("god save the queen");
//        }

    }
  //      });
    //}

}
