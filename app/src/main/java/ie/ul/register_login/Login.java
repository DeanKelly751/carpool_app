package ie.ul.register_login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    //Declaring different variables
    EditText mEmail,mPassword;
    TextView mRegisterButton;
    Button mLoginButton;
    ProgressBar progressBar;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Assigning our earlier declared variables to their xml file ID's
        mEmail    = findViewById(R.id.email);
        mPassword = findViewById(R.id.password);
        fAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar);
        mRegisterButton = findViewById(R.id.registerButton);
        mLoginButton = findViewById(R.id.loginButton);

        //When login button is clicked
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                //change our email and password to strings
                //this is to add requirements
                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();

                //email cannot be empty
                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Email is required");
                    return;
                }
                //password cannot be empty
                if(TextUtils.isEmpty(password)){
                    mPassword.setError("Password is required");
                    return;
                }


                //display progress bar to show user app is loading
                progressBar.setVisibility(View.VISIBLE);

                //authenticate user with firebase
                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>(){
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Login.this, "User Logged in", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), homepage.class));
                        }else{
                            //error handling
                            Toast.makeText(Login.this, "Error in logging in!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });

            }
        });

        mRegisterButton.setOnClickListener(new View.OnClickListener(){
            @Override
            //If you are on login page and need to go to register page
            public void onClick(View v){
                startActivity(new Intent(getApplicationContext(), Register.class));
            }


        });


    }
}
