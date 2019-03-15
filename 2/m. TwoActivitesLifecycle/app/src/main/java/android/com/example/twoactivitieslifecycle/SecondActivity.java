package android.com.example.twoactivitieslifecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    // getting the name of the activity
    private static final String LOG_TAG = SecondActivity.class.getSimpleName();

    public static final String EXTRA_REPLY = "android.com.example.twoactivities.extra.REPLY";
    private EditText mReply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // get intent
        Intent intent = getIntent();

        // remember:     public static final String EXTRA_MESSAGE = "com.example.android.twoactivities.extra.MESSAGE";
        // so it is accessible from here
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // get the TextView to which the message should be put
        TextView textView = findViewById(R.id.text_message);

        // set the new message
        textView.setText(message);
    }

    public void returnReply(View view) {
        // make intent, get content, put extra, sent off
        Intent replyIntent = new Intent(this, MainActivity.class);

        mReply = findViewById(R.id.editText_second);
        String reply = mReply.getText().toString();

        replyIntent.putExtra(EXTRA_REPLY, reply);

        // Set the result to RESULT_OK to indicate that the response was successful. The Activity class defines the result codes, including RESULT_OK and RESULT_CANCELLED.
        setResult(RESULT_OK,replyIntent);

        // Call finish() to close the Activity and return to MainActivity.
        Log.d(LOG_TAG, "End SecondActivity");
        finish();

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy SecondActivity");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop SecondActivity");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume SecondActivity");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart SecondActivity");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause SecondActivity");
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.d(LOG_TAG, "onStart SecondActivity");
    }
}
