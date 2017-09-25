package styleomega.cb006456.styleomega;

import android.app.Fragment;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Nadeem on 7/19/2017.
 */

public class ManageAcc_Fragment extends Fragment {


    SQLiteDatabase sqLiteDatabaseObj;
    String SQLiteDataBaseQueryHolder ;
    SQLiteHelper sqLiteHelper;

    RegisterActivity registerActivity;

    View myView;
    private String EmailHolder;
    String Email,Password;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.manageacc, container, false);
        Bundle bundle = getArguments();
        sqLiteHelper = new SQLiteHelper(getActivity());

        //Display logged in user Email :
        EmailHolder = bundle.getString("email");
        TextView txtName = (TextView) myView.findViewById(R.id.txtName);
        final String name = txtName.getText().toString() + " " + EmailHolder;
        txtName.setText(name);

        //Update Button
        final Button update = (Button) myView.findViewById(R.id.btnUpdate);

        //Delete Button
        final Button delete = (Button) myView.findViewById(R.id.btnDelete);


        update.setOnClickListener(new View.OnClickListener()
        {
            EditText email=(EditText) myView.findViewById(R.id.txtEmail);
            EditText password=(EditText) myView.findViewById(R.id.txtPass);



            @Override
            public void onClick(View myView) {

                Email = email.getText().toString();
                Password = password.getText().toString();

                if (TextUtils.isEmpty((Email))) {
                    Toast.makeText(getActivity(), "Please Enter Email ", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty((Password))) {
                    Toast.makeText(getActivity(), "Please Enter Password ", Toast.LENGTH_SHORT).show();

                } else if (Email.equals(EmailHolder)) {
                    Toast.makeText(getActivity(), "Enter New Email !", Toast.LENGTH_SHORT).show();

                } else if (!(TextUtils.isEmpty((Email)) && !(TextUtils.isEmpty((Password)) && !(Email.equals(EmailHolder))))) {

                    UpdateDb();

                    //Finishing current DashBoard activity on button click.
                    getActivity().finishAffinity();

                    //IF updated the database
                    Toast.makeText(getActivity(), "Email : " + Email + " & Password : " + Password +
                            " Updated", Toast.LENGTH_SHORT).show();
                }
            }

        });


        delete.setOnClickListener(new View.OnClickListener()
        {
            EditText email=(EditText) myView.findViewById(R.id.txtEmail);
            EditText password=(EditText) myView.findViewById(R.id.txtPass);

            @Override
            public void onClick(View myView) {

                Email = email.getText().toString();
                Password = password.getText().toString();

                if (TextUtils.isEmpty((Email))) {
                    Toast.makeText(getActivity(), "Please Enter Email ", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty((Password))) {
                    Toast.makeText(getActivity(), "Please Enter Password ", Toast.LENGTH_SHORT).show();

                } else if (!(Email.equals(EmailHolder))) {
                    Toast.makeText(getActivity(), "Enter Existing Email !", Toast.LENGTH_SHORT).show();

                } else if (!(TextUtils.isEmpty((Email)) && !(TextUtils.isEmpty((Password)) && (Email.equals(EmailHolder))))) {
                    DeleteDb();
                    //Finishing current DashBoard activity on button click.
                    getActivity().finishAffinity();

                    //startActivity(new Intent(this, Login.class));
                    startActivity(new Intent(getActivity(), Login.class));
                    //IF updated the database
                    Toast.makeText(getActivity(), "Account Successfully Deleted", Toast.LENGTH_SHORT).show();
                }
            }
            });

        return myView;
    }



    public void UpdateDb()
    {
        sqLiteHelper.updateData(EmailHolder,Email,Password);
    }

    public void DeleteDb()
    {
        sqLiteHelper.deleteData(EmailHolder,Email,Password);
    }

}
