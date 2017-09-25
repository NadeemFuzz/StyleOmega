package styleomega.cb006456.styleomega.Model;

import android.content.Intent;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Nadeem on 8/30/2017.
 */

public class Cart {
    HashMap<Product, Integer> products;
    String username;
    int total;

    public Cart(HashMap<Product, Integer> products, String username, int total) {
        this.products = products;
        this.username = username;
        this.total = total;
    }

    public HashMap<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(HashMap<Product, Integer> products) {
        this.products = products;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
