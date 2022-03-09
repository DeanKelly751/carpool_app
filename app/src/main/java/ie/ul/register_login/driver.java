package ie.ul.register_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class driver extends AppCompatActivity {

    private Button homebutton;

    Button list;
    EditText locationtext , destinationText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver);

        homebutton=(Button) findViewById(R.id.homeButton1);
        homebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                home();
            }
        });

        destinationText = (EditText) findViewById(R.id.editDest);


        locationtext = (EditText) findViewById(R.id.editLocation);
        list = (Button) findViewById(R.id.confirmList);

        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = locationtext.getText().toString() + "-> " + destinationText.getText().toString();

                Intent intent = new Intent(getApplicationContext(),passenger.class);
                intent.putExtra("message", str);

                startActivity(intent);
            }
        });

    }

    public void home(){
        Intent intent = new Intent(this, homepage.class);
        startActivity(intent);
    }


}