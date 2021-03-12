package com.raiyne.oceanstreach;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {
    EditText user,email,pass,phone;
    Button register,login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        user = findViewById(R.id.edt_createusername);
        email = findViewById(R.id.edt_email);
        pass= findViewById(R.id.edt_password);
        phone = findViewById(R.id.edt_phonenumber);

        register= findViewById(R.id.btn_register);
        login = findViewById(R.id.btn_login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignUpActivity.this,LoginActivity.class);
                startActivity(i);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String users = user.getText().toString();
                String emails = email.getText().toString();
                String passwords = pass.getText().toString();
                String phonenumbers = phone.getText().toString();

                DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("OceanStretch").child("signins");
                Signup signup = new Signup(users,emails,passwords,phonenumbers);
                DatabaseReference ref = reference.push();

                ref.setValue(signup).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(SignUpActivity.this, "Registered", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),AccountActivity.class));
                        }else {
                            Toast.makeText(SignUpActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
    }
}