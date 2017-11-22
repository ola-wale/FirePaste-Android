package doublewale.firepaste;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Switch;

import doublewale.firepaste.services.CopyListen;

/**
 * Created by wale on 11/22/17.
 */

public class MainActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        //start intent service
        Intent myIntent = new Intent(getApplicationContext(), CopyListen.class);
        getApplicationContext().startService(myIntent);

        setContentView(R.layout.activity_main);

        final SharedPreferences prefs = this.getSharedPreferences(
                "com.doublewale.firepaste", Context.MODE_PRIVATE);

        final Switch control = (Switch) findViewById(R.id.control);

        boolean enabled = prefs.getBoolean("enabled", true);

        control.setChecked(enabled);

        if(enabled){
            control.setText("Disable");
        } else {
            control.setText("Enable");
        }

        control.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                prefs.edit().putBoolean("enabled",isChecked).apply();
                if(isChecked){
                    control.setText("Disable");
                } else {
                    control.setText("Enable");
                }
            }
        });

    }
}
