package toluwani.countbook;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.format.DateFormat;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by tiakindele on 2017-09-27.
 */

public class Counter extends Activity{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.counter);
    }

    protected String counterName;
    protected String counterDate;
    protected Integer currentVal;
    protected Integer initialVal;
    protected String commentString;
    private Date local_date;

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


}
