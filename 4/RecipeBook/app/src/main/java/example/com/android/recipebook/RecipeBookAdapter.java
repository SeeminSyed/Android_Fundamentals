package example.com.android.recipebook;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class RecipeBookAdapter extends RecyclerView.Adapter<RecipeBookAdapter.RecipeViewHolder> {

    public static final String EXTRA_POSITION = "example.com.android.recipebook.RecipeBookAdapter.POSITION";

    private LayoutInflater mInflater;
    private String[] nameArray;
    private String[] descArray;

    public RecipeBookAdapter(Context context, String[] nameArray, String[] descArray) {
        mInflater = LayoutInflater.from(context);
        this.nameArray = nameArray;
        this.descArray = descArray;
    }

    @Override
    public RecipeBookAdapter.RecipeViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {
        View mItemView = mInflater.inflate(R.layout.recipelist_item, viewGroup, false);
        return new RecipeViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder( RecipeViewHolder recipeViewHolder, int i) {
        recipeViewHolder.recipeNameView.setText(nameArray[i]);
        recipeViewHolder.recipeDescView.setText(descArray[i]);
    }

    @Override
    public int getItemCount() {
        return nameArray.length;
    }

    public class RecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public final TextView recipeNameView;
        public final TextView recipeDescView;
        final RecipeBookAdapter mAdapter;

        public RecipeViewHolder(View itemView, RecipeBookAdapter adapter) {
            super(itemView);
            recipeNameView = itemView.findViewById(R.id.recipe_name);
            recipeDescView = itemView.findViewById(R.id.recipe_desc);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            // Get the position of the item that was clicked.
            int mPosition = getLayoutPosition();

            // USE THIS String  = v.getContext().getResources().getStringArray(R.array.recipe_names)[mPosition];

            Intent intent = new Intent(v.getContext(), Main2Activity.class);
            intent.putExtra(EXTRA_POSITION, mPosition);
            v.getContext().startActivity(intent);
        }
    }
}
