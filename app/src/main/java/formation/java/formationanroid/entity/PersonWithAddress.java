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

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}