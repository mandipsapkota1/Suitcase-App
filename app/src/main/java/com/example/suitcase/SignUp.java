package com.example.suitcase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {
    EditText email_signup, password_signup, confirmpassword_signup;
    Button btn_signup;
    TextView txt_signup;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        email_signup=findViewById(R.id.sigunp_email);
        password_signup=findViewById(R.id.sigunp_password);
        confirmpassword_signup=findViewById(R.id.confirm_password);
        btn_signup=findViewById(R.id.signup_btn);
        txt_signup=findViewById(R.id.login_txt);

        firebaseAuth = FirebaseAuth.getInstance();
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=email_signup.getText().toString().trim();
                String password=password_signup.getText().toString().trim();
                String cPassword=confirmpassword_signup.getText().toString().trim();

                if (email.isEmpty()) {
                    Toast.makeText(SignUp.this, "Enter Email", Toast.LENGTH_SHORT).show();
                }
                if (cPassword.isEmpty()) {
                    Toast.makeText(SignUp.this, "Enter Password", Toast.LENGTH_SHORT).show();
                }
                if (password.equals(cPassword)) {
                    firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Intent intent = new Intent(getApplicationContext(),Login.class);
                                startActivity(intent);
                                Toast.makeText(SignUp.this, "SignUp Completed", Toast.LENGTH_SHORT).show();
                                finish();
                            } else {
                                Toast.makeText(SignUp.this, "SignUp Not Completed", Toast.LENGTH_SHORT).show();


                            }
                        }
                    });
                }
            }
        });
    }
}