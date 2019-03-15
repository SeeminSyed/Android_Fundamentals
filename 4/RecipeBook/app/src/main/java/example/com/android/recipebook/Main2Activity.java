package example.com.android.recipebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private String[] recipes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recipes = getResources().getStringArray(R.array.recipe_long_desc);

        Intent intent = getIntent();
        int position = intent.getIntExtra(RecipeBookAdapter.EXTRA_POSITION, -1);

        TextView desc = findViewById(R.id.recipe_full);

        if(position != -1) {
            desc.setText(recipes[position]);
        } else {
            desc.setText("hi");
        }


    }
}
