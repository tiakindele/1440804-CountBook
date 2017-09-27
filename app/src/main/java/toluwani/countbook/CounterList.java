package toluwani.countbook;

import android.app.Activity;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by tiakindele on 2017-09-27.
 */

public class CounterList extends Activity{

    protected ArrayList<Counter> counterList;

    public CounterList() {
        counterList = new ArrayList<Counter>();
    }

    public Collection<Counter> getCounters() {
        return counterList;
    }

    public void addCounter(Counter counter) {
        counterList.add(counter);
    }

    public void removeCounter(Counter counter) {
        counterList.remove(counter);
    }

    public int size() {
        return counterList.size();
    }

    public boolean contains(Counter counter) {
        return counterList.contains(counter);
    }
}
