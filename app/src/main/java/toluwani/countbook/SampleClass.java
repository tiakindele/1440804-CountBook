package toluwani.countbook;

import android.app.Activity;
import android.os.Bundle;

import java.util.Date;

/**
 * Created by tiakindele on 2017-09-29.
 */

public class SampleClass extends Activity {
    protected String counterName;
    protected String counterDate;
    protected Integer currentVal;
    protected Integer initialVal;
    protected String commentString;
    private Date local_date;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.counter);
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
}
