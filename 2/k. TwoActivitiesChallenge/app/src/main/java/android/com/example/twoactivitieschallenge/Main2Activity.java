package android.com.example.twoactivitieschallenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Plan: get intent, get extra, based on extra, put to screen
        Intent intent = getIntent();

        int buttonPressed = intent.getIntExtra(MainActivity.EXTRA_BUTTON, 0);
        Log.d("Main2Activity", "onCreate: "+buttonPressed);

        TextView textView = findViewById(R.id.textView);
        switch(buttonPressed)
        {
            case 1:
                textView.setText(R.string.passage_one);
                Log.d("Main2Activity", "passage 1 ");
                break;

            case 2:
                textView.setText(R.string.passage_two);
                Log.d("Main2Activity", "passage 2");
                break;

            case 3:
                textView.setText(R.string.passage_three);
                Log.d("Main2Activity", "passage 3");
                break;

        }
    }
}
