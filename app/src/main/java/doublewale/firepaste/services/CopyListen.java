package doublewale.firepaste.services;

import android.app.IntentService;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import org.jetbrains.annotations.Nullable;

/**
 * Created by wale on 11/21/17.
 */

public class CopyListen extends IntentService {

    @Override
    protected void onHandleIntent(Intent workIntent) {

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        Log.d("xx","INTENT START");
        final ClipboardManager cm = (ClipboardManager) this.getSystemService(Context.CLIPBOARD_SERVICE);
        cm.addPrimaryClipChangedListener(new ClipboardManager.OnPrimaryClipChangedListener() {
            @Override
            public void onPrimaryClipChanged() {
                ClipData clipData = cm.getPrimaryClip();
                ClipData.Item item = clipData.getItemAt(0);
                String text = item.getText().toString();
                final SharedPreferences prefs = getApplicationContext().getSharedPreferences(
                        "com.doublewale.firepaste", Context.MODE_PRIVATE);
                boolean enabled = prefs.getBoolean("enabled", true);
                if(enabled)
                    Api.paste(text);
            }
        });
        return START_STICKY;
    }

    public CopyListen(){
        super("CopyListen");
    }

}

