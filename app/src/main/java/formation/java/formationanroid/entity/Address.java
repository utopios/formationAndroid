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

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    @NonNull
    public String getStreet() {
        return street;
    }

    public void setStreet(@NonNull String street) {
        this.street = street;
    }

    @NonNull
    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(@NonNull String postCode) {
        this.postCode = postCode;
    }
}
