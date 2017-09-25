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

public class Store_Fragment extends Fragment {

    View myView;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater,
                             @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.store,container,false);

        ((Button) myView.findViewById(R.id.btnSearch)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), SearchActivity.class));
            }
        });

        Button men;
        men = (Button) myView.findViewById(R.id.MensCloth);
        men.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), ProductClothing.class);
                intent.putExtra("emailholder", getArguments().getString("emailholder"));
                intent.putExtra("type", "men");
                startActivity(intent);
            }
        });

        Button women;
        women = (Button) myView.findViewById(R.id.WomensCloth);
        women.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), ProductClothing.class);
                intent.putExtra("emailholder", getArguments().getString("emailholder"));
                intent.putExtra("type", "women");
                startActivity(intent);

            }
        });

        Button kids;
        kids = (Button) myView.findViewById(R.id.Kids);
        kids.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), ProductClothing.class);
                intent.putExtra("emailholder", getArguments().getString("emailholder"));
                intent.putExtra("type", "kid");
                startActivity(intent);
            }
        });

        Button acc;
        acc = (Button) myView.findViewById(R.id.Acc);
        acc.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), ProductClothing.class);
                intent.putExtra("emailholder", getArguments().getString("emailholder"));
                intent.putExtra("type", "acc");
                startActivity(intent);
            }
        });
        return myView;
    }
}

