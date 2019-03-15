package android.com.example.TwoActivitiesHomework;

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

        Intent intent = getIntent();

        int count = intent.getIntExtra(MainActivity.EXTRA_COUNT, 0);
        Log.d("Main2Activity", "onCreate: just got count value");


        TextView textview = findViewById(R.id.textView_count);

        Log.d("Main2Activity", "onCreate: just got text view");

        textview.setText(Integer.toString(count));

    }
}
