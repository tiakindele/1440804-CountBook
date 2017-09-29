package toluwani.countbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;

public class ListCountersActivity extends AppCompatActivity {

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
