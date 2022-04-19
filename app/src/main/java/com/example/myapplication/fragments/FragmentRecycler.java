package com.example.myapplication.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.AdapterCard;
import com.example.myapplication.ModelCard;
import com.example.myapplication.R;
import com.example.myapplication.viewmodels.ViewModelOut;
import com.example.myapplication.viewmodels.ViewModelRecycler;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class FragmentRecycler extends Fragment {
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
        View root = inflater.inflate(R.layout.fr_recycler, container, false);

        ViewModelRecycler vm = new ViewModelProvider(this).get(ViewModelRecycler.class);
        RecyclerView rv = root.findViewById(R.id.recycler);
        rv.setHasFixedSize(true);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(requireActivity());
        rv.setLayoutManager(lm);
        AdapterCard adapterCard = new AdapterCard();
        rv.setAdapter(adapterCard);

        vm.getAllCards().observe(getViewLifecycleOwner(), modelCards -> {
            adapterCard.setCardslist(modelCards);
            adapterCard.notifyDataSetChanged();
        });

        return root;
    }
}
