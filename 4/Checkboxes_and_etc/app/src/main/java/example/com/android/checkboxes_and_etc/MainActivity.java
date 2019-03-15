package example.com.android.checkboxes_and_etc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    public void showToppings(View view) {
        boolean topping_present = false;
        String message = "Toppings:";

        CheckBox checkbox = findViewById(R.id.choc_syrup_checkBox);
        if(checkbox.isChecked()) {
            message += " " + getString(R.string.chocolate_syrup);
            topping_present = true;
        }

        checkbox = findViewById(R.id.sprinkles_checkBox);
        if(checkbox.isChecked()) {
            message += " " + getString(R.string.sprinkles);
            topping_present = true;
        }

        checkbox = findViewById(R.id.crushed_nuts_checkBox);
        if(checkbox.isChecked()) {
            message += " " + getString(R.string.crushed_nuts);
            topping_present = true;
        }

        checkbox = findViewById(R.id.cherries_checkBox);
        if(checkbox.isChecked()) {
            message += " " + getString(R.string.cherries);
            topping_present = true;
        }

        checkbox = findViewById(R.id.oreo_crumbles_checkBox);
        if(checkbox.isChecked()) {
            message += " " + getString(R.string.oreo_cookie_crumbles);
            topping_present = true;
        }

        if(!topping_present){
            message += " none chosen";
        }

        displayToast(message);
    }

    public void checkboxCheck(View view) {
    }
}
