package com.project.project.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Look")
public class Look {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int lookId;
    String look_nom;

    public Look() {
    }

    public Look(int look_id, String look_nom) {
        this.lookId = look_id;
        this.look_nom = look_nom;
    }

    public int getLookId() {
        return lookId;
    }

    public void setLookId(int look_id) {
        this.lookId = look_id;
    }

    public String getLook_nom() {
        return look_nom;
    }

    public void setLook_nom(String look_nom) {
        this.look_nom = look_nom;
    }
}
