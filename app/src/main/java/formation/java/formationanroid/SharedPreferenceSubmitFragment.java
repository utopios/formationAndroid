package formation.java.formationanroid;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class SharedPreferenceSubmitFragment extends Fragment {



    public SharedPreferenceSubmitFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shared_preference_submit, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //La création d'un objet de type sharedPreferences pour stocker des données privées (primitives) sous forme clé/valeur.
        SharedPreferences preferences = getActivity().getApplicationContext().getSharedPreferences("preferences", 0);
        //La création d'un éditeur pour valider les données
        SharedPreferences.Editor editor = preferences.edit();
        //Ajout des données
        editor.putString("key1", "value of key1");
        editor.putInt("key2", 2022);
        //Validation des données dans le shared Préferences
        editor.commit();
        editor.apply();

        //Redirection vers la deuxième vue
        view.findViewById(R.id.buttonSavePr).setOnClickListener((v) -> {
            Navigation.findNavController(v).navigate(R.id.action_sharedPreferenceSubmitFragment_to_sharedPreferenceReadFragment);
        });
    }
}