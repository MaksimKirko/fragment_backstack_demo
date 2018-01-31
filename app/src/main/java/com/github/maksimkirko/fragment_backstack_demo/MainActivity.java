package com.github.maksimkirko.fragment_backstack_demo;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity extends Activity implements View.OnClickListener {

    private FragmentTransaction fragmentTransaction;

    private Button addButton;
    private CheckBox addToBackstackCheckBox;

    private static int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        addToBackstackCheckBox = findViewById(R.id.check_box_activity_main_add_to_backstack);
        addButton = findViewById(R.id.button_activity_main_add);

        addButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        FragmentMain fragment = new FragmentMain();

        fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.layout_activity_main_fragment_container, fragment);

        if (addToBackstackCheckBox.isChecked()) {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();

        fragment.setTitle("Fragment " + ++count);
    }
}
