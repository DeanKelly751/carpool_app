package ie.ul.register_login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;


public class driver extends AppCompatActivity {
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_driver);
        View var10000 = this.findViewById(R.id.addLiftCancelBtn);
        Intrinsics.checkNotNullExpressionValue(var10000, "findViewById (R.id.addLiftCancelBtn)");
        Button addLiftCancelBtn = (Button)var10000;
        addLiftCancelBtn.setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View it) {
                Intent intent = new Intent((Context)driver.this, homepage.class);
                driver.this.startActivity(intent);
            }
        }));
        var10000 = this.findViewById(R.id.addLiftBtn2);
        Intrinsics.checkNotNullExpressionValue(var10000, "findViewById(R.id.addLiftBtn2)");
        Button addLiftBtn = (Button)var10000;
        addLiftBtn.setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View it) {
                driver.this.addLift();
            }
        }));
    }

    private final void addLift() {
        EditText liftNameInput = (EditText)this.findViewById(R.id.createLiftLiftNameInput);
        Intrinsics.checkNotNullExpressionValue(liftNameInput, "liftNameInput");
        String liftName = liftNameInput.getText().toString();
        EditText fromLocationInput = (EditText)this.findViewById(R.id.createLiftFLInput);
        Intrinsics.checkNotNullExpressionValue(fromLocationInput, "fromLocationInput");
        String fromLocation = fromLocationInput.getText().toString();
        EditText destinationInput = (EditText)this.findViewById(R.id.createLiftDestInput);
        Intrinsics.checkNotNullExpressionValue(destinationInput, "destinationInput");
        String destination = destinationInput.getText().toString();
        EditText priceInput = (EditText)this.findViewById(R.id.createLiftPriceInput);
        Intrinsics.checkNotNullExpressionValue(priceInput, "priceInput");
        String price = priceInput.getText().toString();
        EditText seatsInput = (EditText)this.findViewById(R.id.createLiftSeatsInput);
        Intrinsics.checkNotNullExpressionValue(seatsInput, "seatsInput");
        String seats = seatsInput.getText().toString();
        EditText dateInput = (EditText)this.findViewById(R.id.createLiftDateInput);
        Intrinsics.checkNotNullExpressionValue(dateInput, "dateInput");
        String date = dateInput.getText().toString();
        EditText timeInput = (EditText)this.findViewById(R.id.createLiftTimeInput);
        Intrinsics.checkNotNullExpressionValue(timeInput, "timeInput");
        String time = timeInput.getText().toString();
        Intent var16 = new Intent((Context)this, passenger.class);
        boolean var18 = false;
        var16.putExtra("EXTRA_MESSAGE1", liftName);
        var16.putExtra("EXTRA_MESSAGE2", fromLocation);
        var16.putExtra("EXTRA_MESSAGE3", destination);
        var16.putExtra("EXTRA_MESSAGE4", price);
        var16.putExtra("EXTRA_MESSAGE5", seats);
        var16.putExtra("EXTRA_MESSAGE6", date);
        var16.putExtra("EXTRA_MESSAGE7", time);
        this.startActivity(var16);
    }
}
