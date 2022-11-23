package com.google.qlthuoctay;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {

    EditText edtEmail, edtPasswword, edtComfirmPassword;
    Button btnSignUp;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        AnhXa();
        BatSuKien();
    }

    public void AnhXa() {
        progressDialog = new ProgressDialog(this);
        edtEmail = findViewById(R.id.edt_email_signUp);
        edtPasswword = findViewById(R.id.edt_password_signUp);
        edtComfirmPassword = findViewById(R.id.edt_confirmPassword_signUp);
        btnSignUp = findViewById(R.id.btn_signUp);
    }

    public void BatSuKien() {
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickSignUp();
            }
        });
    }

    public void onClickSignUp() {
        String strEmail = edtEmail.getText().toString().trim();
        String strPassword = edtPasswword.getText().toString().trim();
        String strComfirmPassword = edtComfirmPassword.getText().toString().trim();
        FirebaseAuth auth = FirebaseAuth.getInstance();

        if(strPassword.equals(strComfirmPassword))
        {
            progressDialog.show();
            auth.createUserWithEmailAndPassword(strEmail, strPassword)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            progressDialog.dismiss();
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Intent intent = new Intent(SignUp.this, MainActivity.class);
                                startActivity(intent);
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(SignUp.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        } else{
            Toast.makeText(SignUp.this, "Xac nhan mat khau chua dung",Toast.LENGTH_SHORT).show();
        }
    }
}
