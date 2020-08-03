package the.ua.webbrowsing;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.facebook.appevents.AppEventsLogger;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import org.jetbrains.annotations.Nullable;
import the.ua.dionisview.*;

public class MainActivity extends Activity {

    DionisView dionisView;

    String go =
//            "https://rt.pornhub.com/";
//            "https://www.google.com";
            "https://trk.dw.partners/click?pid=1&offer_id=135&sub1=test";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        LinearLayout layout = findViewById(R.id.test_layout);
        dionisView = DionisView.with(this)
                .setAgentWebParent(layout, new LinearLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()
                .setWebChromeClient(new OpenNewWindowWebChromeClient(this))
                .setWebViewClient(new WebViewClient())
                .createAgentWeb()
                .ready()
                .go(go);
//        dionisView.getWebCreator().getWebView();

//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dionisView.getWebCreator().getWebView().evaluateJavascript("console.log('FIRE!');", null);
//            }
//        });

    }

    @Override
    protected void onDestroy() {
        dionisView.destroy();
        super.onDestroy();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (dionisView.handleKeyEvent(keyCode, event)) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
