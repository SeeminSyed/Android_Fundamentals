package android.com.example.twoactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // getting the name of the activity
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    //
    private EditText mMessageEditText;
    public static final String EXTRA_MESSAGE = "com.example.android.twoactivities.extra.MESSAGE";

    // Add a public constant at the top of the class to define the key for a particular type of response you're interested in:
    public static final int TEXT_REQUEST = 1;

    private TextView mReplyHeadTextView;
    private TextView mReplyTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get the views
        mMessageEditText = findViewById(R.id.editText_main);

        // ---------------------- this comes later

        mReplyHeadTextView = findViewById(R.id.text_header_reply);
        mReplyTextView = findViewById(R.id.text_message_reply);

    }

    // when you click on SEND
    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "Button clicked!");

        /*
            connection between this class and one the info is going to
            Params:
            packageContext – A Context of the application package implementing this class.
            cls – The component class that is to be used for the intent.
         */
        Intent intent = new Intent(this, SecondActivity.class);

        // get the text in the edittext view
        String message = mMessageEditText.getText().toString();

        /*
            Params:
            name – The name of the extra data, with package prefix.
            value – The String data value.

            Returns:
            Returns the same Intent object, for chaining multiple calls into a single statement.
         */
        intent.putExtra(EXTRA_MESSAGE, message);


        /*
            When you use an explicit Intent to start another Activity, you may not expect to
            get any data back—you're just activating that Activity. In that case,
            you use startActivity() to start the new Activity, as you did earlier in this practical.
            If you want to get data back from the activated Activity, however, you need to start it
            with startActivityFromResult().

            Takes user to the other designated activity
            bc we want a result, startActivity(intent); is changed to the following
         */
        startActivityForResult(intent, TEXT_REQUEST);
    }
    // Override the onActivityResult() callback method with this signature:
    @Override
    public void onActivityResult(int requestCode,
                                 int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Add code to test for TEXT_REQUEST to make sure you process the right Intent result,
        // in case there are several.
        // Also test for RESULT_OK, to make sure that the request was successful:
        if (requestCode == TEXT_REQUEST) {
            // The Activity class defines the result codes.
            // The code can be RESULT_OK (the request was successful),
            // RESULT_CANCELED (the user cancelled the operation), or
            // RESULT_FIRST_USER (for defining your own result codes).
            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                // make the text view visible
                mReplyHeadTextView.setVisibility(View.VISIBLE);

                mReplyTextView.setText(reply);
                mReplyTextView.setVisibility(View.VISIBLE);

            }
        }
    }
}
