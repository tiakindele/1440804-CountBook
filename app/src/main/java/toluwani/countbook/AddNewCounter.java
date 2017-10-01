package toluwani.countbook;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.MainThread;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import static android.R.id.list;
import static toluwani.countbook.R.id.addItemField;
import static toluwani.countbook.R.id.editCountersList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


/**
 * Created by tiakindele on 2017-09-27.
 */

public class AddNewCounter extends Activity{
    private static final String FILENAME = "file.sav";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_counter);
    }

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
        //Log.d("D", "###### addItemField: "+ name.getText().toString() +"CHECK CHECK CHECK#############");
        clc.addCounter(counter);
        Intent i = new Intent(AddNewCounter.this, MainActivity.class);
        startActivity(i);
    }

}
