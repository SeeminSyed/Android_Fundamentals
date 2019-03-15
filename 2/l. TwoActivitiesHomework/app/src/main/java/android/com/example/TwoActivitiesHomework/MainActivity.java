package android.com.example.TwoActivitiesHomework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_COUNT = "android.com.example.TwoActivitiesHomework.extra.count";
    private int mCount = 0;
    private TextView mShowCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // makes the mShowCount text view to be used in countUp
        mShowCount = (TextView) findViewById(R.id.show_count);
    }

    // not used
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

    public void countUp(View view) {
        mCount++;
        // puts mCount in the text view created onCreate
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));

    }

    public void sayHello(View view) {

        Intent intent = new Intent(this, Main2Activity.class);

        intent.putExtra(EXTRA_COUNT, mCount);

        startActivity(intent);

    }
}
