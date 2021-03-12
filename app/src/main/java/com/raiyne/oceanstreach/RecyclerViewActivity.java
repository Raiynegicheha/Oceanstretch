package com.raiyne.oceanstreach;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {

    ListView mylistview;
    ArrayList<Animals> animal;
    CustomAdapter adapter;
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        mylistview = findViewById(R.id.lv_animals);
        animal = new ArrayList<>();
        adapter = new CustomAdapter(this,animal);
        dialog = new ProgressDialog(this);
        dialog.setTitle("Loading");
        dialog.setMessage("Please wait...");

        Animals p1=new Animals("chicken","ruth@gmail.com","072345676","Hello few week old broiler");
        Animals p2=new Animals("chicken","ruth@gmail.com","072345676","Hello few week old broiler");
        Animals p3=new Animals("chicken","ruth@gmail.com","072345676","Hello few week old broiler");
        Animals p4=new Animals("chicken","ruth@gmail.com","072345676","Hello few week old broiler");
        Animals p5=new Animals("chicken","ruth@gmail.com","072345676","Hello few week old broiler");
        Animals p6=new Animals("chicken","ruth@gmail.com","072345676","Hello few week old broiler");
        Animals p7=new Animals("chicken","ruth@gmail.com","072345676","Hello few week old broiler");

        animal.add(p1);
        animal.add(p2);
        animal.add(p3);
        animal.add(p4);
        animal.add(p5);
        animal.add(p6);
        animal.add(p7);


        mylistview.setAdapter(adapter);




    }
}