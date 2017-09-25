package styleomega.cb006456.styleomega.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import styleomega.cb006456.styleomega.Model.Product;
import styleomega.cb006456.styleomega.R;
import styleomega.cb006456.styleomega.SQLiteHelper;

/**
 * Created by Nadeem on 8/30/2017.
 */

public class ProductListAdapter extends ArrayAdapter<Product> {
    Context mContext;
    int layoutResourceId;
    Product[] mens;
    private String userID;

    public ProductListAdapter(@NonNull Context context,
                              @LayoutRes int resource, @NonNull Product[] objects, String userId) {
        super(context, resource, objects);

        this.layoutResourceId = resource;
        this.mContext = context;
        this.mens = objects;
        this.userID = userId;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
        convertView = inflater.inflate(layoutResourceId, parent, false);


        final Product men = mens[position];

        TextView id = (TextView) convertView.findViewById(R.id.idTxtList);
        TextView pic = (TextView) convertView.findViewById(R.id.picTxtList);
        TextView name = (TextView) convertView.findViewById(R.id.nameTxtList);
        final TextView size = (TextView) convertView.findViewById(R.id.sizeTxtList);
        TextView price = (TextView) convertView.findViewById(R.id.priceTxtList);
        Button addToCart = (Button) convertView.findViewById(R.id.addToCart);
        final EditText quantity = (EditText) convertView.findViewById(R.id.txtQty);
        ImageView productImage = (ImageView) convertView.findViewById(R.id.productImageList);

        String drawableString = men.getPic().replace("@drawable/", "");
        id.setText("ID: " + men.getId());
        pic.setText(men.getPic());
        name.setText("Name: " + men.getName());
        size.setText("Size: " + men.getSize());
        price.setText("Price: Rs. " + men.getPrice());

        Resources res = mContext.getResources();
        int resID = res.getIdentifier(drawableString, "drawable", mContext.getPackageName());
        final Drawable drawable = res.getDrawable(resID);
        productImage.setImageDrawable(drawable);


        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quantity.getText().length()>0 && quantity.getText().toString().matches("[0-9]+")) {
                    SQLiteHelper sqLiteHelper = new SQLiteHelper(mContext);
                    sqLiteHelper.addToCart(men, userID, Integer.parseInt(quantity.getText().toString()));
                }else{
                    Toast.makeText(mContext,"Please enter a valid quantity",Toast.LENGTH_LONG);
                }
            }
        });

        return convertView;
    }

}
