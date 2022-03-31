package formation.java.formationanroid.utils;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.AutoMigration;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import formation.java.formationanroid.dao.PersonDao;
import formation.java.formationanroid.dao.ToDoDao;
import formation.java.formationanroid.entity.Address;
import formation.java.formationanroid.entity.Person;
import formation.java.formationanroid.entity.ToDo;

@Database(entities = {Person.class, ToDo.class, Address.class}, version = 2)
public abstract class ContextDataBase extends RoomDatabase {

    public abstract PersonDao personDao();
    public abstract ToDoDao toDoDao();
    private static ContextDataBase instance = null;

    //On crée un pool de 3 threads pour executer nos actions dans des threads autre le principal
    public static ExecutorService databaseExecutor = Executors.newFixedThreadPool(3);

    public static ContextDataBase getInstance(Context context) {
        if(instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), ContextDataBase.class, "formation_database")
                    .addCallback(new Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);
                            //Les instructions à executer à la création de la base de données
                            databaseExecutor.execute(() -> {
                                //Actions au démarrage
                                PersonDao dao = instance.personDao();
                                dao.deleteAll();
                                //Insertion d'une personne
                                Person p = new Person("ihab", "abadi");
                                dao.insert(p);
                            });
                        }
                    }).fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }



    @NonNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @NonNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

    @Override
    public void clearAllTables() {

    }
}
