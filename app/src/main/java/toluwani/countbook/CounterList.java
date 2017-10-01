package toluwani.countbook;

import android.app.Activity;
import android.util.Log;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by tiakindele on 2017-09-27.
 */

public class CounterList extends Activity implements Serializable{

    protected ArrayList<Counter> counterList;
    protected ArrayList<Listener> listeners;

    public CounterList() {
        counterList = new ArrayList<Counter>();
        listeners = new ArrayList<Listener>();
    }

    private ArrayList<Listener> getListeners() {
        if (listeners == null) {
            listeners = new ArrayList<Listener>();
        }
        return listeners;
    }

    public int getCounterCount() {
        return counterList.size();
    }
    public ArrayList<Counter> getCounters() {
        return counterList;
    }

    public Counter getCounter(int index) {
        return counterList.get(index);
    }

    public void addCounter(Counter counter) {
        counterList.add(counter);

        notifier();
    }

    public void removeCounter(Counter counter) {
        counterList.remove(counter);
        notifier();
    }

//    public int size() {
//        return counterList.size();
//    }

//    public boolean contains(Counter counter) {
//        return counterList.contains(counter);
//    }

    public void notifier() {
        for (Listener listener : listeners) {
            listener.update();
        }
    }

    public void addListener(Listener l) {
        listeners.add(l);
    }

    public void removeListener(Listener l) {
        listeners.remove(l);
    }
}
