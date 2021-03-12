package com.raiyne.oceanstreach;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView mytvpoultry,mytvpet,mytvdomestic,mytvtrending,mytvdummy;
    ImageView myivsearchicon,myivpoultry,myivpet,myivdomestic,myivfavorite;
    EditText myedtsearchbar;
    Button mybtnpoultry;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);


        //textview

        mytvpoultry = findViewById(R.id.tv_name);
        mytvpet = findViewById(R.id.tv_pet);
        mytvdomestic = findViewById(R.id.tv_domestic);
        mytvtrending = findViewById(R.id.tv_trending);
        mytvdummy = findViewById(R.id.tv_dummy);





       //imageview

        myivsearchicon = findViewById(R.id.iv_search_icon);
        myivpoultry = findViewById(R.id.iv_poultry);
        myivpet = findViewById(R.id.iv_pet);
        myivdomestic = findViewById(R.id.iv_domestic);
        myivfavorite = findViewById(R.id.iv_favourite);

        


        //Edittext
        myedtsearchbar = findViewById(R.id.edt_search_bar);




        

        //Onclick listeners


        myivsearchicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        myivpoultry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        myivpet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        myivdomestic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navigation_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menuaccount){
            Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    public void poultry(View view) {
        String category = "poultry";
        Intent recy = new Intent(getApplicationContext(),RecyclerViewActivity.class);
        startActivity(recy);
    }

    public void pet(View view) {
        String category = "pet";
        Intent recy = new Intent(getApplicationContext(),RecyclerViewActivity.class);
        startActivity(recy);

    }

    public void domestic(View view) {
        String category = "domestic";
        Intent recy = new Intent(getApplicationContext(),RecyclerViewActivity.class);
        startActivity(recy);
    }

    public void wild(View view) {
        String category = "wild";
        Intent recy = new Intent(getApplicationContext(),RecyclerViewActivity.class);
        startActivity(recy);
    }
}