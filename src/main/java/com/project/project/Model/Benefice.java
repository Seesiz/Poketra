package com.project.project.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "view_benefice")
public class Benefice {
    @Id
    int sac_id;
    String sac_nom;
    double benefice;

    @Transient
    Sac sac;

    public Sac getSac() {
        return sac;
    }

    public void setSac(Sac sac) {
        this.sac = sac;
    }

    public Benefice() {
    }

    public int getSac_id() {
        return sac_id;
    }

    public void setSac_id(int sac_id) {
        this.sac_id = sac_id;
    }

    public String getSac_nom() {
        return sac_nom;
    }

    public void setSac_nom(String sac_nom) {
        this.sac_nom = sac_nom;
    }

    public double getBenefice() {
        return benefice;
    }

    public void setBenefice(double benefice) {
        this.benefice = benefice;
    }
}
