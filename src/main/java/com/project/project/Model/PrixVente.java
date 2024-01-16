package com.project.project.Model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "PrixVente")
public class PrixVente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idPrix;

    @ManyToOne
    Sac sacPrix;

    double prix;

    public Date getDatePrix() {
        return datePrix;
    }

    public void setDatePrix(Date datePrix) {
        this.datePrix = datePrix;
    }

    Date datePrix;
    public int getIdPrix() {
        return idPrix;
    }

    public void setIdPrix(int idPrix) {
        this.idPrix = idPrix;
    }

    public Sac getSacPrix() {
        return sacPrix;
    }

    public void setSacPrix(Sac sacPrix) {
        this.sacPrix = sacPrix;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public PrixVente() {
    }
}
