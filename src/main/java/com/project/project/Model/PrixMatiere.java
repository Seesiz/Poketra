package com.project.project.Model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="prix_matiere")
public class PrixMatiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int prixMatId;
    @ManyToOne
    Matiere prixMatiere;
    double prixValue;
    Date prixDate;

    public Date getPrixDate() {
        return prixDate;
    }

    public void setPrixDate(Date prixDate) {
        this.prixDate = prixDate;
    }

    public int getPrixMatId() {
        return prixMatId;
    }

    public void setPrixMatId(int prixMatId) {
        this.prixMatId = prixMatId;
    }

    public Matiere getPrixMatiere() {
        return prixMatiere;
    }

    public void setPrixMatiere(Matiere prixMatiere) {
        this.prixMatiere = prixMatiere;
    }

    public double getPrixValue() {
        return prixValue;
    }

    public void setPrixValue(double prixValue) {
        this.prixValue = prixValue;
    }

    public PrixMatiere() {
    }
}
