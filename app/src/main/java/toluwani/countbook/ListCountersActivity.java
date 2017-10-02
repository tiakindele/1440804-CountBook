/**
 * List Counters Adapter
 *
 * Attempt at having the list show up on a second page and control edits from that page.
 * I was unable to implement if effectively.
 *
 * This class was built with the help of the Student Picker YouTube playlist by
 * Abram Hindle. However, the process and reason for this class is very clear to me.
 *
 * Oct 01 2017
 */

package toluwani.countbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by tiakindele on 2017-09-27.
 */

public class ListCountersActivity extends AppCompatActivity{

    private TextView counterView;
    private ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_counters);
    }
    public void saveNewEdit(View view) {
        Intent i = new Intent(ListCountersActivity.this, MainActivity.class);
        startActivity(i);
    }
}
