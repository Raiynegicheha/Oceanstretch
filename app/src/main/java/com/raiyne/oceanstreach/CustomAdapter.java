package com.raiyne.oceanstreach;

import android.content.Context;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> implements Filterable  {

    Context context;
    ArrayList<Animals> animal;
    //ArrayList<Animals> listfull;
    private List<Animals> listfull;


    public CustomAdapter(Context context, ArrayList<Animals> animal) {
        this.context = context;
        this.animal = animal;
        listfull = new ArrayList<>(animal);
    }

    public CustomAdapter() {
    }


    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.animals_layout,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {

        Animals animals = animal.get(position);
        holder.name.setText(animals.getName());
        holder.email.setText(animals.getEmail());
        holder.number.setText(animals.getNumber());
        holder.description.setText(animals.getDescription());


        Glide.with(context).load(animal.get(position).getImageurl()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return animal.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name,email,number,description;
        ImageView imageView;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tv_name);
            email = itemView.findViewById(R.id.tv_email);
            number = itemView.findViewById(R.id.tv_number);
            description = itemView.findViewById(R.id.tv_description);
            imageView = itemView.findViewById(R.id.imageview2);
        }
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public Filter getFilter() {
        return examplefilter;
    }

    private Filter examplefilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Animals> filteredlist = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredlist.addAll(listfull);

            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Animals item : listfull) {
                    if (item.getName().toLowerCase().contains(filterPattern)){
                        filteredlist.add(item);
                    }
                }
            }
            FilterResults results =new FilterResults();
            results.values = filteredlist;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            animal.clear();
            animal.addAll((List)results.values);
        }
    };
}