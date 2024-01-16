package com.project.project.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "view_stockSac")
public class ResteStockSac {
    @Id
    int sacId;
    String sacNom;
    double reste;

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

    public double getReste() {
        return reste;
    }

    public void setReste(double reste) {
        this.reste = reste;
    }

    public ResteStockSac() {
    }
}
