package com.example.android.restful.data;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.restful.DetailsViewActivity;
import com.example.android.restful.R;
import com.example.android.restful.model.DataItem;

import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;

import static com.example.android.restful.model.DataItemFields.ID;

/**
 * Created by hp on 1/10/2018.
 */

public class MyAdapterRealmAdapter extends RealmRecyclerViewAdapter<DataItem, MyAdapterRealmAdapter.ViewHolder> {
    public static final String SINGLE_DATA_ITEM = "singleDataItem";
    private static final String TAG = MyAdapterRealmAdapter.class.getSimpleName();
    RecyclerViewClickListener mRecyclerViewClickListener;
    public MyAdapterRealmAdapter(@Nullable OrderedRealmCollection<DataItem> data, boolean autoUpdate) {
        super(data, true);
        mRecyclerViewClickListener = getCustomRecyclerViewListener();
        // Only set this if the model class has a primary key that is also a integer or long.
        // In that case, {@code getItemId(int)} must also be overridden to return the key.
        // See https://developer.android.com/reference/android/support/v7/widget/RecyclerView.Adapter.html#hasStableIds()
        // See https://developer.android.com/reference/android/support/v7/widget/RecyclerView.Adapter.html#getItemId(int)
        //setHasStableIds(true);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_data, parent, false
        );
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final DataItem dataItem = getItem(position);
        //noinspection ConstantConditions
        holder.textViewName.setText(dataItem.getItemName());
        holder.textViewCategory.setText(dataItem.getCategory());
        holder.textViewPrice.setText(String.format("Price: %s", String.valueOf(dataItem.getPrice())));
        holder.textViewDescription.setText(dataItem.getDescription());

    }

    private RecyclerViewClickListener getCustomRecyclerViewListener() {
        return new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, DataItem dataItem) {
                Log.i(TAG, dataItem.getId());
                Intent intent = new Intent(view.getContext(), DetailsViewActivity.class);
                intent.putExtra(ID, dataItem.getId());
                view.getContext().startActivity(intent);
            }
        };
    }

    public interface RecyclerViewClickListener {
        void onClick(View view, DataItem dataItem);
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textViewName;
        TextView textViewCategory;
        TextView textViewPrice;
        TextView textViewDescription;

        ViewHolder(View view) {
            super(view);
            textViewName = (TextView) view.findViewById(R.id.textViewName);
            textViewCategory = (TextView) view.findViewById(R.id.textViewCategory);
            textViewPrice = (TextView) view.findViewById(R.id.textViewPrice);
            textViewDescription = (TextView) view.findViewById(R.id.textViewDescription);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(), getAdapterPosition() + "", Toast.LENGTH_SHORT).show();
            mRecyclerViewClickListener.onClick(v, getItem(getAdapterPosition()));
        }
    }
}
