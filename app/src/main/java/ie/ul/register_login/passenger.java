package ie.ul.register_login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;


public class passenger extends AppCompatActivity {
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_passenger);
        View var10000 = this.findViewById(R.id.logoutBtn3);
        Intrinsics.checkNotNullExpressionValue(var10000, "findViewById (R.id.logoutBtn3)");
        Button logoutBtn3 = (Button)var10000;
        logoutBtn3.setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View it) {
                Intent intent = new Intent((Context)passenger.this, MainActivity.class);
                passenger.this.startActivity(intent);
            }
        }));

        var10000 = this.findViewById(R.id.bookBtn);
        Intrinsics.checkNotNullExpressionValue(var10000, "findViewById (R.id.logoutBtn1)");
        Button bookBtn = (Button)var10000;
        bookBtn.setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View it) {
                Intent intent = new Intent((Context)passenger.this, BookLift.class);
                passenger.this.startActivity(intent);
            }
        }));
        String liftName = this.getIntent().getStringExtra("EXTRA_MESSAGE1");
        String fromLocation = this.getIntent().getStringExtra("EXTRA_MESSAGE2");
        String destination = this.getIntent().getStringExtra("EXTRA_MESSAGE3");
        String price = this.getIntent().getStringExtra("EXTRA_MESSAGE4");
        String seats = this.getIntent().getStringExtra("EXTRA_MESSAGE5");
        String date = this.getIntent().getStringExtra("EXTRA_MESSAGE6");
        String time = this.getIntent().getStringExtra("EXTRA_MESSAGE7");
        View var12 = this.findViewById(R.id.upcomingLiftName1);
        TextView textViewDestination = (TextView)var12;
        boolean var14 = false;
        textViewDestination.setText((CharSequence)liftName);
        TextView textViewLiftName = (TextView)var12;
        View var22 = this.findViewById(R.id.upcomingLiftFL1);
        TextView textViewPrice = (TextView)var22;
        boolean var15 = false;
        textViewPrice.setText((CharSequence)fromLocation);
        TextView textViewFL = (TextView)var22;
        View var24 = this.findViewById(R.id.upcomingLiftDest1);
        TextView textViewSeats = (TextView)var24;
        boolean var16 = false;
        textViewSeats.setText((CharSequence)destination);
        textViewDestination = (TextView)var24;
        View var26 = this.findViewById(R.id.upcomingLiftPrice1);
        TextView textViewDate = (TextView)var26;
        boolean var17 = false;
        textViewDate.setText((CharSequence)price);
        textViewPrice = (TextView)var26;
        View var28 = this.findViewById(R.id.upcomingLiftSeats1);
        TextView textViewTime = (TextView)var28;
        boolean var18 = false;
        textViewTime.setText((CharSequence)seats);
        textViewSeats = (TextView)var28;
        View var30 = this.findViewById(R.id.upcomingLiftDate1);
        TextView $this$apply = (TextView)var30;
        boolean var19 = false;
        $this$apply.setText((CharSequence)date);
        textViewDate = (TextView)var30;
        View var32 = this.findViewById(R.id.upcomingLiftTime1);
        $this$apply = (TextView)var32;
        boolean var20 = false;
        $this$apply.setText((CharSequence)time);
        textViewTime = (TextView)var32;
    }
}
