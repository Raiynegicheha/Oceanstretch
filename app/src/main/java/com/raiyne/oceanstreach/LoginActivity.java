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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
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
    FirebaseAuth mAuth;



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
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();



        mybtnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
                String user = myedtusername.getText().toString().trim();
                String password = myedtpassword.getText().toString().trim();

                if (user.isEmpty()||password.isEmpty()){
                    Toast.makeText(LoginActivity.this, "Please fill in the fields", Toast.LENGTH_SHORT).show();
                }else {

                }




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
        /*
    }
        progressBar.setVisibility(View.VISIBLE);
        final String userEnteredUsername = myedtusername.getEditText().getText().toString().trim();
        final String userEnteredPassword = myedtpassword.getEditText().getText().toString().trim();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUser = reference.orderByChild("username").equalTo(userEnteredUsername);
        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    username.setError(null);
                    username.setErrorEnabled(false);
                    String passwordFromDB = dataSnapshot.child(userEnteredUsername).child("password").getValue(String.class);
                    if (passwordFromDB.equals(userEnteredPassword)) {
                        username.setError(null);
                        username.setErrorEnabled(false);
                        String nameFromDB = dataSnapshot.child(userEnteredUsername).child("name").getValue(String.class);
                        String usernameFromDB = dataSnapshot.child(userEnteredUsername).child("username").getValue(String.class);
                        String phoneNoFromDB = dataSnapshot.child(userEnteredUsername).child("phoneNo").getValue(String.class);
                        String emailFromDB = dataSnapshot.child(userEnteredUsername).child("email").getValue(String.class);
                        Intent intent = new Intent(getApplicationContext(), UserProfile.class);
                        intent.putExtra("name", nameFromDB);
                        intent.putExtra("username", usernameFromDB);
                        intent.putExtra("email", emailFromDB);
                        intent.putExtra("phoneNo", phoneNoFromDB);
                        intent.putExtra("password", passwordFromDB);
                        startActivity(intent);
                    } else {
                        progressBar.setVisibility(View.GONE);
                        password.setError("Wrong Password");
                        password.requestFocus();
                    }
                } else {
                    progressBar.setVisibility(View.GONE);
                    username.setError("No such User exist");
                    username.requestFocus();
                }
            }*/
        dialog.show();
        String user = myedtusername.getText().toString().trim();
        String password = myedtpassword.getText().toString().trim();

        if (user.isEmpty() || password.isEmpty()){
            myedtusername.setError("Please fill in");
            myedtpassword.setError("Please fill in");
            myedtusername.requestFocus();
            myedtpassword.requestFocus();
        }else {

            Toast.makeText(LoginActivity.this, "No such user", Toast.LENGTH_SHORT).show();

            }
        dialog.dismiss();




    }
}