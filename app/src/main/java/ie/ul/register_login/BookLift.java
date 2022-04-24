package ie.ul.register_login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;


public class BookLift extends AppCompatActivity {
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_book_lift);
        View var10000 = this.findViewById(R.id.bookLiftCancelBtn);
        Intrinsics.checkNotNullExpressionValue(var10000, "findViewById (R.id.bookLiftCancelBtn)");
        Button bookCancelBtn = (Button)var10000;
        bookCancelBtn.setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View it) {
                Intent intent = new Intent((Context)BookLift.this, passenger.class);
                BookLift.this.startActivity(intent);
            }
        }));
    }
}