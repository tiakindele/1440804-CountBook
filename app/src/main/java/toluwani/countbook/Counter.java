package toluwani.countbook;

import android.app.Activity;

import java.util.Date;

/**
 * Created by tiakindele on 2017-09-27.
 */

public class Counter extends Activity{
    protected String counterName;
    protected Date counterDate;
    protected Integer currentVal;
    protected Integer initialVal;
    protected String commentString;

    public Counter(String counterName, Date counterDate, Integer currentVal, Integer initialVal,
                   String commentString) {
        this.counterName = counterName;
        this.counterDate = counterDate;
        this.currentVal = currentVal;
        this.initialVal = initialVal;
        this.commentString = commentString;
    }

    public String getCounterName() {
        return counterName;
    }
    public Date getCounterDate() {
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
}
