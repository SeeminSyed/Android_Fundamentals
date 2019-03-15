package android.com.example.twoactiviteslifecyclechallenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int amount = 10;
        populateItems(amount);

    }

    private void populateItems(int amount) {
        //initialize x number of textviews
        TextView[] textBoxes = new TextView[amount];
        for(int i = 0; i < amount; i++) {
            //create the textview id
            String textViewID = "item" + "_" + i;
            // get the redID
            int resID = getResources().getIdentifier(textViewID, "id", getPackageName());

            // get the textviews
            textBoxes[i] = (TextView) findViewById(resID);
            // give them generic values
            textBoxes[i].setText("Item " + Integer.toString(i+1));
        }
    }

    // takes to new activity. doesnt need any extra
    public void shop(View view) {

        Intent intent = new Intent(this, Main2Activity.class);

        startActivity(intent);

    }
}
