package formation.java.formationanroid.service;


import java.util.List;

import formation.java.formationanroid.entity.ToDo;
import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ToDoService {

    @GET("todos")
    Call<List<ToDo>> getTodos();

    @GET("todos")
    Observable<List<ToDo>> getTodosObservable();

    @GET("todos/{id}")
    Call<ToDo> getTodo(@Path("id") int id);

    @GET("distancematrix/json")
    Call<Object> getDistance(@Query("destinations") String destinations, @Query("origins") String origins);

    @Headers("content-type: enctype/multipart-formdata")
    @POST("todos")
    void create(@Body ToDo toDo);

    @PUT("todos/{id}")
    void update(@Body ToDo todo, @Path("id") int id);

    @DELETE("todos/{id}")
    void delete(@Path("id") int id);
}
