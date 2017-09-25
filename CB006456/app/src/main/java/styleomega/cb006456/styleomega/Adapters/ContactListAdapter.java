package styleomega.cb006456.styleomega.Adapters;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import styleomega.cb006456.styleomega.Model.Contact;
import styleomega.cb006456.styleomega.R;

/**
 * Created by Nadeem on 8/31/2017.
 */

public class ContactListAdapter extends ArrayAdapter<Contact> {
    Context mContext;
    int layoutResourceId;
    Contact[] mens;
    private String userID;


    public ContactListAdapter(@NonNull Context context, @LayoutRes int resource, Contact[] mens) {
        super(context, resource);
        this.mens = mens;
        this.mContext = context;
        this.layoutResourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
        convertView = inflater.inflate(layoutResourceId, parent, false);


        final Contact men = mens[position];

        TextView id = (TextView) convertView.findViewById(R.id.txtCId);
        TextView name = (TextView) convertView.findViewById(R.id.txtCName);
        TextView email = (TextView) convertView.findViewById(R.id.txtCEmail);
        TextView message = (TextView) convertView.findViewById(R.id.txtCMess);
        TextView reply = (TextView) convertView.findViewById(R.id.txtCReply);



        id.setText("ID : " + men.getId());
        name.setText("Name : " + men.getName());
        email.setText("Email : " + men.getEmail());
        message.setText("Message : " + men.getMessage());
        reply.setText("Reply : " + men.getReply());


        return convertView;
    }

}
