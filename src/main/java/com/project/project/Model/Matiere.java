package com.project.project.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Matiere")
public class Matiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int mat_id;
    String mat_nom;
    @ManyToOne
    Unite mat_unite;
    double mat_prixunitaire;

    public Matiere() {
    }

    public Matiere(String mat_nom, int mat_id, Unite mat_unite, double mat_prixunitaire) {
        this.mat_nom = mat_nom;
        this.mat_id = mat_id;
        this.mat_unite = mat_unite;
        this.mat_prixunitaire = mat_prixunitaire;
    }

    public String getMat_nom() {
        return mat_nom;
    }

    public void setMat_nom(String mat_nom) {
        this.mat_nom = mat_nom;
    }

    public int getMat_id() {
        return mat_id;
    }

    public void setMat_id(int mat_id) {
        this.mat_id = mat_id;
    }

    public Unite getMat_unite() {
        return mat_unite;
    }

    public void setMat_unite(Unite mat_unite) {
        this.mat_unite = mat_unite;
    }

    public double getMat_prixunitaire() {
        return mat_prixunitaire;
    }

    public void setMat_prixunitaire(double mat_prixunitaire) {
        this.mat_prixunitaire = mat_prixunitaire;
    }
}
