package com.example.learningapp.design;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learningapp.R;
import com.example.learningapp.model.GridArrayList;

import java.util.ArrayList;

public class GridCustomAdapter extends RecyclerView.Adapter<GridCustomAdapter.MyHolder> {

    private final Context context;
    private final ArrayList<GridArrayList> gridArrayLists;
    private final LayoutInflater inflater;

    public GridCustomAdapter(Context context, ArrayList<GridArrayList> gridArrayLists) {
        this.context = context;
        this.gridArrayLists = gridArrayLists;
        inflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.grid_layout,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        GridArrayList arrayList=gridArrayLists.get(position);
        holder.imageView.setImageResource(arrayList.getStudyicon());
        holder.textView.setText(arrayList.getStudyname());
  holder.setClickMethod(position);
    }

    @Override
    public int getItemCount() {
        return gridArrayLists.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
private final ImageView imageView;
private final TextView textView;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.grid_image);
            textView=itemView.findViewById((R.id.grid_text));
        }

        public void setClickMethod(int position){

            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    GridArrayList list=gridArrayLists.get(position);
                    Toast.makeText(context,"Study Material"+list.getStudyname(),Toast.LENGTH_SHORT).show();

                }
            });

        }
    }
}








