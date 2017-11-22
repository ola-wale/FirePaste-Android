package doublewale.firepaste.services;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by wale on 11/21/17.
 */

public class Api {
    public static void paste(String textToPaste){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("text");
        myRef.setValue(textToPaste);
    }
}
