package com.github.maksimkirko.fragment_backstack_demo;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

public class FragmentMain extends Fragment {

    private static final String EXTRAS_TITLE = "EXTRAS_TITLE";

    private TextView textView;
    private String title;

    public void setTitle(@NotNull String title) {
        this.title = title;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, null);

        textView = view.findViewById(R.id.text_view_fragment_main_title);

        if (savedInstanceState != null) {
            title = savedInstanceState.getString(EXTRAS_TITLE);
        }

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        textView.setText(title);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString(EXTRAS_TITLE, title);
        super.onSaveInstanceState(outState);
    }
}