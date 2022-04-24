package ie.ul.register_login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import kotlin.jvm.internal.Intrinsics;

public class homepage extends AppCompatActivity {
    private Button passengerbutton;
    private Button driverbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        View var10000 = this.findViewById(R.id.logoutBtn1);
        Intrinsics.checkNotNullExpressionValue(var10000, "findViewById (R.id.logoutBtn1)");
        Button logoutBtn1 = (Button)var10000;
        logoutBtn1.setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View it) {
                Intent intent = new Intent((Context)homepage.this, MainActivity.class);
                homepage.this.startActivity(intent);
            }
        }));

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