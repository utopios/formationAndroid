package formation.java.formationanroid.repository;

import android.app.Application;

import formation.java.formationanroid.dao.PersonDao;
import formation.java.formationanroid.entity.Person;
import formation.java.formationanroid.utils.ContextDataBase;

public class PersonRepository {
    private PersonDao _personDao;
    PersonRepository(Application application) {
        ContextDataBase db = ContextDataBase.getInstance(application);
        _personDao = db.personDao();
    }

    void insert(Person person) {
        ContextDataBase.databaseExecutor.execute(() -> {
            _personDao.insert(person);
        });
    }
}
