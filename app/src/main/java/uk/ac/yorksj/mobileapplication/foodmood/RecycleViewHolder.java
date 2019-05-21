package uk.ac.yorksj.mobileapplication.foodmood;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class RecycleViewHolder extends RecyclerView.ViewHolder{

    public TextView contentText;

    public RecycleViewHolder(@NonNull View itemView) {
        super(itemView);
        contentText = itemView.findViewById(R.id.moodContent);
    }
}
