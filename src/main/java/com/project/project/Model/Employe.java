package com.project.project.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Employe")
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_Employe;
    String designation_Employe;
    double salaire_Employe;
    int quantite_Employe;

    double duree_Employe;

    public double getDuree_Employe() {
        return duree_Employe;
    }

    public void setDuree_Employe(double duree_Employe) {
        this.duree_Employe = duree_Employe;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    Sac sac_Employe;

    public Employe() {
    }

    public Employe(int id_Employe, String designation_Employe, double salaire_Employe, int quantite_Employe, Sac sac_Employe) {
        this.id_Employe = id_Employe;
        this.designation_Employe = designation_Employe;
        this.salaire_Employe = salaire_Employe;
        this.quantite_Employe = quantite_Employe;
        this.sac_Employe = sac_Employe;
    }

    public int getId_Employe() {
        return id_Employe;
    }

    public void setId_Employe(int id_Employe) {
        this.id_Employe = id_Employe;
    }

    public String getDesignation_Employe() {
        return designation_Employe;
    }

    public void setDesignation_Employe(String designation_Employe) {
        this.designation_Employe = designation_Employe;
    }

    public double getSalaire_Employe() {
        return salaire_Employe;
    }

    public void setSalaire_Employe(double salaire_Employe) {
        this.salaire_Employe = salaire_Employe;
    }

    public int getQuantite_Employe() {
        return quantite_Employe;
    }

    public void setQuantite_Employe(int quantite_Employe) {
        this.quantite_Employe = quantite_Employe;
    }

    public Sac getSac_Employe() {
        return sac_Employe;
    }

    public void setSac_Employe(Sac sac_Employe) {
        this.sac_Employe = sac_Employe;
    }
}
