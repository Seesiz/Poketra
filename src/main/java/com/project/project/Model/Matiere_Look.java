package com.project.project.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
@Entity
@Table(name = "MatiereLook")
public class Matiere_Look {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int matdet_id;
    @ManyToOne(cascade = CascadeType.ALL)
    Matiere matdet_matiere;
    @ManyToOne(cascade = CascadeType.ALL)
    Look matdetLook;

    public Matiere_Look() {
    }

    public int getMatdet_id() {
        return matdet_id;
    }

    public void setMatdet_id(int matdet_id) {
        this.matdet_id = matdet_id;
    }

    public Matiere getMatdet_matiere() {
        return matdet_matiere;
    }

    public void setMatdet_matiere(Matiere matdet_matiere) {
        this.matdet_matiere = matdet_matiere;
    }

    public Look getMatdetLook() {
        return matdetLook;
    }

    public void setMatdetLook(Look matdet_look) {
        this.matdetLook = matdet_look;
    }

    public Matiere_Look(int matdet_id, Matiere matdet_matiere, Look matdet_look) {
        this.matdet_id = matdet_id;
        this.matdet_matiere = matdet_matiere;
        this.matdetLook = matdet_look;
    }

}
