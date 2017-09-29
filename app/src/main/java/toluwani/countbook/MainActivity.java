package toluwani.countbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static android.R.id.list;

public class MainActivity extends AppCompatActivity {

    private int countInt = 0;
    private TextView counterView;
    private ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counterView = (TextView)findViewById(R.id.counterView);
        ListView listView = (ListView)findViewById(R.id.counterContent);
        Collection<Counter> counters = CounterListController.getCounterList().getCounters();
        ArrayList<Counter> list = new ArrayList<Counter>(counters);
        ArrayAdapter<Counter> counterAdapter = new ArrayAdapter<Counter>(this,
                android.R.layout.simple_list_item_1, list);
        listView.setAdapter(counterAdapter);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void editCounters(MenuItem menu) {
        Toast.makeText(this,"Edit Counters", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, ListCountersActivity.class);
        startActivity(intent);
    }

    public void incrementClicked(View view) {
        countInt++;
        counterView.setText(String.valueOf(countInt));
    }

    public void decrementClicked(View view) {
        countInt--;
        counterView.setText(String.valueOf(countInt));
    }

    public void editClicked(View view) {
    }

    public void deleteClicked(View view) {
    }

    public void resetClicked(View view) {
    }

    public void addNewClicked(View view) {
        if(view.getId() == R.id.newCounterButton){

            Intent i = new Intent(MainActivity.this, AddNewCounter.class);
            startActivity(i);
        }
    }

}
