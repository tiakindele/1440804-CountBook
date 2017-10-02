/**
 * Main Activity
 *
 * This is the first page the user sees. On this page, the user can
 * also add a new counter and see a list of counters they have added.
 * Long tapping gives the option deleting the counter.
 * Next to the Add New Counter button, there is a tracker that keeps count of
 * how many items have been added. It's also updated when an item is deleted.
 *
 * Oct 01 2017
 *
 * The edit menu button was supposed to lead to the extra edit page but I
 * was not able to properly implement the edit page. However, the button
 * does work and is functional.
 */

package toluwani.countbook;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.LogPrinter;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by tiakindele on 2017-09-27.
 */

public class MainActivity extends AppCompatActivity implements Serializable{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CounterListManager.initManager(this.getApplicationContext());

        // Get counter information so that it can be displayed
        ListView listView = (ListView)findViewById(R.id.counterContent);
        Collection<Counter> counters = CounterListController.getCounterList().getCounters();
        final ArrayList<Counter> list = new ArrayList<Counter>(counters);
        final ArrayAdapter<Counter> counterAdapter = new ArrayAdapter<Counter>(this,
                android.R.layout.simple_list_item_1, list);
        listView.setAdapter(counterAdapter);

        // Attempt to count the number of counters
        counterCount();
            CounterListController.getCounterList().addListener(new Listener() {
            @Override
            public void update() {
                list.clear();
                Collection<Counter> counters = CounterListController.getCounterList().getCounters();
                list.addAll(counters);
                counterAdapter.notifyDataSetChanged();
            }
        });

        // On long click of element, give option of deleting
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
                        int size = CounterListController.getCounterList().getCounterCount();
                        int clInt = size;

                        // when DELETE is clicked, update the item counter on the main page
                        TextView itemCountView = (TextView) findViewById(R.id.itemCounter);
                        itemCountView.setText(String.valueOf(clInt));
                    }
                });
                adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int j) {
                        //do nothing
                    }
                });
                adb.show();
                return true;
            }
        });

        // On click of item, go to counter for the item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view,
                                    int pos, long id) {
                Intent i = new Intent(MainActivity.this, Counter.class);
                startActivity(i);
            }
        });
    }

    /**
     * Sets the item counter on the main page which shows
     * the number of items that has been added
     */
    private void counterCount() {
        CounterListController cl = new CounterListController();
        int size = cl.getCounterList().getCounterCount();
        int clInt = size;
        TextView itemCountView = (TextView) findViewById(R.id.itemCounter);
        itemCountView.setText(String.valueOf(clInt));
    }

    /**
     * Menu for Edit button
     * @param menu
     * @return
     */
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * Clicking Edit takes you to a blank, unimplemented page
     * @param menu
     */
    public void editCounters(MenuItem menu) {
        Toast.makeText(this,"Edit Counters", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, ListCountersActivity.class);
        startActivity(intent);
    }

    /**
     * ADD NEW COUNTER. Takes you to a page to add all needed information
     * @param view
     */
    public void addNewClicked(View view) {
        if(view.getId() == R.id.newCounterButton){
            Intent i = new Intent(MainActivity.this, AddNewCounter.class);
            startActivity(i);
        }
    }

}
