package formation.java.formationanroid;

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

public class FormToDoFragment extends Fragment {

    private EditText editTextTitleTask;
    private EditText editTextPriorityTask;

    private Button confirmButton;
    private FormToDoFragmentDirections.FormTodoToListTodo action;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_form_to_do, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editTextTitleTask = view.findViewById(R.id.taskTitle);
        editTextPriorityTask = view.findViewById(R.id.taskPriority);
        confirmButton = view.findViewById(R.id.confirmButton);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action = FormToDoFragmentDirections.formTodoToListTodo(editTextTitleTask.getText().toString(), Integer.valueOf(editTextPriorityTask.getText().toString()));
                Navigation.findNavController(v).navigate(action);
            }
        });
    }
}