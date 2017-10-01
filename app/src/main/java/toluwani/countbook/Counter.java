package toluwani.countbook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;
import java.text.SimpleDateFormat;
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

//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.counter);
//        counterView = (TextView)findViewById(R.id.counterView);
//        nameView = (TextView)findViewById(R.id.itemName);
//        Log.d("D", "########## onCreate Name is: "+ getCounterName() +" CHECK CHECK CHECK#############");
//        nameView.setText(getCounterName());
//        //nameView.setText("Item Name");
//        //Log.d("D", "##########"+ String.valueOf(getCounterName()) +"CHECK CHECK CHECK#############");
//    }

        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.counter);
        counterView = (TextView)findViewById(R.id.counterView);
        nameView = (TextView)findViewById(R.id.itemName);
        Log.d("D", "########## onCreate Name is: "+ getCounterName() +" CHECK CHECK CHECK#############");
        nameView.setText(getCounterName());
//        //nameView.setText("Item Name");
//        //Log.d("D", "##########"+ String.valueOf(getCounterName()) +"CHECK CHECK CHECK#############");
    }

    public Counter() {}

    public Counter(String counterName, Date counterDate, Integer currentVal, Integer initialVal,
                   String commentString) {
        this.counterName = counterName;
        this.counterDate = counterDate;
        this.currentVal = currentVal;
        this.initialVal = initialVal;
        this.commentString = commentString;
    }

    public String getCounterName() {
        String nameToSend = this.counterName;
        Log.d("D", "########## nameToSend: "+ nameToSend +" CHECK CHECK CHECK#############");
        Log.d("D", "########## initial val: "+ this.initialVal +" CHECK CHECK CHECK#############");
        return nameToSend;
    }
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
        Log.d("D", "########## toString: "+ nameVar +" CHECK CHECK CHECK#############");
        return nameVar;
    }

    public void incrementClicked(View view) {
        //Integer countInt = getCurrentVal();
        countInt++;
        counterView.setText(String.valueOf(countInt));
        this.currentVal = countInt;
    }

    public void decrementClicked(View view) {
        //int countInt = getCurrentVal();
        countInt--;
        counterView.setText(String.valueOf(countInt));
        this.currentVal = countInt;
    }

    public void backClicked(View view) {
        Intent i = new Intent(Counter.this, MainActivity.class);
        startActivity(i);
    }

    public void resetClicked(View view) {
    }


}
