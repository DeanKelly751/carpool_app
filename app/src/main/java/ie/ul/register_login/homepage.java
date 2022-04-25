package ie.ul.register_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class homepage extends AppCompatActivity {
    private Button passengerbutton;
    private Button driverbutton;

    TextView mViewProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        driverbutton=(Button) findViewById(R.id.driverButton);
        driverbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opendriverhome();
            }
        });

        passengerbutton=(Button) findViewById(R.id.passengerButton);
        passengerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openpassengerhome();


            }
        });

        //View user profile and preview profile picture
        mViewProfile = findViewById(R.id.viewProfile);

        mViewProfile.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //  startActivity(new Intent(getApplicationContext(), Login.class));
                openProfilePage();
            }
        });
    }
    public void openProfilePage(){
        Intent intent = new Intent(this, ProfilePage.class);
        startActivity(intent);


    }

    public void opendriverhome(){
        Intent intent = new Intent(this, driver.class);
        startActivity(intent);
    }


    public void openpassengerhome() {
        Intent intent = new Intent(this, passenger.class);
        startActivity(intent);
    }
}
