package com.sashakhyzhun.wearexample;

/**
 * Created by Ramgopal on 2/5/2017.
 */

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ListViewAdapter extends ArrayAdapter<Note> {


    ListViewAdapter(Context context, int resource, List<Note> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (position == 0) {
            return LayoutInflater.from(this.getContext()).inflate(R.layout.new_note, parent, false);
        }
        convertView = LayoutInflater.from(this.getContext()).inflate(R.layout.custom_list_view, parent, false);

        Note note = getItem(position);

        TextView title = (TextView) convertView.findViewById(android.R.id.text1);

        title.setText(note.getTitle());
        return convertView;
    }
}
