package com.project.project.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "view_reste")
public class Reste {
    @Id
    int mat_id;

    double reste;

    public String getMatNom() {
        return matNom;
    }

    public void setMatNom(String mat_nom) {
        this.matNom = mat_nom;
    }

    String matNom;

    public Reste() {
    }

    public int getMat_id() {
        return mat_id;
    }

    public void setMat_id(int mat_stockmat_mat_id) {
        this.mat_id = mat_stockmat_mat_id;
    }

    public double getReste() {
        return reste;
    }

    public void setReste(double reste) {
        this.reste = reste;
    }
}
