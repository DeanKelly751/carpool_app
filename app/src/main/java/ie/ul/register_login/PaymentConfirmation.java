package ie.ul.register_login;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;

import android.widget.RatingBar;
import android.widget.TextView;

public class PaymentConfirmation extends AppCompatActivity {

    private Button homebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver);

        homebutton = (Button) findViewById(R.id.HomeBtn);
        homebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                home();
            }
        });

    }

    public void home(){
        Intent intent = new Intent(this, homepage.class);
        startActivity(intent);
    }


    //ADD RATING SYSTEM
    
}
