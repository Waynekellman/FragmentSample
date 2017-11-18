package com.c4q.basicfragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MyListener, View.OnClickListener {

    @BindView(R.id.button1)
    Button toggleFragment;
    private boolean isFragmentShown = false;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        manager = getFragmentManager();
        toggleFragment.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button1) {
            FragmentTransaction transaction = manager.beginTransaction();

            if (!isFragmentShown) {

                BaseFragment fragment = new BaseFragment();
                fragment.setListener(this);

                transaction.replace(R.id.fagment_container, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
                isFragmentShown = true;
            } else {
                isFragmentShown = false;
                onBackPressed();
            }
        }
    }

    @Override
    public void doStuff(String stuff) {
        Toast.makeText(this, stuff, Toast.LENGTH_LONG).show();
    }

}
