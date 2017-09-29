package toluwani.countbook;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.MainThread;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import static android.R.id.list;
import static toluwani.countbook.R.id.addItemField;

/**
 * Created by tiakindele on 2017-09-27.
 */

public class AddNewCounter extends Activity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_counter);
    }

    @TargetApi(Build.VERSION_CODES.N)
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void saveNewClicked(View view) {
        Toast.makeText(this, "Counter Added!", Toast.LENGTH_SHORT).show();
        CounterListController clc = new CounterListController();
        EditText name = findViewById(R.id.addItemField);
        Counter counter = new Counter(name.getText().toString());
        clc.addCounter(counter);

        Intent i = new Intent(AddNewCounter.this, MainActivity.class);
        startActivity(i);
    }
}
