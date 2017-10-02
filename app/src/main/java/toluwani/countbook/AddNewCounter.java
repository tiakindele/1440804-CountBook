/**
 * Add New Counter
 *
 * AddNewCounter class will help users add new counters and the necessary information
 * into the CountBook. It takes in item name, date, initial value and the comment.
 * It also uses the initial value as the current value (for now).
 * As for date, if it's not filled out, the current date will replace it.
 *
 * Oct 1 2017
 *
 * Decided on this format because it's simplicity. All the necessary information
 * is taken in from the user and sent to Count book with little room for error.
 * I used log messages to check the output and to the best of my knowledge,
 * this part of the code works fine.
 */

package toluwani.countbook;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.text.ParseException;
import java.util.Date;


/**
 * Created by tiakindele on 2017-09-27.
 */

public class AddNewCounter extends Activity{
    private static final String FILENAME = "file.sav";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_counter);
    }

    /**
     * When new information is added, it is confirmed by clicking DONE.
     * When DONE is clicked, all the information is passed to the controller.
     * @param view
     */
    @TargetApi(Build.VERSION_CODES.N)
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void saveNewClicked(View view) {
        Date date = new Date();
        Toast.makeText(this, "Counter Added!", Toast.LENGTH_SHORT).show();
        CounterListController clc = new CounterListController();
        EditText name = findViewById(R.id.addItemField);
        EditText dateVal = findViewById(R.id.addDateField);
        EditText iniVal = findViewById(R.id.initialValueField);
        EditText curVal = findViewById(R.id.initialValueField);
        EditText cmmntVal = findViewById(R.id.commentField);

        if (dateVal.getText().toString().trim().length() == 0) {

        } else {
            String dateVal_string = dateVal.getText().toString();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            try {
                date = format.parse(dateVal_string);
            } catch(ParseException e) {
                e.printStackTrace();
            }
        }


        Counter counter = new Counter(name.getText().toString(),
                date,
                Integer.parseInt(String.valueOf(iniVal.getText())),
                Integer.parseInt(String.valueOf(curVal.getText())),
                cmmntVal.getText().toString());
        clc.addCounter(counter);

        Intent i = new Intent(AddNewCounter.this, MainActivity.class);
        startActivity(i);
    }

}
