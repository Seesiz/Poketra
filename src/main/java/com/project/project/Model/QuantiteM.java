package com.project.project.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Quantite")
public class QuantiteM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int quanId;
    double quanValue;

    public int getQuanId() {
        return quanId;
    }

    public void setQuanId(int quanId) {
        this.quanId = quanId;
    }

    public double getQuanValue() {
        return quanValue;
    }

    public void setQuanValue(double quanValue) {
        this.quanValue = quanValue;
    }

    public Matiere_Look getQuanMatiereLook() {
        return quanMatiereLook;
    }

    public void setQuanMatiereLook(Matiere_Look quanMatiereLook) {
        this.quanMatiereLook = quanMatiereLook;
    }

    public Taille getQuanTaille() {
        return quanTaille;
    }

    public void setQuanTaille(Taille quanTaille) {
        this.quanTaille = quanTaille;
    }

    public QuantiteM() {
    }

    @ManyToOne
    Matiere_Look quanMatiereLook;
    @ManyToOne
    Taille quanTaille;

}
