package toluwani.countbook;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.util.Date;

import static java.lang.Integer.valueOf;

/**
 * Created by tiakindele on 2017-09-30.
 */

public class UpdateRecord extends AppCompatActivity {
    private Counter counterUpdate;
    private int index;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        CounterListManager.initManager(this.getApplicationContext());
        // retrieve what counter we want to update
        counterUpdate = (Counter) getIntent().getSerializableExtra("counter");
        index = getIntent().getIntExtra("index", 0);

        // set all fields to show the attribute values of the correct Counter
        TextView nametext = (TextView) findViewById(R.id.updatedAddItemField);
        nametext.setText(counterUpdate.getCounterName());

        Date date = counterUpdate.getCounterDate();
        // retrieve date
        TextView datetext = (TextView) findViewById(R.id.updatedAddDateField);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            // put date into proper yyyy-mm-dd format
            date = format.parse(datetext.getText().toString());
        } catch(ParseException e) {
            e.printStackTrace();
        }
        // set date field to date
        datetext.setText(format.format(date));

        TextView inVal = (TextView) findViewById(R.id.updatedInitialValueField);
        inVal.setText(counterUpdate.getInitialVal().toString());

        TextView updComment = (TextView) findViewById(R.id.updatedCommentField);
        updComment.setText(counterUpdate.getCommentString());


        // when the update button is pressed, this occurs
        Button edit_viewdetail = (Button) findViewById(R.id.updateButton);
        edit_viewdetail.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Record Updated", Toast.LENGTH_SHORT).show();

                EditText values = (EditText) findViewById(R.id.updatedAddItemField);
                String name = values.getText().toString();


                EditText values2 = (EditText) findViewById(R.id.updatedAddDateField);

                Date date = new Date();
                // convert string in certain format to proper date object
                String enterdate_string = values2.getText().toString();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    date = format.parse(enterdate_string);
                } catch(ParseException e) {
                    e.printStackTrace();
                }

                // set all values to the edited versions
                EditText entry3 = (EditText) findViewById(R.id.updatedInitialValueField);
                int initialVal = valueOf(entry3.getText().toString());

                EditText entry4 = (EditText) findViewById(R.id.updatedCommentField);
                String comment = entry4.getText().toString();

                EditText entry5 = (EditText) findViewById(R.id.updatedInitialValueField);
                int currVal = valueOf(entry5.getText().toString());

                // update counter (in CounterListController) to new values
                CounterListController updatept = new CounterListController();
                updatept.updateCounter(index, name, currVal, initialVal, date, comment);

                Intent intent = new Intent(UpdateRecord.this, MainActivity.class);
                startActivity(intent);
            }


        });



    }
}
