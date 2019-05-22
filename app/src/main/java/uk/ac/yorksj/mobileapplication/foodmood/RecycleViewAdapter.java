package uk.ac.yorksj.mobileapplication.foodmood;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder>{
    private ArrayList<String> moodNames = new ArrayList<>();
    private ArrayList<String> moodGenres = new ArrayList<>();
    ArrayList<Integer> moodBlues = new ArrayList<>();
    ArrayList<Integer> moodGreens = new ArrayList<>();
    ArrayList<Integer> moodReds = new ArrayList<>();


    private Context context;
    public RecycleViewAdapter(){

    }
    public void addStuff(String name, String genre, int red, int green, int blue){
        moodNames.add(name);
        moodGenres.add(genre);

        moodReds.add(red);
        moodGreens.add(green);
        moodBlues.add(blue);
        notifyDataSetChanged();
    }

    public RecycleViewAdapter(ArrayList<String> moodNames, ArrayList<String> moodGenres, ArrayList<Color> moodColors, Context context) {
        this.moodNames = moodNames;
        this.moodGenres = moodGenres;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_list_item, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        try {

        viewHolder.moodName.setText(moodNames.get(i));
        viewHolder.genre.setText(moodGenres.get(i));
        viewHolder.previewColor.setBackgroundColor(getIntFromColor(moodReds.get(i), moodGreens.get(i), moodBlues.get(i)));
        }catch(Exception e){

        }
        viewHolder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    public int getIntFromColor(int Red, int Green, int Blue){
        Red = (Red << 16) & 0x00FF0000; //Shift red 16-bits and mask out other stuff
        Green = (Green << 8) & 0x0000FF00; //Shift Green 8-bits and mask out other stuff
        Blue = Blue & 0x000000FF; //Mask out anything not blue.

        return 0xFF000000 | Red | Green | Blue; //0xFF000000 for 100% Alpha. Bitwise OR everything together.
    }

    @Override
    public int getItemCount() {
        return moodNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView moodName;
        TextView genre;
        View previewColor;
        RelativeLayout layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            moodName = itemView.findViewById(R.id.recycle_mood_name);
            genre = itemView.findViewById(R.id.recycle_mood_genre);
            previewColor = itemView.findViewById(R.id.recycle_preview_color);
            layout = itemView.findViewById(R.id.parent_layout);
        }
    }
    }


