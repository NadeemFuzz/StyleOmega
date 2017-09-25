package styleomega.cb006456.styleomega;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Nadeem on 7/19/2017.
 */

public class Contact_Fragment extends Fragment {


    View myView;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.contactstore,container,false);

        Button Question;
        Question = (Button) myView.findViewById(R.id.btnContact);
        Question.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), ContactQuestion.class);
                startActivity(intent);
            }
        });


        return myView;
    }


}
