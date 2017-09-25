package styleomega.cb006456.styleomega.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Arrays;

import styleomega.cb006456.styleomega.Model.Cart;
import styleomega.cb006456.styleomega.Model.Product;
import styleomega.cb006456.styleomega.R;
import styleomega.cb006456.styleomega.SQLiteHelper;

/**
 * Created by Nadeem on 8/30/2017.
 */

public class CartListAdapter extends ArrayAdapter<Product> {

    Cart cart;
    Context mContext;
    int layoutResourceId;
    private static String TAG = CartListAdapter.class.getSimpleName();

    public CartListAdapter(@NonNull Context context, @LayoutRes int resource, Cart cartList) {
        super(context, resource, Arrays.copyOf(cartList.getProducts().keySet().toArray(),
                cartList.getProducts().keySet().toArray().length,Product[].class));
        Log.d(TAG, "CartListAdapter: STart");
        this.mContext = context;
        this.layoutResourceId = resource;
        this.cart =  cartList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
        convertView = inflater.inflate(layoutResourceId, parent, false);

        Product[] products = Arrays.copyOf(cart.getProducts().keySet().toArray(),cart.getProducts().keySet().toArray().length,Product[].class);
        Log.d(TAG, "getView: "+products.length);
        final Product men = products[position];
        Log.d(TAG, "getView: "+men.getName());
        TextView id = (TextView) convertView.findViewById(R.id.idTxtList);
        TextView pic = (TextView) convertView.findViewById(R.id.picTxtList);
        TextView name = (TextView) convertView.findViewById(R.id.nameTxtList);
        final TextView size = (TextView) convertView.findViewById(R.id.sizeTxtList);
        TextView price = (TextView) convertView.findViewById(R.id.priceTxtList);
        Button addToCart = (Button) convertView.findViewById(R.id.removeFromCart);
        final TextView quantity = (TextView) convertView.findViewById(R.id.txtQty);
        ImageView productImage = (ImageView) convertView.findViewById(R.id.productImageList);

        String drawableString = men.getPic().replace("@drawable/", "");
        id.setText("ID: " + men.getId());
        pic.setText(men.getPic());
        name.setText("Name: " + men.getName());
        size.setText("Size: " + men.getSize());
        price.setText("Price: Rs. " + men.getPrice());
        quantity.setText("Quantity: "+cart.getProducts().get(men));
        Resources res = mContext.getResources();
        int resID = res.getIdentifier(drawableString, "drawable", mContext.getPackageName());
        final Drawable drawable = res.getDrawable(resID);
        productImage.setImageDrawable(drawable);


        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteHelper sqLiteHelper = new SQLiteHelper(mContext);
                sqLiteHelper.removeFromCart(cart.getUsername(), Integer.toString(men.getId()));
            }
        });

        return convertView;
    }
}
