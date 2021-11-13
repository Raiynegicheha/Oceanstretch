package com.raiyne.oceanstreach;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class AccountActivity extends AppCompatActivity {
    RadioButton myrbpoultry,myrbpet,myrbdomestic,myrbwild;
    Button mybtnaddpost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_account);

        myrbpoultry = findViewById(R.id.rb_poultry);
        myrbpet = findViewById(R.id.rb_pet);
        myrbdomestic = findViewById(R.id.rb_domestic);
        myrbwild = findViewById(R.id.rb_wild);
        mybtnaddpost = findViewById(R.id.btnaddpost);


        mybtnaddpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent post= new Intent(AccountActivity.this,UploadimageActivity.class);
                startActivity(post);
            }
        });



    }
}