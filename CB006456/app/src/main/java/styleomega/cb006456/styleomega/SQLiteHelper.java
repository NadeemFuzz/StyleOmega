package styleomega.cb006456.styleomega;


import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

import styleomega.cb006456.styleomega.Model.*;

public class SQLiteHelper extends SQLiteOpenHelper {

    static String DATABASE_NAME="UserDataBase";

    static SQLiteDatabase SQLITEDB;


    //Tables in UserDataBase

    public static final String TABLE_NAME="UserTable";

    public static final String TABLE_CLOTHEPRODUCTS="ClotheProducts";

    public static final String TABLE_CART="Cart";

    public static final String TABLE_CONTACT="Contact";


    //Properties of UserTable

    public static final String Table_Column_ID="id";

    public static final String Table_Column_1_Name="name";

    public static final String Table_Column_2_Email="email";

    public static final String Table_Column_3_Password="password";




    public static final String Table_Column_1_CLOTHEID="id";

    public static final String Table_Column_2_CLOTHETYPE="type";

    public static final String Table_Column_3_CLOTHEPIC="pic";

    public static final String Table_Column_4_CLOTHENAME="name";

    public static final String Table_Column_5_CLOTHESIZE="size";

    public static final String Table_Column_6_CLOTHEPRICE="price";


    //Properties of Cart Table

    public static final String Table_Column_1_CARTUSERNAME="user_name";

    public static final String Table_Column_2_CARTPRODUCTID="product_id";

    public static final String Table_Column_3_CARTQUANTITY="quantity";

    public static final String Table_Column_4_CARTTOTAL="total";


    //Properties of Contact

    public static final String Table_Column_1_CONTACTID="id";

    public static final String Table_Column_2_CONTACTNAME="name";

    public static final String Table_Column_3_CONTACTEMAIL="email";

    public static final String Table_Column_4_CONTACTMESSAGE="message";

    public static final String Table_Column_5_CONTACTREPLY="reply";

    private static String TAG = SQLiteHelper.class.getSimpleName();


    public SQLiteHelper(Context context) {

        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase database) {

        String CREATE_TABLE="CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ("+Table_Column_ID+" INTEGER PRIMARY KEY, "+Table_Column_1_Name+" VARCHAR, "+Table_Column_2_Email+" VARCHAR, "+Table_Column_3_Password+" VARCHAR)";
        database.execSQL(CREATE_TABLE);

        CREATE_TABLE="CREATE TABLE IF NOT EXISTS "+TABLE_CART+" ("
                                                +Table_Column_1_CARTUSERNAME+" VARCHAR, "
                                                +Table_Column_2_CARTPRODUCTID+" INTEGER, "
                                                +Table_Column_3_CARTQUANTITY+" INTEGER, "
                                                +Table_Column_4_CARTTOTAL+" INTEGER,"
                                                +"PRIMARY KEY ("+Table_Column_1_CARTUSERNAME+", "+Table_Column_2_CARTPRODUCTID+"),"
                                                +" FOREIGN KEY ("+Table_Column_1_CARTUSERNAME+") REFERENCES "+TABLE_NAME+"("+Table_Column_2_Email+"),"
                                                +" FOREIGN KEY ("+Table_Column_2_CARTPRODUCTID+") REFERENCES "+TABLE_CLOTHEPRODUCTS+"("+Table_Column_1_CLOTHEID+"))";
        database.execSQL(CREATE_TABLE);

        CREATE_TABLE="CREATE TABLE IF NOT EXISTS "+TABLE_CLOTHEPRODUCTS+" ("
                +Table_Column_1_CLOTHEID+" INTEGER, "
                +Table_Column_2_CLOTHETYPE+" VARCHAR, "
                +Table_Column_3_CLOTHEPIC+" VARCHAR, "
                +Table_Column_4_CLOTHENAME+" VARCHAR,"
                +Table_Column_5_CLOTHESIZE+" VARCHAR,"
                +Table_Column_6_CLOTHEPRICE+" INTEGER,"
                +"PRIMARY KEY ("+Table_Column_1_CLOTHEID+"))";
        database.execSQL(CREATE_TABLE);

        CREATE_TABLE="CREATE TABLE IF NOT EXISTS "+TABLE_CONTACT+" ("
                +Table_Column_1_CONTACTID+" INTEGER AUTOINCREMENT, "
                +Table_Column_2_CONTACTNAME+" VARCHAR, "
                +Table_Column_3_CONTACTEMAIL+" VARCHAR, "
                +Table_Column_4_CONTACTMESSAGE+" VARCHAR,"
                +Table_Column_5_CONTACTREPLY+" VARCHAR,"
                +"PRIMARY KEY ("+Table_Column_1_CONTACTID+"))";
        database.execSQL(CREATE_TABLE);

        SQLITEDB = database;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }

