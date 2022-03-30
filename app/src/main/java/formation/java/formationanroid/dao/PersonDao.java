package formation.java.formationanroid.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import formation.java.formationanroid.entity.Person;

@Dao
public interface PersonDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Person person);

    @Query("SELECT * FROM person where id =:id")
    Person findById(int id);


    @Query("DELETE FROM person")
    void deleteAll();
}
