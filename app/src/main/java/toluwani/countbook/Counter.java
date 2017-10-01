/**
 * Counter Class
 *
 * This class deals with the actual operation of the counter application. What the program is
 * supposed to do is get the value of the initial or current counter, and perform calculations
 * on it. The class also has getters and setters for the different information concerning
 * counters.
 *
 * Oct 01 2017
 *
 * This class is not fully functioning because I could not get the values passed into the counter
 * so instead, an integer i is used to show the efficiency of the counter.
 */

package toluwani.countbook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by tiakindele on 2017-09-27.
 */


public class Counter extends Activity implements Serializable {

    private int countInt = 0;
    private TextView counterView;
    private TextView nameView;
    private String counterName;
    private Date counterDate;
    private Integer currentVal;
    private Integer initialVal;
    private String commentString;

        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.counter);
        counterView = (TextView)findViewById(R.id.counterView);
        nameView = (TextView)findViewById(R.id.itemName);
        nameView.setText(getCounterName());
    }

    public Counter() {}

    /**
     * Counter gets all information and saves it
     * @param counterName name of the new counter
     * @param counterDate date the counter was added
     * @param currentVal current value of the counter
     * @param initialVal initial value picked by the user
     * @param commentString comment left by the user for the counter
     */
    public Counter(String counterName, Date counterDate, Integer currentVal, Integer initialVal,
                   String commentString) {
        this.counterName = counterName;
        this.counterDate = counterDate;
        this.currentVal = currentVal;
        this.initialVal = initialVal;
        this.commentString = commentString;
    }

    // Sends the counter's name to any process requesting it
    public String getCounterName() {
        String nameToSend = this.counterName;
        return nameToSend;
    }

    // Getters for counter information
    public Date getCounterDate() {
        return this.counterDate;
    }
    public Integer getCurrentVal() {
        return this.currentVal;
    }
    public Integer getInitialVal() {
        return this.initialVal;
    }
    public String getCommentString() {
        return this.commentString;
    }

    // Setters for counter information
    public void setCounterName(String name) {
        this.counterName = name;
    }
    public void setCounterDate(Date date) {
        this.counterDate = date;
    }
    public void setCurrentVal(int cVal) {
        this.currentVal = cVal;
    }
    public void setInitialVal(int iVal) {
        this.initialVal = iVal;
    }
    public void setCommentString(String comment) {
        this.commentString = comment;
    }

    public String toString() {
        String nameVar = getCounterName();
        return nameVar;
    }

    /**
     * This should increment the current value of the counter.
     * Due to unresolved issue, an integer "countInt" is used instead.
     * @param view
     */
    public void incrementClicked(View view) {
        //Integer countInt = getCurrentVal();
        countInt++;
        counterView.setText(String.valueOf(countInt));
        this.currentVal = countInt;
    }

    /**
     * This should decrement the current value of the counter.
     * Due to unresolved issue, an integer "countInt" is used instead.
     * @param view
     */
    public void decrementClicked(View view) {
        //int countInt = getCurrentVal();
        countInt--;
        if (countInt < 0){
            countInt = 0;
            this.currentVal = countInt;
        } else {
            counterView.setText(String.valueOf(countInt));
            this.currentVal = countInt;
        }
    }

    /**
     * Clicking back takes you back to previous page
     * @param view
     */
    public void backClicked(View view) {
        Intent i = new Intent(Counter.this, MainActivity.class);
        startActivity(i);
    }

    /**
     * Resets the counter to 0
     * @param view
     */
    public void resetClicked(View view) {
        countInt = 0;
        counterView.setText(String.valueOf(countInt));
        this.currentVal = countInt;
    }


}
