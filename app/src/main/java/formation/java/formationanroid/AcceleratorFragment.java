package formation.java.formationanroid;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class AcceleratorFragment extends Fragment {

    private SensorManager sensorManager = null;
    private TextView textViewSensor;
    List acceleratorSensors;
    public AcceleratorFragment() {
        // Required empty public constructor
    }


    SensorEventListener sensorEventListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            float[] values = event.values;
            textViewSensor.setText("x: "+ values[0] + ", y: "+ values[1] + ", z: "+ values[2]);
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Récupération d'un sensor manager, pour récupérer les sensors
        sensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        //Récupération du sensor
        acceleratorSensors =  sensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_accelerator, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        textViewSensor = (TextView) view.findViewById(R.id.resultAcceleratorTextView);
        sensorManager.registerListener(sensorEventListener, (Sensor) acceleratorSensors.get(0), SensorManager.SENSOR_DELAY_NORMAL);
        super.onViewCreated(view, savedInstanceState);
    }
}