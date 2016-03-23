package com.devcamp.yapp.db;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by sin on 2016-02-27.
 */
public class NewActivityFragment extends android.app.Fragment {

    public NewActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View convertView = inflater.inflate(R.layout.fragment_main, container, false);

        return convertView;
    }
}
