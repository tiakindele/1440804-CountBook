/**
 * Counter List Controller
 *
 * This takes care getting access to the Counters List.
 * More specifically, deals with getting, saving and updating information to and from
 * the Counter List.
 *
 * Oct 01 2017
 *
 * This class was built with the help of the Student Picker YouTube playlist by
 * Abram Hindle. However, the process and reason for this class is very clear to me.
 *
 * I had issues with this part of the app. I use log messages to trace the information
 * being passed and could not figure out a way to fix information getting lost in this
 * part of the code.
 * This class also has updateCounter in it which is never used because I could not
 * figure out how to implement it but the theory for the process is below in the method.
 */

package toluwani.countbook;

import java.io.IOException;
import java.io.Serializable;
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

    /**
     * Goes to manager, gets the Counter list and saves it
     * @throws IOException
     */
    static private void saveCounterList() throws IOException {
        CounterListManager.getManager().saveCounterList(getCounterList());
    }

    /**
     * Add the new Counter to the list of counters
     * @param counter new counter added
     */
    public void addCounter(Counter counter) {
        getCounterList().addCounter(counter);
    }

    /**
     * Updates the Counter with information taken from the update
     * @param i index of counter (used for retrieval)
     * @param name name of the counter
     * @param initialVal initial value of the counter
     * @param currentVal current value of the counter
     * @param date date associated with the counter
     * @param comment comment added to the counter
     */
    public void updateCounter(int i, String name, int initialVal, int currentVal,
                              Date date, String comment){
        Counter c = findCounter(i);

        c.setCounterName(name);
        c.setInitialVal(initialVal);
        c.setCurrentVal(currentVal);
        c.setCounterDate(date);
        c.setCommentString(comment);
    }

    /**
     * Requests to find the counter at a certain index.
     * @param index requests the counter at this index
     * @return returns the counter at the specified index
     */
    public Counter findCounter(int index) {
        return getCounterList().getCounter(index);
    }
}
