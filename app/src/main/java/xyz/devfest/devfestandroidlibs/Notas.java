package xyz.devfest.devfestandroidlibs;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;

/**
 * Created by andresvasquez on 16/2/16.
 */
public class Notas {

    
    public int id;

    @SerializedName("titular")
    @DatabaseField(columnName = "nombre")
    public int nota;

    @SerializedName("titular")
    @DatabaseField(columnName = "nombre")
    public String material;

    public Notas(int id, int nota, String material) {
        this.id = id;
        this.nota = nota;
        this.material = material;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
