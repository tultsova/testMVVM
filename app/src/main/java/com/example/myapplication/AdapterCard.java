package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdapterCard extends RecyclerView.Adapter<AdapterCard.CardView> {

    private List<ModelCard> cardslist;

    public AdapterCard() {
        this.cardslist = new ArrayList<>();
    }

    public void setCardslist(List<ModelCard> cardslist) {
        this.cardslist = cardslist;
    }

    @NonNull
    @Override
    public CardView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card, parent, false);
        return new CardView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardView holder, int position) {
        ModelCard modelCard = cardslist.get(position);
        holder.getName().setText(modelCard.getName());
        holder.getLastname().setText(modelCard.getLastname());
        holder.getAge().setText(String.valueOf(modelCard.getAge()));
    }

    @Override
    public int getItemCount() {
        return cardslist.size();
    }

    class CardView extends RecyclerView.ViewHolder {

        private final TextView name;
        private final TextView lastname;
        private final TextView age;

        public CardView(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            lastname = itemView.findViewById(R.id.last);
            age = itemView.findViewById(R.id.age);
        }

        public TextView getName() {
            return name;
        }

        public TextView getLastname() {
            return lastname;
        }

        public TextView getAge() {
            return age;
        }
    }
}
