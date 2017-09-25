package styleomega.cb006456.styleomega;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import styleomega.cb006456.styleomega.Adapters.CartListAdapter;
import styleomega.cb006456.styleomega.Adapters.ProductListAdapter;
import styleomega.cb006456.styleomega.Model.Cart;
import styleomega.cb006456.styleomega.Model.Product;

public class CartActivity extends AppCompatActivity {

    SQLiteHelper sqLiteHelper;
    ListView list;
    private static String TAG = CartActivity.class.getSimpleName();
    Cart cart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        sqLiteHelper = new SQLiteHelper(this);
        list = (ListView) findViewById(R.id.cart_list);
        cart = sqLiteHelper.getCartData(getIntent().getStringExtra("emailholder"));

        if(cart.getProducts().size()>0)Log.d(TAG, "onCreate: "
                +cart.getProducts().keySet().size()+
                ((Product)cart.getProducts().keySet().toArray()[0]).getName());
        CartListAdapter ListAdpater =  new CartListAdapter(this, R.layout.cart_list_item, cart);
        list.setAdapter(ListAdpater);

    }


    public void onCheckout(View view) {

        Intent intent = new Intent(this, CheckoutActivity.class);
        sqLiteHelper.removeAllFromCart(cart.getUsername());
        intent.putExtra("total",cart.getTotal());
        startActivity(intent);
    }
}
