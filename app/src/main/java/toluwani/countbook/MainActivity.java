package toluwani.countbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int countInt = 0;
    private TextView counterView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counterView = (TextView)findViewById(R.id.counterView);
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
}