    public ArrayList<Product> getAllProductData(String type) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("select * from "+TABLE_CLOTHEPRODUCTS+" WHERE "+Table_Column_2_CLOTHETYPE+"='"+type+"'",null);
        ArrayList<Product> mens = new ArrayList<>();
        while(result.moveToNext()){

            Product men = new Product(result.getInt(result.getColumnIndex(SQLiteHelper.Table_Column_1_CLOTHEID))
                    , result.getString(result.getColumnIndex(SQLiteHelper.Table_Column_3_CLOTHEPIC))
                    , result.getString(result.getColumnIndex(SQLiteHelper.Table_Column_4_CLOTHENAME))
                    , result.getString(result.getColumnIndex(SQLiteHelper.Table_Column_5_CLOTHESIZE))
                    , result.getInt(result.getColumnIndex(SQLiteHelper.Table_Column_6_CLOTHEPRICE))
                    , result.getString(result.getColumnIndex(SQLiteHelper.Table_Column_2_CLOTHETYPE)));
            mens.add(men);
        }
        return mens;
    }

    public ArrayList<Product> getAllProductDataForName(String type) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("select * from "+TABLE_CLOTHEPRODUCTS+" WHERE "+Table_Column_4_CLOTHENAME+"='"+type+"'",null);
        ArrayList<Product> mens = new ArrayList<>();
        while(result.moveToNext()){

            Product men = new Product(result.getInt(result.getColumnIndex(SQLiteHelper.Table_Column_1_CLOTHEID))
                    , result.getString(result.getColumnIndex(SQLiteHelper.Table_Column_3_CLOTHEPIC))
                    , result.getString(result.getColumnIndex(SQLiteHelper.Table_Column_4_CLOTHENAME))
                    , result.getString(result.getColumnIndex(SQLiteHelper.Table_Column_5_CLOTHESIZE))
                    , result.getInt(result.getColumnIndex(SQLiteHelper.Table_Column_6_CLOTHEPRICE))
                    , result.getString(result.getColumnIndex(SQLiteHelper.Table_Column_2_CLOTHETYPE)));
            mens.add(men);
        }
        return mens;
    }

    public ArrayList<Contact> getAllContactData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("select * from "+TABLE_CONTACT,null);
        ArrayList<Contact> mens = new ArrayList<>();
        while(result.moveToNext()){

            Contact men = new Contact(result.getInt(result.getColumnIndex(SQLiteHelper.Table_Column_1_CONTACTID))
                    , result.getString(result.getColumnIndex(SQLiteHelper.Table_Column_2_CONTACTNAME))
                    , result.getString(result.getColumnIndex(SQLiteHelper.Table_Column_3_CONTACTEMAIL))
                    , result.getString(result.getColumnIndex(SQLiteHelper.Table_Column_4_CONTACTMESSAGE))
                    , result.getString(result.getColumnIndex(SQLiteHelper.Table_Column_5_CONTACTREPLY)));
            mens.add(men);
        }
        return mens;
    }

    public boolean updateData(String emailholdervalue,String email,String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Table_Column_2_Email, email);
        contentValues.put(Table_Column_3_Password,password);
        db.update(TABLE_NAME, contentValues, "email = ?",new String[] { emailholdervalue });
        return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }


    //Login
    public String getDataForUser(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        while(res.moveToNext()){
            String usernameRes = res.getString(res.getColumnIndex(SQLiteHelper.Table_Column_2_Email));
            String passwordRes = res.getString(res.getColumnIndex(SQLiteHelper.Table_Column_3_Password));
            if(username.equals(usernameRes)){
                return passwordRes;
            }
        }
        return "Not Found";
    }

    public Integer deleteData (String emailholdervalue,String email,String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Table_Column_2_Email, email);
        contentValues.put(Table_Column_3_Password,password);
        return db.delete(TABLE_NAME, "email = ?",new String[] {emailholdervalue});
    }

    public Integer removeFromCart (String emailholdervalue, String productid) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_CART, Table_Column_1_CARTUSERNAME+" = ? and "+Table_Column_2_CARTPRODUCTID+" = ?",new String[] {emailholdervalue, productid});
    }

    public Integer removeAllFromCart (String emailholdervalue) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_CART, Table_Column_1_CARTUSERNAME+" = ?",new String[] {emailholdervalue});
    }

    public boolean insertData(String name,String email,String message) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Table_Column_2_CONTACTNAME,name);
        contentValues.put(Table_Column_3_CONTACTEMAIL,email);
        contentValues.put(Table_Column_4_CONTACTMESSAGE,message);
        long result = db.insert(TABLE_CONTACT,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public boolean insertUser(String name,String password,String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Table_Column_1_Name,name);
        contentValues.put(Table_Column_2_Email,email);
        contentValues.put(Table_Column_3_Password,password);
        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public boolean addToCart(Product menItem, String userID, int quantity){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv =  new ContentValues();
        cv.put(Table_Column_1_CARTUSERNAME, userID);
        cv.put(Table_Column_2_CARTPRODUCTID, menItem.getId());
        cv.put(Table_Column_3_CARTQUANTITY, quantity);
        cv.put(Table_Column_4_CARTTOTAL, quantity*menItem.getPrice());

        long result = db.insert(TABLE_CART, null, cv);

        if(result == -1)
            return false;
        else
            return true;
    }

    public Cart getCartData(String userID){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_CART + " WHERE "+Table_Column_1_CARTUSERNAME +"='"+userID+"'",null);
        Log.d(TAG, "getCartData: "+"SELECT * FROM "+TABLE_CART + " WHERE "+Table_Column_1_CARTUSERNAME +"='"+userID+"'");
        Log.d(TAG, "getCartData: "+res.getCount());
        Cart cart;
        int total = 0;
        HashMap<Product, Integer> cartList = new HashMap<>();
        while(res.moveToNext()){
            Cursor result = db.rawQuery("SELECT * FROM "+TABLE_CLOTHEPRODUCTS + " WHERE "+Table_Column_1_CLOTHEID
                    +"="+res.getInt(res.getColumnIndex(SQLiteHelper.Table_Column_2_CARTPRODUCTID)),null);
            while(result.moveToNext()) {
                Product men = new Product(result.getInt(result.getColumnIndex(SQLiteHelper.Table_Column_1_CLOTHEID))
                        , result.getString(result.getColumnIndex(SQLiteHelper.Table_Column_3_CLOTHEPIC))
                        , result.getString(result.getColumnIndex(SQLiteHelper.Table_Column_4_CLOTHENAME))
                        , result.getString(result.getColumnIndex(SQLiteHelper.Table_Column_5_CLOTHESIZE))
                        , result.getInt(result.getColumnIndex(SQLiteHelper.Table_Column_6_CLOTHEPRICE))
                        , result.getString(result.getColumnIndex(SQLiteHelper.Table_Column_2_CLOTHETYPE)));

                cartList.put(men, res.getInt(res.getColumnIndex(Table_Column_3_CARTQUANTITY)));

                total+=res.getInt(res.getColumnIndex(Table_Column_3_CARTQUANTITY))*result.getInt(result.
                        getColumnIndex(SQLiteHelper.Table_Column_6_CLOTHEPRICE));
            }
        }
        cart = new Cart(cartList,userID,total);
        return cart;
    }
}