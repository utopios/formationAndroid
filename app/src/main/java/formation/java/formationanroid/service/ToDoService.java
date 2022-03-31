package formation.java.formationanroid.service;


import java.util.List;

import formation.java.formationanroid.entity.ToDo;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ToDoService {

    @GET("todos")
    Call<List<ToDo>> getTodos();
}
