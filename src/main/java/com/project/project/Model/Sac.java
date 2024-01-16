package com.project.project.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Sac")
public class Sac {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int sacId;

    String sacNom;
    @ManyToOne
    Look sacLook;
    @ManyToOne
    Type sacType;
    @ManyToOne
    Taille sacTaille;
    double sacPrix;

    public double getSacDuree() {
        return sacDuree;
    }

    public void setSacDuree(double sacDuree) {
        this.sacDuree = sacDuree;
    }

    double sacDuree;

    public Sac() {
    }

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

    public Look getSacLook() {
        return sacLook;
    }

    public void setSacLook(Look sacLook) {
        this.sacLook = sacLook;
    }

    public Type getSacType() {
        return sacType;
    }

    public void setSacType(Type sacType) {
        this.sacType = sacType;
    }

    public Taille getSacTaille() {
        return sacTaille;
    }

    public void setSacTaille(Taille sacTaille) {
        this.sacTaille = sacTaille;
    }

    public double getSacPrix() {
        return sacPrix;
    }

    public void setSacPrix(double sacPrix) {
        this.sacPrix = sacPrix;
    }

    public Sac(int sacId, String sacNom, Look sacLook, Type sacType, Taille sacTaille, double sacPrix) {
        this.sacId = sacId;
        this.sacNom = sacNom;
        this.sacLook = sacLook;
        this.sacType = sacType;
        this.sacTaille = sacTaille;
        this.sacPrix = sacPrix;
    }
}
