package formation.java.formationanroid;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import formation.java.formationanroid.adapter.TodoListAdapter;
import formation.java.formationanroid.entity.ToDo;
import formation.java.formationanroid.repository.ToDoRepository;


public class ListToDoFragment extends Fragment {

    private String title;
    private int priority;
    private ListToDoFragmentArgs args;
    private TextView textViewResult;
    private ToDoRepository _todoRepository;
    private RecyclerView recyclerViewTodos;
    public ListToDoFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //La création du todorepository
        _todoRepository = new ToDoRepository(getActivity().getApplication());
        if (getArguments() != null) {
         /* args = ListToDoFragmentArgs.fromBundle(getArguments());
          title = args.getTitle();
          priority = args.getPriority();

          //La création du todo
          ToDo toDo = new ToDo(title, priority);

          //L'ajout du todo dans notre base de données
          _todoRepository.insert(toDo);*/
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_to_do, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerViewTodos = view.findViewById(R.id.recyclerTodos);
        final TodoListAdapter adapter = new TodoListAdapter(new TodoListAdapter.ToDoDiff());
        recyclerViewTodos.setAdapter(adapter);
        recyclerViewTodos.setLayoutManager(new LinearLayoutManager(getContext()));
        /*textViewResult = view.findViewById(R.id.viewResult);
        textViewResult.setText(title + " " + priority);*/

        _todoRepository.getAll().observe(getActivity(), todos -> {
            adapter.submitList(todos);
        });
    }
}