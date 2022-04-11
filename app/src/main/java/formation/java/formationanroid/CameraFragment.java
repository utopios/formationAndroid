package formation.java.formationanroid;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


public class CameraFragment extends Fragment {


    Button takePictureButton;
    ImageView resultImageView;
    int CODE_RESULT = 33;

    ActivityResultLauncher launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), (result) -> {
        if(result.getResultCode() == Activity.RESULT_OK) {
            Bitmap image = (Bitmap) result.getData().getExtras().get("data");
            resultImageView.setImageBitmap(image);
        }
    } );

    public CameraFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_camera, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        takePictureButton = (Button) view.findViewById(R.id.takePictureButton);
        resultImageView = (ImageView) view.findViewById(R.id.resultImageView);
        takePictureButton.setOnClickListener((v) -> {
            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            //startActivityForResult(cameraIntent, CODE_RESULT);
            launcher.launch(cameraIntent);
        });
    }

//    @Override
//    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
//        if(requestCode == CODE_RESULT) {
//            Bitmap image = (Bitmap) intent.getExtras().get("data");
//            resultImageView.setImageBitmap(image);
//        }
//    }
}