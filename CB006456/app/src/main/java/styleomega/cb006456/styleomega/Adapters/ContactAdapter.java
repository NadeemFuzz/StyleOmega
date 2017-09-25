package styleomega.cb006456.styleomega.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import styleomega.cb006456.styleomega.Model.Contact;
import styleomega.cb006456.styleomega.R;

/**
 * Created by Nadeem on 9/4/2017.
 */

public class ContactAdapter extends BaseAdapter {
    Context mContext;
    Contact[] contacts;

    public ContactAdapter(Context context, Contact[] cons){
        mContext = context;
        contacts = cons;
    }

    @Override
    public int getCount() {
        return contacts.length;
    }

    @Override
    public Object getItem(int i) {
        return contacts[i];
    }

    @Override
    public long getItemId(int i) {
        return contacts[i].getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            view = inflater.inflate(R.layout.contact_list, viewGroup, false);


            final Contact men = contacts[i];

            TextView id = (TextView) view.findViewById(R.id.txtCId);
            TextView name = (TextView) view.findViewById(R.id.txtCName);
            TextView email = (TextView) view.findViewById(R.id.txtCEmail);
            TextView message = (TextView) view.findViewById(R.id.txtCMess);
            TextView reply = (TextView) view.findViewById(R.id.txtCReply);



            id.setText("ID : " + men.getId());
            name.setText("Name : " + men.getName());
            email.setText("Email : " + men.getEmail());
            message.setText("Message : " + men.getMessage());
            reply.setText("Reply : " + men.getReply());
        }
        return view;
    }
}
