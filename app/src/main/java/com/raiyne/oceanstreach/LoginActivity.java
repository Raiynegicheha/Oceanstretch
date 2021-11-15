package com.raiyne.oceanstreach;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
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
    EditText myedtpassword,myedtemail;
    Button mybtnlogin,mybtnsignup;
    ProgressDialog dialog;
    FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);


        myedtpassword = findViewById(R.id.edt_password);
        myedtemail = findViewById(R.id.edt_email);

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
                String emails = myedtemail.getText().toString().trim();
                String passwords = myedtpassword.getText().toString().trim();

                if (TextUtils.isEmpty(emails)){
                    myedtemail.setError("Email is required");
                    return;
                }
                if (TextUtils.isEmpty(passwords)){
                    myedtpassword.setError("Password is required.");
                    return;
                }
                if (passwords.length() <6){
                    myedtpassword.setError("Password must be >= 6 Characters");
                    return;
                }

                //authenticate data
                mAuth.signInWithEmailAndPassword(emails,passwords).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(LoginActivity.this, "Logged in successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), AccountActivity.class));
                        }else {
                            Toast.makeText(LoginActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
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
        String user = myedtusername.getText().toString().trim();
        String password = myedtpassword.getText().toString().trim();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("signins");
        Query checkUser = reference.orderByChild("name").equalTo(user);
        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
                                                     @Override
                                                     public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                         if (dataSnapshot.exists()) {
                                                             name.setError(null);
                                                             name.setErrorEnabled(false);
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
                                                     }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        }
    }*/

        dialog.show();
        String email = myedtemail.getText().toString().trim();
        String password = myedtpassword.getText().toString().trim();

        if (email.isEmpty() || password.isEmpty()){
            myedtemail.setError("Please fill in");
            myedtpassword.setError("Please fill in");
            myedtemail.requestFocus();
            myedtpassword.requestFocus();
        }else {

            Toast.makeText(LoginActivity.this, "No such user", Toast.LENGTH_SHORT).show();

            }
        dialog.dismiss();
    }
}