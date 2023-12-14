package com.project.project.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Unite")
public class Unite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int uniId;
    String uni_nom;

    public Unite() {
    }

    public Unite(String uni_nom, int uni_id) {
        this.uni_nom = uni_nom;
        this.uniId = uni_id;
    }

    public String getUni_nom() {
        return uni_nom;
    }

    public void setUni_nom(String uni_nom) {
        this.uni_nom = uni_nom;
    }

    public int getUniId() {
        return uniId;
    }

    public void setUniId(int uni_id) {
        this.uniId = uni_id;
    }
}
