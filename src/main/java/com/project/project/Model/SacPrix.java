package com.project.project.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "view_prixsac")
public class SacPrix {
    @Id
    int sacId;

    String sacNom;
    double sacPrix;

    public int getSacId() {
        return sacId;
    }

    public void setSacId(int sacId) {
        this.sacId = sacId;
    }

    public String getSacNom() {
        return sacNom;
    }

    public void setSacNom(String sacNom) {
        this.sacNom = sacNom;
    }

    public double getSacPrix() {
        return sacPrix;
    }

    public void setSacPrix(double sacPrix) {
        this.sacPrix = sacPrix;
    }

    public SacPrix() {
    }
}
