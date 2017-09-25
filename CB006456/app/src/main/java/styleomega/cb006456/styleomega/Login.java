package styleomega.cb006456.styleomega;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    Button LogInButton, RegisterButton ;
    EditText Email, Password ;
    String EmailHolder, PasswordHolder;
    Boolean EditTextEmptyHolder;
    SQLiteDatabase sqLiteDatabaseObj;
    SQLiteHelper sqLiteHelper;
    String TempPassword = "NOT_FOUND" ;
    public static String UserEmail = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LogInButton = (Button)findViewById(R.id.buttonLogin);

        RegisterButton = (Button)findViewById(R.id.buttonRegister);

        Email = (EditText)findViewById(R.id.editEmail);
        Password = (EditText)findViewById(R.id.editPassword);

        sqLiteHelper = new SQLiteHelper(this);

        Log.d(Login.class.getSimpleName(), "onCreate: "+"CREATE TABLE IF NOT EXISTS "+SQLiteHelper.TABLE_CONTACT+" ("
                +SQLiteHelper.Table_Column_1_CONTACTID+" INTEGER, "
                +SQLiteHelper.Table_Column_2_CONTACTNAME+" VARCHAR, "
                +SQLiteHelper.Table_Column_3_CONTACTEMAIL+" VARCHAR, "
                +SQLiteHelper.Table_Column_4_CONTACTMESSAGE+" VARCHAR,"
                +SQLiteHelper.Table_Column_5_CONTACTREPLY+" VARCHAR,"
                +"PRIMARY KEY ("+SQLiteHelper.Table_Column_1_CONTACTID+"))");

        //Adding click listener to log in button.
        LogInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Calling EditText is empty or no method.
                CheckEditTextStatus();

                // Calling login method.
                LoginFunction();


            }
        });

        // Adding click listener to register button.
        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Opening new user registration activity using intent on button click.
                Intent intent = new Intent(Login.this, RegisterActivity.class);
                startActivity(intent);

            }
        });

    }

    // Login function starts from here.
    public void LoginFunction(){

        if(EditTextEmptyHolder) {

            // Opening SQLite database write permission.
            sqLiteDatabaseObj = sqLiteHelper.getWritableDatabase();

            TempPassword = sqLiteHelper.getDataForUser(EmailHolder);
            UserEmail = EmailHolder;
            // Calling method to check final result ..
            CheckFinalResult();

        }
        else {

            //If any of login EditText empty then this block will be executed.
            Toast.makeText(Login.this,"Please Enter Username or Password.", Toast.LENGTH_LONG).show();

        }

    }

    // Checking EditText is empty or not.
    public void CheckEditTextStatus(){

        // Getting value from All EditText and storing into String Variables.
        EmailHolder = Email.getText().toString();
        PasswordHolder = Password.getText().toString();

        // Checking EditText is empty or no using TextUtils.
        if( TextUtils.isEmpty(EmailHolder) || TextUtils.isEmpty(PasswordHolder)){

            EditTextEmptyHolder = false ;

        }
        else {

            EditTextEmptyHolder = true ;
        }
    }

    // Checking entered password from SQLite database email associated password.
    public void CheckFinalResult(){

        if(TempPassword.equalsIgnoreCase(PasswordHolder))
        {
            Toast.makeText(Login.this,"Login Successfully", Toast.LENGTH_LONG).show();

            // Going to Dashboard activity after login success message.
            Intent intent = new Intent(Login.this, DashboardActivity.class);

            // Sending Email to Dashboard Activity using intent.
            intent.putExtra(UserEmail, UserEmail);
            startActivity(intent);
            finish();
        }
        else {
            Toast.makeText(Login.this,"Username or Password is Wrong, Please Try Again.",
                                                                    Toast.LENGTH_LONG).show();
        }
        TempPassword = "NOT_FOUND" ;
    }
}
