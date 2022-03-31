package formation.java.formationanroid.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import formation.java.formationanroid.dao.ToDoDao;
import formation.java.formationanroid.entity.ToDo;
import formation.java.formationanroid.utils.ContextDataBase;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ToDoRepository {

    private ToDoDao _todoDao;
    public ToDoRepository(Application application) {
        ContextDataBase db = ContextDataBase.getInstance(application);
        _todoDao = db.toDoDao();
    }

    public void insert(ToDo todo) {
        ContextDataBase.databaseExecutor.execute(() -> {
            _todoDao.insert(todo);
        });
    }

    public Completable insertRx(ToDo toDo) {

        return Completable.fromAction(() -> { _todoDao.insert(toDo);}).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    public LiveData<List<ToDo>> getAll() {
        return _todoDao.getAll();
    }
}
