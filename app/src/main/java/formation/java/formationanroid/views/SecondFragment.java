package formation.java.formationanroid.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import formation.java.formationanroid.R;

public class SecondFragment extends Fragment {


    private String personName;
    public SecondFragment() {

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getArguments permet de récupérer le bundle envoyé vers le fragment
        if (getArguments() != null) {
            //personName = getArguments().getString("personName");

            //Récupération des données à l'aide de safeargs (safeargs genere une classe par fragment avec des paramètres, cette classe contient des getters pour les arguments)
           // SecondFragmentArgs args = SecondFragmentArgs.fromBundle(getArguments());
            //personName = args.getPersonName();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull  View view, @Nullable  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView = view.findViewById(R.id.secondFragmentPersonName);
        textView.setText(personName);
    }
}

