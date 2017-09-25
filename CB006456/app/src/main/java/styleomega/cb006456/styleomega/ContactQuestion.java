package styleomega.cb006456.styleomega;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import styleomega.cb006456.styleomega.Adapters.ContactAdapter;
import styleomega.cb006456.styleomega.Adapters.ContactListAdapter;
import styleomega.cb006456.styleomega.Adapters.ProductListAdapter;
import styleomega.cb006456.styleomega.Model.Contact;
import styleomega.cb006456.styleomega.Model.Product;

public class ContactQuestion extends AppCompatActivity {

    EditText Name, Email, Message;
    Button Submit;
    SQLiteHelper sqLiteHelper;
    ListView list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_question);

        sqLiteHelper = new SQLiteHelper(this);

        list = (ListView) findViewById(R.id.lstMessage);
        ArrayList<Contact> mens = sqLiteHelper.getAllContactData();
        Contact[] menArray = new Contact[mens.size()];
        for(int i = 0 ; i<menArray.length;i++)
            menArray[i] = mens.get(i);

        String[] messages =  new String[menArray.length];
        for(int i = 0 ; i<menArray.length;i++)
            messages[i] = menArray[i].getMessage();
        Log.d(ContactQuestion.class.getSimpleName(), "onCreate: "+mens.size()+"--------->"+menArray.length);
        ContactListAdapter contactListAdapter = new ContactListAdapter(this, R.layout.contact_list,menArray);
        //list.setAdapter(new ArrayAdapter<String>(
                //this, android.R.layout.simple_list_item_1, messages));
        list.setAdapter(new ContactAdapter(this,menArray));
        Submit = (Button) findViewById(R.id.btnSubmit);

        Name = (EditText) findViewById(R.id.txtName);
        Email = (EditText) findViewById(R.id.txtEmail);
        Message = (EditText) findViewById(R.id.txtMessage);


        AddData();
    }


    public void AddData() {
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isInserted = sqLiteHelper.insertData(Name.getText().toString(),
                        Email.getText().toString(),
                        Message.getText().toString());
                if (isInserted){
                    Toast.makeText(ContactQuestion.this, "Your Message was Sent !", Toast.LENGTH_LONG).show();
                    EmptyEditTextAfterDataInsert();

            }else
                    Toast.makeText(ContactQuestion.this, "Message not Sent", Toast.LENGTH_LONG).show();
            }


        });


    }


    // Empty edittext after done inserting process method.
    public void EmptyEditTextAfterDataInsert(){

        Name.getText().clear();

        Email.getText().clear();

        Message.getText().clear();

    }
}
