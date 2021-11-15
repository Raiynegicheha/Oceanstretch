package com.raiyne.oceanstreach;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import static android.text.TextUtils.isEmpty;

public class SignUpActivity extends AppCompatActivity {
    EditText name, email, password, phonecontact;
    Button register, login;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up);


        name = findViewById(R.id.edt_createusername);
        email = findViewById(R.id.edt_email);
        password = findViewById(R.id.edt_password);
        phonecontact = findViewById(R.id.edt_phonenumber);
        register = findViewById(R.id.btn_register);
        login = findViewById(R.id.btn_login);
        mAuth = FirebaseAuth.getInstance();

        if (mAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), AccountActivity.class));
            finish();
        }


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String users = name.getText().toString();
                String emails = email.getText().toString();
                String passwords = password.getText().toString();
                String phonenumbers = phonecontact.getText().toString();



                if (TextUtils.isEmpty(emails)){
                    email.setError("Email is required");
                    return;
                }
                if (TextUtils.isEmpty(passwords)){
                    password.setError("Password is required.");
                    return;
                }

                if (passwords.length() <6){
                    password.setError("Password must be >= 6 Characters");
                    return;
                }


                DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("signins");
                Signup signup = new Signup(users, emails, passwords, phonenumbers);
                DatabaseReference ref = reference.push();

                ref.setValue(signup).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        if (task.isSuccessful()) {
                            Toast.makeText(SignUpActivity.this, "Registered", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), AccountActivity.class));
                        } else {
                            Toast.makeText(SignUpActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
    }
}



