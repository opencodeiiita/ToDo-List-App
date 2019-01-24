package com.example.shivansh.to_dolist;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ToDoTaskAdapter extends RecyclerView.Adapter<ToDoTaskAdapter.ToDoTaskViewHolder>{

    private String[] data;
    public ToDoTaskAdapter(String[] data)
    {
        this.data = data;
    }

    @NonNull
    @Override
    public ToDoTaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_todo, parent, false);
        return new ToDoTaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ToDoTaskViewHolder viewHolder, int i) {
        String title = data[i];
        viewHolder.txt.setText(title);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }
    public class ToDoTaskViewHolder extends ViewHolder{
        TextView txt;
        public ToDoTaskViewHolder(@NonNull View itemView) {
            super(itemView);
            txt = itemView.findViewById(R.id.txt);
        }
    }
}
