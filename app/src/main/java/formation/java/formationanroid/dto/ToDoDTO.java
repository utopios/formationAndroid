package formation.java.formationanroid.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class ToDoDTO {

    @SerializedName("id")
    @Expose
    public int id;

    @SerializedName("title")
    @Expose
    public String title;

    @SerializedName("priority")
    @Expose
    public int priority;
}
