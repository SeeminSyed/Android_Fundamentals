package android.com.example.twoactivitieslifecycle;

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

        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "onCreate");

        // get the views
        mMessageEditText = findViewById(R.id.editText_main);

        // ---------------------- this comes later

        mReplyHeadTextView = findViewById(R.id.text_header_reply);
        mReplyTextView = findViewById(R.id.text_message_reply);


        // Restore the state.
        /*
        Subsequent calls to onCreate() have a bundle populated with the data you stored
        in onSaveInstanceState().
         */
        if (savedInstanceState != null) {
            boolean isVisible =
                    savedInstanceState.getBoolean("reply_visible");
            // of visible, change visibility of both and add the text needed
            if (isVisible) {
                mReplyHeadTextView.setVisibility(View.VISIBLE);
                mReplyTextView.setText(savedInstanceState.getString("reply_text"));
                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }

    }

    // when you click on SEND
    public void launchSecondActivity(View view) {

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


    /*
    when rotating, the configuration is reset.
    but the edit text auto saves its text.
    and in the second activity, everything is saved on rotate bc the info is in an intent that is the same.
    So the only Activity state you're interested in are the TextView elements for the reply header
    and the reply text in the main Activity.
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        if (mReplyHeadTextView.getVisibility() == View.VISIBLE) {
            outState.putBoolean("reply_visible", true);
            outState.putString("reply_text",mReplyTextView.getText().toString());

        }

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }
}
