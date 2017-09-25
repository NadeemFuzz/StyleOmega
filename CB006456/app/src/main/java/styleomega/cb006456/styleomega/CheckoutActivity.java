package styleomega.cb006456.styleomega;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class CheckoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        ((TextView) findViewById(R.id.total_text_value)).setText("Total Amount : "+Integer.toString(getIntent().getIntExtra("total",0)));
    }



    public void onLog(View view) {

        //Finishing current DashBoard activity on button click.\
        finish();

        //startActivity(new Intent(this, Login.class));
        startActivity(new Intent(this, Login.class));

        Toast.makeText(this,"Log Out Successful", Toast.LENGTH_LONG).show();
    }
}
