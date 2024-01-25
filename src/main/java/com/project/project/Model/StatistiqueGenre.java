package com.project.project.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "view_metystock")
public class StatistiqueGenre {
    @Id
    int idSac;
    String sacNom;
    int homme;
    int femme;

    public String getSacNom() {
        return sacNom;
    }

    public void setSacNom(String sacNom) {
        this.sacNom = sacNom;
    }

    public int getIdSac() {
        return idSac;
    }

    public void setIdSac(int idSac) {
        this.idSac = idSac;
    }

    public int getHomme() {
        return homme;
    }

    public void setHomme(int homme) {
        this.homme = homme;
    }

    public int getFemme() {
        return femme;
    }

    public void setFemme(int femme) {
        this.femme = femme;
    }

    public StatistiqueGenre() {
    }
}
