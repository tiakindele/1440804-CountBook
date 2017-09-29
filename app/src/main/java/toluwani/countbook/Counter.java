package toluwani.countbook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by tiakindele on 2017-09-27.
 */

public class Counter extends Activity{

    private int countInt = 0;
    private TextView counterView;
    private TextView nameView;
    protected String counterName;
    protected String counterDate;
    protected Integer currentVal;
    protected Integer initialVal;
    protected String commentString;
    private Date local_date;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.counter);
        counterView = (TextView)findViewById(R.id.counterView);
        nameView = (TextView)findViewById(R.id.itemName);
        //nameView.setText(String.valueOf(getCounterName()));
        nameView.setText("Item Name");
    }

    public Counter() {

    }

    public Counter(String counterName) {
        this.counterName = counterName;
        this.counterDate = getCounterDate();
        this.currentVal = getCurrentVal();
        this.initialVal = getInitialVal();
        this.commentString = getCommentString();
    }

    public String getCounterName() {
        return counterName;
    }
    public String getCounterDate() {
        return counterDate;
    }
    public Integer getCurrentVal() {
        return currentVal;
    }
    public Integer getInitialVal() {
        return initialVal;
    }
    public String getCommentString() {
        return commentString;
    }

    public String toString() {
        return getCounterName();
    }

    public void getCounterCreateDate() {

    }

    public void getCounterUpdateDate() {

    }

    public void incrementClicked(View view) {
        countInt++;
        counterView.setText(String.valueOf(countInt));
    }

    public void decrementClicked(View view) {
        countInt--;
        counterView.setText(String.valueOf(countInt));
    }

    public void backClicked(View view) {
        Intent i = new Intent(Counter.this, MainActivity.class);
        startActivity(i);
    }

    public void deleteClicked(View view) {
    }

    public void resetClicked(View view) {
    }


}
