

package the.ua.dionisview;

import android.view.View;
import android.webkit.WebChromeClient;


public interface IVideo {


    void onShowCustomView(View view, WebChromeClient.CustomViewCallback callback);


    void onHideCustomView();


    boolean isVideoState();

}