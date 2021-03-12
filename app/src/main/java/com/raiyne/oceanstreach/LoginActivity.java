package com.raiyne.oceanstreach;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {
    TextView mtvusername;
    EditText myedtusername,myedtpassword;
    Button mybtnlogin,mybtnsignup;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        myedtusername = findViewById(R.id.edt_username);
        myedtpassword = findViewById(R.id.edt_password);

        mybtnlogin = findViewById(R.id.btn_login);
        mybtnsignup = findViewById(R.id.btn_signup);
        dialog = new ProgressDialog(this);
        dialog.setTitle("Loading");
        dialog.setMessage("Please wait...");

        mybtnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                isUser();
            }

        });

        mybtnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(i);
            }
        });


    }
    private void isUser(){
        dialog.show();
        String user = myedtusername.getText().toString().trim();
        String password = myedtpassword.getText().toString().trim();

        if (user.isEmpty() || password.isEmpty()){
            myedtusername.setError("Please fill in");
            myedtpassword.setError("Please fill in");
            myedtusername.requestFocus();
            myedtpassword.requestFocus();
        }else {
            DatabaseReference reference = FirebaseDatabase.getInstance().getReference("OceanStretch").child("signins");
            Query checkuser = reference.orderByChild("name").equalTo(user);
            checkuser.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    dialog.dismiss();
                    if (snapshot.exists()){
                       String passwordFromDb = snapshot.child(user).child("password").getValue(String.class);
                        //String dbps = snapshot.child(user).child("password").getValue(String.class);

                        if (passwordFromDb.equals(password)){
                            Toast.makeText(LoginActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),AccountActivity.class));
                        }else {
                            Toast.makeText(LoginActivity.this, "False password", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(LoginActivity.this, "No such user", Toast.LENGTH_SHORT).show();
                    }
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

            }




    }
}