package ie.ul.register_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class homepage extends AppCompatActivity {
    private Button passengerbutton;
    private Button driverbutton;
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
        passengerbutton.setOnClickListener(new View.OnClickListener()



        {
            @Override
            public void onClick(View view) {
                openpassengerhome();


            }
        });
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