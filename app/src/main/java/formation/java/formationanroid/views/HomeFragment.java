package formation.java.formationanroid.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


import formation.java.formationanroid.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button button;
    private EditText editTextName;
    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
    /*
    @Override
    public void onActivityCreated(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button button = getView().findViewById(R.id.button);
    }*/

    //Surcharge de la méthode fin de création de view
    @Override
    public void onViewCreated(@NonNull View view, @Nullable  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Récupération de notre bouton par son id
        button = view.findViewById(R.id.button);
        editTextName = view.findViewById(R.id.editTextTextPersonName);
        //La création d'un objet bundle pour ajouter les paramètres de la déstination (les paramètres de la déstination sont les données à envoyer vers la destination)
        Bundle argsBundle = new Bundle();

        //Ajouter une fonction callback sur l'event click
        button.setOnClickListener((v) -> {
            //Pour naviguer vers une nouvelle frame, on utilise la classe Navigation
            //La méthode static findNavController, récupère le navHost de la view
            //La méthode navigate, qui permet de naviguer vers une action (Id de l'action du fragment)

            //L'envoie de données vers la destination avec le bundle
            //La récupération de la valeur du edittext et son ajout dans notre bundle
            //argsBundle.putString("personeName", editTextName.getText().toString());
            //Navigation.findNavController(v).navigate(R.id.homeToSecond, argsBundle);


            //L'envoie des données avec le plugin safeargs
            //Le plugin safeargs genere une classe HomeFragmentDirections, une classe par action, et une méthode statique par action pour créer les actions
           // HomeFragmentDirections.HomeToSecond action = HomeFragmentDirections.homeToSecond(editTextName.getText().toString());
            //Navigation.findNavController(v).navigate(action);
        });
        //On peut également utiliser les méthodes de création d'interfaces fonctionnelles de la classe Navigation
        //button.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.homeToSecond));
    }
}