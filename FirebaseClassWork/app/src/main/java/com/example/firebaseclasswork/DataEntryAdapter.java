package com.example.firebaseclasswork;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class DataEntryAdapter extends ArrayAdapter<DataEntry> {
    private LayoutInflater inflater;

    public DataEntryAdapter(Context context, List<DataEntry> dataList) {
        super(context, 0, dataList);
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null) {
            itemView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
        }

        DataEntry dataEntry = getItem(position);
        TextView textViewName = itemView.findViewById(android.R.id.text1);
        textViewName.setText(dataEntry.getName());

        return itemView;
    }
}
