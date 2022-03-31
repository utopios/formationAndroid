package formation.java.formationanroid.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Address {
    @PrimaryKey
    public long addressId;

    public int personId;

    @NonNull
    private String street;

    @NonNull
    private String postCode;
}
