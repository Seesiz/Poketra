package com.project.project.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jdk.jfr.Enabled;

@Entity
@Table(name = "view_prixreviens")
public class PrixReviens {
    @Id
    int sac_id;
    String sac_nom;

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

    public double getPrixreviens() {
        return prixreviens;
    }

    public void setPrixreviens(double prixreviens) {
        this.prixreviens = prixreviens;
    }

    public PrixReviens() {
    }

    double prixreviens;
}
