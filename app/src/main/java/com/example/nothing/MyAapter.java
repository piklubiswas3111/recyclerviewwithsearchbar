package com.example.nothing;

import android.content.Context;
import android.content.Intent;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAapter extends RecyclerView.Adapter<MyAapter.Hoder> {
    ArrayList<Model> data;
    Context context;


    public MyAapter(ArrayList<Model> data, Context context) {
        this.data = data;
        this.context = context;

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
                   Intent intent =new Intent(context,MainActivity2.class);
                   intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                   context.startActivities(new Intent[]{intent});
               }
           });

           //This code for imageview Click
           imageView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent intent =new Intent(context,MainActivity2.class);
                   intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                   context.startActivities(new Intent[]{intent});
               }
           });

        }
    }
}


class Model {
    //This araa set variable type all model class
    int Image;
    String head, desription;

    //This area set Setter and Getter
    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getDesription() {
        return desription;
    }

    public void setDesription(String desription) {
        this.desription = desription;
    }
}

