/**
 * CounterList
 *
 * Counter list keeps track of all the counters. It performs actions such as adding
 * and removing counters from the counters list. The counters are added by name only.
 *
 * Oct 01 2017
 *
 * Implemented the listeners to the best of my ability. it was difficult to have full
 * understanding of the listeners and how they should be passed but I created basic
 * templates for passing the listeners around.
 */

package toluwani.countbook;

import android.app.Activity;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by tiakindele on 2017-09-27.
 */

public class CounterList extends Activity implements Serializable{

    protected ArrayList<Counter> counterList;
    protected ArrayList<Listener> listeners;

    /**
     * Creats new counter array and new listener array
     */
    public CounterList() {
        counterList = new ArrayList<Counter>();
        listeners = new ArrayList<Listener>();
    }

    // Make one if one does not exist yet
    private ArrayList<Listener> getListeners() {
        if (listeners == null) {
            listeners = new ArrayList<Listener>();
        }
        return listeners;
    }

    // This easily communicates the size of the Counter List
    public int getCounterCount() {
        return counterList.size();
    }

    // Getter for counter
    public ArrayList<Counter> getCounters() {
        return counterList;
    }

    //Gets counter by index in the counter list
    public Counter getCounter(int index) {
        return counterList.get(index);
    }

    /**
     * Adds a counter from the counter list.
     * @param counter
     */
    public void addCounter(Counter counter) {
        counterList.add(counter);
        notifier();
    }

    /**
     * Removes a counter from the counter list.
     * @param counter
     */
    public void removeCounter(Counter counter) {
        counterList.remove(counter);
        notifier();
    }

    /**
     * Updates are made because of the notifier. The notifier is used to
     * communicate between processes.
     */
    public void notifier() {
        for (Listener listener : listeners) {
            listener.update();
        }
    }

    /**
     * Adds a listener
     * @param l of type Listener
     */
    public void addListener(Listener l) {
        listeners.add(l);
    }

    /**
     * Removes selected listener
     * @param l
     */
    public void removeListener(Listener l) {
        listeners.remove(l);
    }
}
