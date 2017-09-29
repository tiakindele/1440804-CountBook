package toluwani.countbook;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
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


    private ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView)findViewById(R.id.counterContent);
        Collection<Counter> counters = CounterListController.getCounterList().getCounters();
        final ArrayList<Counter> list = new ArrayList<Counter>(counters);
        final ArrayAdapter<Counter> counterAdapter = new ArrayAdapter<Counter>(this,
                android.R.layout.simple_list_item_1, list);
        listView.setAdapter(counterAdapter);

        CounterListController.getCounterList().addListener(new Listener() {
            @Override
            public void update() {
                list.clear();
                Collection<Counter> counters = CounterListController.getCounterList().getCounters();
                list.addAll(counters);
                counterAdapter.notifyDataSetChanged();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view,
                                    int pos, long id) {
                Intent i = new Intent(MainActivity.this, Counter.class);
                startActivity(i);
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view,
                                           int pos, long id) {
                AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
                adb.setMessage("Are you sure you want to delete " +list.get(pos).toString()+"?");
                adb.setCancelable(true);
                final int finalPos = pos;
                adb.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Counter counter = list.get(finalPos);
                        CounterListController.getCounterList().removeCounter(counter);
                    }
                });
                adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int j) {
                        //do nothing
                    }
                });
                adb.show();
                return false;
            }
        });
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

    public void addNewClicked(View view) {
        if(view.getId() == R.id.newCounterButton){

            Intent i = new Intent(MainActivity.this, AddNewCounter.class);
            startActivity(i);
        }
    }

}
