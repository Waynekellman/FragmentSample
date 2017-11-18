package com.c4q.basicfragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    boolean isFragmentShown = false;
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button1).setOnClickListener(this);
        manager = getFragmentManager();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button1) {
            FragmentTransaction transaction = manager.beginTransaction();

            if (!isFragmentShown) {
                //initialize a fragment on start-up
                transaction.replace(R.id.fagment_container, new BaseFragment());
                transaction.addToBackStack(null);
                transaction.commit();
                isFragmentShown = true;
            } else {
                isFragmentShown = false;
                onBackPressed();
            }
        }
    }
}
