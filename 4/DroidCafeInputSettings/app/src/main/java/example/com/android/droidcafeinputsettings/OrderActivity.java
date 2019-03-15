package example.com.android.droidcafeinputsettings;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

// An adapter connects your data—in this case, the array of spinner items—to the Spinner.
public class OrderActivity extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent intent = getIntent();
        String message = "Order: " + intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.order_textview);
        textView.setText(message);


        // Create Spinner
        Spinner phone_spinner = findViewById(R.id.label_spinner);
        if (phone_spinner != null) {
            phone_spinner.setOnItemSelectedListener(this);
        }
        // Create ArrayAdapter using the string array and default spinner layout.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.labels_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears.
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner.
        if (phone_spinner != null) {
            phone_spinner.setAdapter(adapter);
        }
    }

    public void onRadioButtonClicked(View view) {
        // Is the button checked?
        Boolean checked = ((RadioButton) view).isChecked();

        // Check which was checked
        switch (view.getId()) {
            case R.id.sameday:
                displayToast(getString(R.string.same_day_messenger_service));
                break;
            case R.id.nextday:
                displayToast(getString(R.string.next_day_ground_delivery));
                break;
            case R.id.pickup:
                displayToast(getString(R.string.pick_up));
                break;
            default:
                // do nothing
                break;
        }

    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String spinnerLabel = adapterView.getItemAtPosition(i).toString();
        displayToast(spinnerLabel);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
