package styleomega.cb006456.styleomega;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

import styleomega.cb006456.styleomega.Adapters.ProductListAdapter;
import styleomega.cb006456.styleomega.Model.Product;

public class ProductClothing extends AppCompatActivity {

    SQLiteHelper sqLiteHelper;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        sqLiteHelper = new SQLiteHelper(this);

        list = (ListView) findViewById(R.id.clothing_list);
        ArrayList<Product> prods = sqLiteHelper.getAllProductData(getIntent().getStringExtra("type"));
        Product[] prodArray = new Product[prods.size()];
        for(int i = 0 ; i<prodArray.length;i++)
            prodArray[i] = prods.get(i);
        ProductListAdapter ListAdpater =  new ProductListAdapter(this, R.layout.product_list_item,prodArray,
                                                                            getIntent().getStringExtra("emailholder"));
        list.setAdapter(ListAdpater);

    }
}
