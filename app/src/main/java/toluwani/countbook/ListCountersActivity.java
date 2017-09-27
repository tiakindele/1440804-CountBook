package toluwani.countbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ListCountersActivity extends AppCompatActivity {

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
