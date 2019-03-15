package android.com.example.twoactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

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
        finish();

    }
}
