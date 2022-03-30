package formation.java.formationanroid;

import android.Manifest;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;


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

        //Exemple de création de fichier interne
//        String data = "Dato to save in file";
//
//        //Le ficher sera sauvegardé dans le dossier Android/data/<nom_complet_application>/files/file1.txt
//        String fileName = "file1.txt";
//        try {
//            FileOutputStream stream = getContext().openFileOutput(fileName, 0);
//            stream.write(data.getBytes());
//            stream.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //Exemple de lecture à partir d'un fichier.
       /* try {
            FileInputStream inputStream = getContext().openFileInput(fileName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb = new StringBuilder();
            String l = null;
            while ((l = reader.readLine())!= null) {
                sb.append(l).append("\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        //Exemple de création de fichier externe.
        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File file1 = new File(folder, "file1.txt");

        //comme ecriture de fichier interne.

    }


}