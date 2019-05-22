//package uk.ac.yorksj.mobileapplication.foodmood;
//
//import android.os.AsyncTask;
//import android.provider.ContactsContract;
//import android.webkit.WebChromeClient;
//import android.webkit.WebSettings;
//import android.webkit.WebView;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//
//public class DoSomeTasks extends AsyncTask<String, Void, WebView> {
//
//    @Override
//    protected WebView doInBackground(String... strings) {
//            try {
//                URL url = new URL(strings[0]);
//                WebView webview =
//                webview.getSettings().setJavaScriptEnabled(true);
//                webview.getSettings().setPluginState(WebSettings.PluginState.ON);
//                webview.loadUrl(url);
//                webview.setWebChromeClient(new WebChromeClient());
//                return webview;
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            }
//
//
//
//        return null;
//
//    }
//    @Override
//    protected  void onPostExecute(WebView webview){
//        super.onPostExecute(webview);
//
//
//
//    }
//}
