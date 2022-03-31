package formation.java.formationanroid.entity;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class PersonWithAddress {
    @Embedded
    public Person person;

    @Relation(
            parentColumn = "id",
            entityColumn = "personId"
    )
    public List<Address> addresses;
}