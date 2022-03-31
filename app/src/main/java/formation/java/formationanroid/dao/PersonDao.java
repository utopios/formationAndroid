package formation.java.formationanroid.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

import formation.java.formationanroid.entity.Person;
import formation.java.formationanroid.entity.PersonWithAddress;

@Dao
public interface PersonDao {

    //Méthode pour une simple insertion
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Person person);

    //Méthode pour une insertion multiple
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAll(Person... persons);

    //Update
    @Update()
    void update(Person person);

    //delete
    @Delete()
    void delete(Person person);

    @Query("SELECT * FROM person where id =:id")
    LiveData<Person> findById(int id);


    @Query("DELETE FROM person")
    void deleteAll();

    @Transaction
    @Query("SELECT * FROM person")
    LiveData<List<PersonWithAddress>> getAll();
}
