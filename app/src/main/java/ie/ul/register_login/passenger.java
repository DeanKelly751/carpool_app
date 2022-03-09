package ie.ul.register_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class passenger extends AppCompatActivity {

    private Button homeb;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger);
        text = (TextView) findViewById(R.id.name);

        Intent intent = getIntent();
        String str = intent.getStringExtra("message");
        text.setText(str);

        homeb=(Button) findViewById(R.id.homep);
        homeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homep();
            }
        });



    }
    public void homep(){
        Intent intent = new Intent(this, homepage.class);
        startActivity(intent);
    }
}