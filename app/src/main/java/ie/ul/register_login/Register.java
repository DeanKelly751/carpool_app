package ie.ul.register_login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {
    public static final String TAG = "TAG";
    EditText mFullName, mEmail, mPassword, mPhone;
    Button mRegisterButton;
    TextView mLoginButton;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    ProgressBar progressBar;
    String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        mFullName = findViewById(R.id.fullName);
        mEmail    = findViewById(R.id.email);
        mPassword = findViewById(R.id.password);
        mPhone    = findViewById(R.id.phoneNumber);
        mRegisterButton = findViewById(R.id.registerButton);
        mLoginButton = findViewById(R.id.loginButton);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        progressBar = findViewById(R.id.progressBar);

        if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

        mRegisterButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();
                String fullName = mFullName.getText().toString();
                String phone = mPhone.getText().toString();

                if(TextUtils.isEmpty(email)){
                   mEmail.setError("Email is required");
                   return;
                }

                if(TextUtils.isEmpty(password)){
                    mPassword.setError("Password is required");
                    return;
                }

                if(password.length() < 6){
                    mPassword.setError("Try making your password longer");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                //REGISTERING USER IN FIREBASE
                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>(){
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Register.this, "User Created", Toast.LENGTH_SHORT).show();
                            userId = fAuth.getCurrentUser().getUid();
                            DocumentReference documentReference = fStore.collection("users").document(userId);
                            //creating user data
                            Map<String,Object> user = new HashMap<>();
                            user.put("fName",fullName);
                            user.put("email",email);
                            user.put("phone",phone);
                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Log.d(TAG,"onSuccess: user created for "+ userId);
                                }
                            });
                            startActivity(new Intent(getApplicationContext(), Login.class));
                        }else{
                            Toast.makeText(Register.this, "Error !" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
            }

        });

        mLoginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
              //  startActivity(new Intent(getApplicationContext(), Login.class));
                openLogin();
            }
        });
    }
    public void openLogin(){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    public void goToLogin(View view){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(),Login.class));
        finish();
    }

}
