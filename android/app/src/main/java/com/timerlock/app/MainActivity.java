package com.timerlock.app;

import android.os.Bundle;
import android.view.KeyEvent;
import com.getcapacitor.BridgeActivity;

public class MainActivity extends BridgeActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // Volume Up key triggers the lock screen wakeup
        if (keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
            // Inject ArrowUp keydown event into the WebView
            getBridge().getWebView().evaluateJavascript(
                "window.dispatchEvent(new KeyboardEvent('keydown', {key: 'ArrowUp', bubbles: true}));",
                null
            );
            return true; // consume the event (don't change system volume)
        }
        return super.onKeyDown(keyCode, event);
    }
}
