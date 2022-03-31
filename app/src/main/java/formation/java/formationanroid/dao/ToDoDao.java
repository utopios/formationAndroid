package formation.java.formationanroid.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import formation.java.formationanroid.entity.ToDo;
import io.reactivex.rxjava3.core.Completable;

@Dao
public interface ToDoDao {

    @Insert
    void insert(ToDo toDo);

    @Insert
    Completable insertRx(ToDo toDo);

    @Query("SELECT * from todo")
    LiveData<List<ToDo>> getAll();
}
