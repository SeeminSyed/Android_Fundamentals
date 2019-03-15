package android.com.example.HelloConstraint;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // makes the mShowCount text view to be used in countUp
        mShowCount = (TextView) findViewById(R.id.show_count);
    }

    public void showToast(View view) {
        /*
        Creates an instance of toast and makes its text using the function,
        where arg0 is the current activity context
        arg1 is the message, taken from the resources/string.xml file
        srg2 is the length of the toast, 2 sec here, 3.5 for Toast.LENGTH_LONG
         */
        Toast toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT);

        // Shows the toast
        toast.show();
    }

    public void updateView() {
        // puts mCount in the text view created onCreate
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));

    }

    public void countUp(View view) {
        mCount++;

        // puts mCount in the text view created onCreate
        updateView();

        // makes the button_count blue or green
        if (mCount%2 == 0) {
            view.setBackgroundColor(0xFF0000FF);
        } else {
            view.setBackgroundColor(0xFF008000);
        }

        // find the view for button_zero and set the background to coloured by getting resources and getting the colour from android
        findViewById(R.id.button_zero).setBackgroundColor(getResources().getColor(android.R.color.holo_red_dark));

    }

    public void resetCounter(View view) {
        mCount = 0;
        // makes the view sent here blue from grey, ie button_zero
        view.setBackgroundColor(getResources().getColor(android.R.color.darker_gray));

        // puts mCount in the text view created onCreate
        updateView();

        // returns button_count to its colour for 0
        findViewById(R.id.button_count).setBackgroundColor(0xFF0000FF);
    }
}
