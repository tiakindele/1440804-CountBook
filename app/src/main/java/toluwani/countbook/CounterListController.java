package toluwani.countbook;

import android.content.ClipData;
import android.util.Log;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by tiakindele on 2017-09-27.
 */

public class CounterListController implements Serializable {
    private static CounterList counterList = null;
    static public CounterList getCounterList() {
        if (counterList == null) {
            try {
                counterList = CounterListManager.getManager().loadCounterList();
                counterList.addListener(new Listener() {
                    @Override
                    public void update() {
                        try {
                            saveCounterList();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Unable to deserialize!");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                throw new RuntimeException("Unable to deserialize!");
            }
        }
        return counterList;
    }

    static private void saveCounterList() throws IOException {
//        try {
            CounterListManager.getManager().saveCounterList(getCounterList());
//        } catch (IOException e) {
//            e.printStackTrace();
//            throw new RuntimeException("Could not deserialize!");
//        }
    }

    public void addCounter(Counter counter) {
        //Log.d("D", "########## list controller name: "+ counter.getCounterName() +" CHECK CHECK CHECK#############");
        getCounterList().addCounter(counter);
    }

    public void updateCounter(int i, String name, int initialVal, int currentVal,
                              Date date, String comment){
        Counter c = findCounter(i);

        c.setCounterName(name);
        c.setInitialVal(initialVal);
        c.setCurrentVal(currentVal);
        c.setCounterDate(date);
        c.setCommentString(comment);
    }

    public Counter findCounter(int index) {
        return getCounterList().getCounter(index);
    }
}
