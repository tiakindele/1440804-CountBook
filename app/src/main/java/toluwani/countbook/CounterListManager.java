/**
 * Counter List Manager
 *
 * This manages the list and should act as the control space for the counters
 * entering and leaving the application.
 *
 * Oct 01 2017
 *
 * This class was built with the help of the Student Picker YouTube playlist by
 * Abram Hindle. However, the process and reason for this class is very clear to me.
 *
 * The loads and saves work in the beginning but don't work once a Counter is selected.
 * The theory behind the process is correct to the best of my knowledge though.
 */

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

    /**
     * Initializes the manager
     * @param context context to manage
     */
    public static void initManager(Context context) {
        if (counterListManager == null) {
            if (context == null) {
                throw new RuntimeException("missing context for CounterListManager");
            }
            counterListManager = new CounterListManager(context);
        }
    }

    /**
     * Returns a manager needed by another process
     * @return returns the manager needed
     */
    public static CounterListManager getManager() {
        if (counterListManager == null) {
            throw new RuntimeException("Manager was not initialized");
        }
        return counterListManager;
    }

    /**
     * Setter for context in Manager Class
     * @param context sets the context being referred to
     */
    public CounterListManager(Context context) {
        this.context = context;
    }

    /**
     * Gets Counter List from storage
     * Uses sharedPreferences method
     * @return returns new counter list or a previously added one
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public CounterList loadCounterList() throws IOException, ClassNotFoundException {
        SharedPreferences settings = context.getSharedPreferences(prefFile, Context.MODE_PRIVATE);
        String counterListData = settings.getString(clKey, "");
        if (counterListData.equals("")){
            return new CounterList();
        } else {
            return counterListFromString(counterListData);
        }
    }

    /**
     * Stores Counter List
     * SharedPreferences method
     * @param cl Counter List to be saved to
     * @throws IOException
     */
    public void saveCounterList(CounterList cl) throws IOException {
        SharedPreferences settings = context.getSharedPreferences(prefFile, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(clKey, counterListToString(cl));
        editor.commit();
    }

    /**
     * Converts String to counterList object
     * @param counterListData data needed to be converted from String to counterList object
     * @return returns converted data
     * @throws IOException
     * @throws ClassNotFoundException
     */
    static public CounterList counterListFromString(String counterListData) throws IOException,
            ClassNotFoundException {
        ByteArrayInputStream bi = new ByteArrayInputStream(Base64.decode(counterListData,
                Base64.DEFAULT));
        ObjectInputStream oi = new ObjectInputStream(bi);
        return (CounterList) oi.readObject();

    }

    /**
     * Converts to String from counterList object
     * @param cl counter list to be accessed
     * @return returns String form of data
     * @throws IOException
     */
    static public String counterListToString(CounterList cl) throws IOException {
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(bo);
        oo.writeObject(cl);
        oo.close();
        byte bytes[] = bo.toByteArray();
        return Base64.encodeToString(bytes, Base64.DEFAULT);
    }
}
