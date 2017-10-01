package toluwani.countbook;

/**
 * Created by tiakindele on 2017-09-29.
 */

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CounterListManager {

    static final String prefFile = "CounterList";
    static final String clKey = "counterList";

    Context context;

    static private CounterListManager counterListManager = null;

    public static void initManager(Context context) {
        if (counterListManager == null) {
            if (context == null) {
                throw new RuntimeException("missing context for CounterListManager");
            }
            counterListManager = new CounterListManager(context);
        }
    }

    // returns manager
    public static CounterListManager getManager() {
        if (counterListManager == null) {
            throw new RuntimeException("Manager was not initialized");
        }
        return counterListManager;
    }

    public CounterListManager(Context context) {
        this.context = context;
    }

    // retrieves counterList from storing; SharedPreferences method
    public CounterList loadCounterList() throws IOException, ClassNotFoundException {
        SharedPreferences settings = context.getSharedPreferences(prefFile, Context.MODE_PRIVATE);
        String counterListData = settings.getString(clKey, "");
        if (counterListData.equals("")){
            return new CounterList();
        } else {
            return counterListFromString(counterListData);
        }
    }

    // stores counterList into storage; SharedPreferences method
    public void saveCounterList(CounterList cl) throws IOException {
        SharedPreferences settings = context.getSharedPreferences(prefFile, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(clKey, counterListToString(cl));
        editor.commit();
    }


    // converts to a counterList object from string
    static public CounterList counterListFromString(String counterListData) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bi = new ByteArrayInputStream(Base64.decode(counterListData, Base64.DEFAULT));
        ObjectInputStream oi = new ObjectInputStream(bi);
        return (CounterList) oi.readObject();

    }

    // converts from a counterList object to a string
    static public String counterListToString(CounterList cl) throws IOException {
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(bo);
        oo.writeObject(cl);
        oo.close();
        byte bytes[] = bo.toByteArray();
        return Base64.encodeToString(bytes, Base64.DEFAULT);
    }
}
