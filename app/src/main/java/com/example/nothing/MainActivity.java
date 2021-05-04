package com.example.nothing;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {
RecyclerView recyclerView;
MyAapter adtpter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView=(RecyclerView)findViewById(R.id.recleview);

        // If you need GridView then

        //recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        // Change row layout

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adtpter= new MyAapter(datastore(),getApplicationContext());
        recyclerView.setAdapter(adtpter);
    }

    //Set all data

    public ArrayList<Model> datastore(){
        ArrayList<Model> holder= new ArrayList();

        Model obj=new Model();
        obj.setImage(R.drawable.ic_launcher_foreground);
       obj.setHead("This is head");
       obj.setDesription("This is Description");
       holder.add(obj);


        Model obj1=new Model();
        obj1.setImage(R.drawable.six);
        obj1.setHead("This is head");
        obj1.setDesription("This is Description");
        holder.add(obj1);


        Model obj2=new Model();
        obj2.setImage(R.drawable.fiv);
        obj2.setHead("This is head one");
        obj2.setDesription("This is Description one");
        holder.add(obj2);

        Model obj3=new Model();
        obj3.setImage(R.drawable.four);
        obj3.setHead("This is head two ");
        obj3.setDesription("This is Description two");
        holder.add(obj3);


        Model obj4=new Model();
        obj4.setImage(R.drawable.three);
        obj4.setHead("This is head tree");
        obj4.setDesription("This is Description tree");
        holder.add(obj4);

        Model obj5=new Model();
        obj5.setImage(R.drawable.two);
        obj5.setHead("This is head four");
        obj5.setDesription("This is Description four");
        holder.add(obj5);

        Model obj6=new Model();
        obj6.setImage(R.drawable.one);
        obj6.setHead("This is head five");
        obj6.setDesription("This is Description five");
        holder.add(obj6);


        return holder;
    }

}