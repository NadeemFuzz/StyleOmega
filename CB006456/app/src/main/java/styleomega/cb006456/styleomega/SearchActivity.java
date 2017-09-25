package styleomega.cb006456.styleomega;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import styleomega.cb006456.styleomega.Adapters.ProductListAdapter;
import styleomega.cb006456.styleomega.Model.Product;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }

    public void searchBtnCLicked(View view) {
        SQLiteHelper sqLiteHelper = new SQLiteHelper(this);
        ListView list = (ListView) findViewById(R.id.searchResultList);
        ArrayList<Product> prods = sqLiteHelper.getAllProductDataForName
                (((EditText) findViewById(R.id.searchEdiText)).getText().toString());
        Product[] prodArray = new Product[prods.size()];
        for(int i = 0 ; i<prodArray.length;i++)
            prodArray[i] = prods.get(i);
        ProductListAdapter ListAdpater =  new ProductListAdapter(this, R.layout.product_list_item,prodArray,
                getIntent().getStringExtra("emailholder"));
        list.setAdapter(ListAdpater);
    }
}



