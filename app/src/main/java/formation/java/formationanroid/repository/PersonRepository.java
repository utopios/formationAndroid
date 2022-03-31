package formation.java.formationanroid.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import formation.java.formationanroid.dao.PersonDao;
import formation.java.formationanroid.entity.Person;
import formation.java.formationanroid.entity.PersonWithAddress;
import formation.java.formationanroid.utils.ContextDataBase;

public class PersonRepository {
    private PersonDao _personDao;
    public PersonRepository(Application application) {
        ContextDataBase db = ContextDataBase.getInstance(application);
        _personDao = db.personDao();
    }

    public void insert(Person person) {
        ContextDataBase.databaseExecutor.execute(() -> {
            _personDao.insert(person);
        });
    }

    LiveData<List<PersonWithAddress>> getAll() {
        return _personDao.getAll();
    }
}
