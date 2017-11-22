package doublewale.firepaste.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import doublewale.firepaste.services.CopyListen;

/**
 * Created by wale on 11/21/17.
 */

public class OnBootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent myIntent = new Intent(context, CopyListen.class);
        context.startService(myIntent);
    }
}
