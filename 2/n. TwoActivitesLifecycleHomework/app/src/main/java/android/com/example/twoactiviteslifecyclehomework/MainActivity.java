package android.com.example.twoactiviteslifecyclehomework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView counterView;
    private int mCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("MainActivity", "onCreate: ");

        counterView = (TextView) findViewById(R.id.textView);

        if (savedInstanceState != null) {
            mCount = savedInstanceState.getInt("counter_value");
            updateCounter();
        }
    }

    private void updateCounter() {
        if(counterView != null) {
            counterView.setText(Integer.toString(mCount));
        }
    }

    public void countUp(View view) {
        mCount++;
        Log.d("MainActivity", "countUp: "+ mCount);
        updateCounter();
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // counter value
        outState.putInt("counter_value", mCount);
    }
}
