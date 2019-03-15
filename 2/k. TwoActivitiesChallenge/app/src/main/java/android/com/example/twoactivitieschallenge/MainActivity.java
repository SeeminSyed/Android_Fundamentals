package android.com.example.twoactivitieschallenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_BUTTON = "android.com.example.twoactivitieschallenge.extra.button";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showPassage(View view) {

        // Plan: make new intent connecting to next activity. find which button called function and put extra, start the activity

        Intent intent = new Intent(this, Main2Activity.class);

        // https://stackoverflow.com/questions/7873480/android-one-onclick-method-for-multiple-buttons/9989682
        switch(view.getId())
        {
            case R.id.button_one:
                // Code for button_one click
                intent.putExtra(EXTRA_BUTTON, 1);
                break;

            case R.id.button_two:
                // Code for button_two click
                intent.putExtra(EXTRA_BUTTON, 2);
                break;

            case R.id.button_three:
                // Code for button_three click
                intent.putExtra(EXTRA_BUTTON, 3);
                break;
        }

        startActivity(intent);
    }
}
