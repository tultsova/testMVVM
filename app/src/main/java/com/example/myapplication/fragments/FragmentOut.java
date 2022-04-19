package com.example.myapplication.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.R;
import com.example.myapplication.viewmodels.ViewModelOut;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class FragmentOut extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {
        View root = inflater.inflate(R.layout.fr_out, container, false);

        ViewModelOut vm = new ViewModelProvider(this).get(ViewModelOut.class);

        TextView tv = root.findViewById(R.id.tx);
        vm.getMessage().observe(getViewLifecycleOwner(), tv::setText);

        Button but = root.findViewById(R.id.but2);
        but.setOnClickListener(view -> {
            FragmentManager fm = requireActivity().getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fc, new FragmentIn());
            ft.addToBackStack(null);
            ft.commit();
        });

        return root;
    }
}
