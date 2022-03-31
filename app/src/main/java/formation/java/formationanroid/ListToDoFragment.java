package formation.java.formationanroid;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import formation.java.formationanroid.adapter.TodoListAdapter;
import formation.java.formationanroid.entity.ToDo;
import formation.java.formationanroid.repository.ToDoRepository;
import formation.java.formationanroid.service.ToDoService;
import formation.java.formationanroid.utils.APIClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ListToDoFragment extends Fragment {

    private String title;
    private int priority;
    private ListToDoFragmentArgs args;
    private TextView textViewResult;
    private ToDoRepository _todoRepository;
    private RecyclerView recyclerViewTodos;
    private ToDoService _toDoService;
    private TodoListAdapter adapter;
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
        adapter = new TodoListAdapter(new TodoListAdapter.ToDoDiff());
        recyclerViewTodos.setAdapter(adapter);
        recyclerViewTodos.setLayoutManager(new LinearLayoutManager(getContext()));
        /*textViewResult = view.findViewById(R.id.viewResult);
        textViewResult.setText(title + " " + priority);*/

        /*_todoRepository.getAll().observe(getActivity(), todos -> {
            adapter.submitList(todos);
        })*/

        //Test l'appel à notre api
        getDataFromApi();
    }


    private void getDataFromApi() {
        _toDoService = APIClient.getClient().create(ToDoService.class);

        //<=> observable de rxJava
        _toDoService.getTodosObservable().doOnError((t) -> {}).subscribe(toDos -> {
            adapter.submitList(toDos);
        });

        // <=>
        //Avec Call de retrofit
        /*_toDoService.getTodos().enqueue(new Callback<List<ToDo>>() {
            @Override
            public void onResponse(Call<List<ToDo>> call, Response<List<ToDo>> response) {
                if(response.isSuccessful()) {
                    //Le corps de la réponse est une liste de todos dans notre cas d'utilisation.
                    List<ToDo> toDos = response.body();
                    adapter.submitList(toDos);
                }
            }

            @Override
            public void onFailure(Call<List<ToDo>> call, Throwable t) {
                Log.e("Erreur connexion","error");
            }
        });*/
    }
}