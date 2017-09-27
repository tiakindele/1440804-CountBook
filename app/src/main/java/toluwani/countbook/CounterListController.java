package toluwani.countbook;

import android.content.ClipData;

import java.util.ArrayList;

/**
 * Created by tiakindele on 2017-09-27.
 */

public class CounterListController {
    private static CounterList counterList = null;
    static public CounterList getCounterList() {
        if (counterList == null) {
            counterList = new CounterList();
        }
        return counterList;
    }

    public void addCounter(Counter counter) {
        getCounterList().addCounter(counter);
    }
}
