package uk.ac.yorksj.mobileapplication.foodmood;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewHolder> {

    private LayoutInflater layoutInflater;
    private ArrayList<Mood> mood;

    RecycleViewAdapter(ArrayList<Mood> moods, Context context) {

        this.layoutInflater = LayoutInflater.from(context);
        this.mood = moods;
    }


    public RecycleViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.recycler_row, parent, false);

        RecycleViewHolder viewHolder = new RecycleViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewHolder recycleViewHolder, int position) {

        Mood content = mood.get(position);

        recycleViewHolder.contentText.setText((CharSequence) content);
    }

    @Override
    public int getItemCount() {
        return mood.size();
    }
}
