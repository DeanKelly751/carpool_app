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

    public class PaySystem extends AppCompatActivity {

        EditText mEmailPay, mNamePay, mAmountPay;
        Button mPayBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmailPay    = findViewById(R.id.enterEmail);
        mNamePay     = findViewById(R.id.enterName);
        mAmountPay   = findViewById(R.id.enterAmount);
        mPayBtn      = findViewById(R.id.BtnMakePayment);

        mPayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String email = mEmailPay.getText().toString().trim();
                String name = mNamePay.getText().toString().trim();
                String amount = mAmountPay.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    mEmailPay.setError("Email is required");
                    return;
                }

                if (TextUtils.isEmpty(amount)) {
                    mAmountPay.setError("Amount is required");
                    return;
                }

                if (TextUtils.isEmpty(name)) {
                    mNamePay.setError("Name is required");
                    return;
                }
            }
            });

        mPayBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(getApplicationContext(), homepage.class));
            }


        });


        }




    }