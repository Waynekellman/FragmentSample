package com.c4q.basicfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Cool Awesome Stuff!
 */
public class BaseFragment extends Fragment {

    public void setListener(MyListener listener) {
        this.listener = listener;
    }

    private MyListener listener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout, container, false);
        // Initialize ids and such
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //button.

        if (listener != null) {
            listener.doStuff("passed data");
        }
    }


}
