package com.project.project.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Taille")
public class Taille {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int tailleId;
    @Column(length = 10)
    String tailleNom;

    public int getTailleId() {
        return tailleId;
    }

    public void setTailleId(int tailleId) {
        this.tailleId = tailleId;
    }

    public String getTailleNom() {
        return tailleNom;
    }

    public void setTailleNom(String tailleNom) {
        this.tailleNom = tailleNom;
    }

    public Taille() {
    }

    public Taille(int tailleId, String tailleNom) {
        this.tailleId = tailleId;
        this.tailleNom = tailleNom;
    }
}
