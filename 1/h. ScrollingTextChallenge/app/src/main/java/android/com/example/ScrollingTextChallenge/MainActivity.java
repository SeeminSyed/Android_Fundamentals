package android.com.example.ScrollingTextChallenge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
      Use a ScrollView to scroll a single child View (such as a TextView). A ScrollView can hold only one child View or ViewGroup.
      Use a ViewGroup such as LinearLayout as a child View within a ScrollView to scroll more than one View element. Enclose the elements within the LinearLayout.
      Display free-form text in a TextView with HTML formatting tags for bold and italics.
      Use \n as an end-of-line character in free-form text to keep a paragraph from running into the next paragraph.
      Use the android:autoLink="web" attribute to make web links in the text clickable.
     */
}
