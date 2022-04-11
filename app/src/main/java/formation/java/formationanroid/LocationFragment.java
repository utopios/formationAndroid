package formation.java.formationanroid;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;


public class LocationFragment extends Fragment {

    TextView locationTextView;
    FusedLocationProviderClient fusedLocationProviderClient;
    int REQUEST_CODE = 44;

    ActivityResultLauncher requestPermissions =  registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), (permissions) -> {
        if(/*permissions.get(Manifest.permission.ACCESS_FINE_LOCATION) == true || */permissions.get(Manifest.permission.ACCESS_COARSE_LOCATION) == true) {
            getLocation();
        }
    });
    public LocationFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(getActivity());
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_location, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        requestPermissions.launch(new String[] {Manifest.permission.ACCESS_COARSE_LOCATION});
        locationTextView = (TextView) view.findViewById(R.id.resultLocationTextView);
        super.onViewCreated(view, savedInstanceState);
    }

    //Demande des permissions
    /*private void requestPermissions() {
        getActivity().requestPermissions(new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
    */

    //Vérification des permissions
    private boolean checkPermissions() {
        return ActivityCompat.checkSelfPermission(getActivity(),Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(getActivity(),Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED;
    }

    //Vérification de l'activation des sensors
    private boolean isLocationActivated() {
        LocationManager locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
    }


    //Ignorer la vérification de l'instruction préprocesseur pour vérifier que l'implemention de checkpermission a été faite.
    @SuppressLint("MissingPermission")
    private void getLocation() {
        if(checkPermissions() && isLocationActivated()) {
            fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
                @Override
                public void onComplete(@NonNull Task<Location> task) {
                    Location location = task.getResult();
                    if(location != null) {
                        locationTextView.setText(location.getLatitude()+ " "+location.getLongitude());
                    }
                }
            });
        }
    }


}