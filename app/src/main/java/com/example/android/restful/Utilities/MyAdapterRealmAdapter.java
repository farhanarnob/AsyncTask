package com.example.android.restful.Utilities;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.restful.R;
import com.example.android.restful.model.DataItem;

import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;

/**
 * Created by hp on 1/10/2018.
 */

public class MyAdapterRealmAdapter extends RealmRecyclerViewAdapter<DataItem, MyAdapterRealmAdapter.ViewHolder> {

    public MyAdapterRealmAdapter(@Nullable OrderedRealmCollection<DataItem> data, boolean autoUpdate) {
        super(data, true);
        // Only set this if the model class has a primary key that is also a integer or long.
        // In that case, {@code getItemId(int)} must also be overridden to return the key.
        // See https://developer.android.com/reference/android/support/v7/widget/RecyclerView.Adapter.html#hasStableIds()
        // See https://developer.android.com/reference/android/support/v7/widget/RecyclerView.Adapter.html#getItemId(int)
        setHasStableIds(true);
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


    class ViewHolder extends RecyclerView.ViewHolder {
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
        }
    }
}
