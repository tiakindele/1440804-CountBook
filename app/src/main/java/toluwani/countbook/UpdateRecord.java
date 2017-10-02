/**
 * I was unable to implement this part of my app. I left it in
 * to show my thought process. However, because I was having issues sending
 * information around different activities, this Class could not be implemented.
 *
 * Oct 01 2017
 */
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
        counterUpdate = (Counter) getIntent().getSerializableExtra("counter");
        index = getIntent().getIntExtra("index", 0);

        // Set variables to get update information from the user
        TextView nametext = (TextView) findViewById(R.id.updatedAddItemField);
        TextView datetext = (TextView) findViewById(R.id.updatedAddDateField);
        TextView inVal = (TextView) findViewById(R.id.updatedInitialValueField);
        TextView updComment = (TextView) findViewById(R.id.updatedCommentField);

        // Set texts for user to see
        Date date = counterUpdate.getCounterDate();
        nametext.setText(counterUpdate.getCounterName());
        updComment.setText(counterUpdate.getCommentString());
        inVal.setText(counterUpdate.getInitialVal().toString());

        // make date the right format
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = format.parse(datetext.getText().toString());
        } catch(ParseException e) {
            e.printStackTrace();
        }
        datetext.setText(format.format(date));

        // actions once update is clicked
        Button edit_viewdetail = (Button) findViewById(R.id.updateButton);
        edit_viewdetail.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Counter Updated", Toast.LENGTH_SHORT).show();

                // Get where the new information is placed
                EditText updName = (EditText) findViewById(R.id.updatedAddItemField);
                EditText updDate = (EditText) findViewById(R.id.updatedAddDateField);

                // Get the new date
                Date date = new Date();
                String name = updName.getText().toString();
                String newDate_string = updDate.getText().toString();

                // Format date
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    date = format.parse(newDate_string);
                } catch(ParseException e) {
                    e.printStackTrace();
                }

                EditText updIniVal = (EditText) findViewById(R.id.updatedInitialValueField);
                EditText updCmtVal = (EditText) findViewById(R.id.updatedCommentField);
                EditText updCurrVal = (EditText) findViewById(R.id.updatedInitialValueField);

                int initialVal = valueOf(updIniVal.getText().toString());
                String comment = updCmtVal.getText().toString();
                int currVal = valueOf(updCurrVal.getText().toString());

                CounterListController updClc = new CounterListController();
                updClc.updateCounter(index, name, currVal, initialVal, date, comment);

                // go back to Main Activity
                Intent intent = new Intent(UpdateRecord.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
