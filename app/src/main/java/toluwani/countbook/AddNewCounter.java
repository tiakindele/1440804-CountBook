package toluwani.countbook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by tiakindele on 2017-09-27.
 */

public class AddNewCounter extends Activity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_counter);
    }
    public void saveNewClicked(View view) {
            Intent i = new Intent(AddNewCounter.this, MainActivity.class);
            startActivity(i);
    }
}
