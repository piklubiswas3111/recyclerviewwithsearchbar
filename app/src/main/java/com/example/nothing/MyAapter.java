package com.example.nothing;

import android.content.Context;
import android.content.Intent;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAapter extends RecyclerView.Adapter<MyAapter.Hoder> implements Filterable {
    ArrayList<Model> data;
    ArrayList<Model> backup;
    Context context;


    public MyAapter(ArrayList<Model> data, Context context) {
        this.data = data;
        this.context = context;
        backup = new ArrayList<>(data);

    }

    @NonNull
    @Override
    public Hoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.row, parent, false);
        return new Hoder(view);
    }

    // Attach image and text(Heading and Description)

    @Override
    public void onBindViewHolder(@NonNull Hoder holder, int position) {
        holder.imageView.setImageResource(data.get(position).getImage());
        holder.textViewone.setText(data.get(position).getHead());
        holder.textViewtwo.setText(data.get(position).getDesription());

//        You can define Imageview Click this area also
//
//        holder.imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, MainActivity2.class);
//
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                context.startActivities(new Intent[]{intent});
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    //Holder Class exteds ViewHolder Class
    public class Hoder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textViewone, textViewtwo;

        public Hoder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imag);
            textViewone = (TextView) itemView.findViewById(R.id.head);
            textViewtwo = (TextView) itemView.findViewById(R.id.desription);
            //This code for itemview or Row Click

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, MainActivity2.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivities(new Intent[]{intent});
                }
            });

            //This code for imageview Click
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, MainActivity2.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivities(new Intent[]{intent});
                }
            });

        }
    }
//
    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence keyword) {
            ArrayList<Model> filterdata = new ArrayList<>();
            if (keyword.toString().isEmpty()) {
                filterdata.addAll(backup);
            } else {
                for (Model obj : backup) {
                    if (obj.getHead().toString().toLowerCase().contains(keyword.toString().toLowerCase())) {
                        filterdata.add(obj);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filterdata;
            return results;

        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            data.clear();
            data.addAll((ArrayList<Model>)results.values);
            notifyDataSetChanged();
        }
    };
}


