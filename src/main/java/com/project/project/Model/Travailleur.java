package com.project.project.Model;

import jakarta.persistence.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name="Travailleur")
public class Travailleur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idTravailler;
    String nom;
    String prenom;
    Date dateEmbauche;
    int etat;
    @ManyToOne
    @JoinColumn(name = "poste")
    Poste poste;

    public void setDateEmbauche(Date dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public Poste getPoste() {
        return poste;
    }

    public void setPoste(Poste poste) {
        this.poste = poste;
    }

    double augmentation;

    public double getAugmentation() {
        return augmentation;
    }

    public void setAugmentation(double augmentation) {
        this.augmentation = augmentation;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }
    public int getIdTravailler() {
        return idTravailler;
    }

    public void setIdTravailler(int idTravailler) {
        this.idTravailler = idTravailler;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(String dateEmbauche) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = dateFormat.parse(dateEmbauche);
            this.dateEmbauche = date;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Travailleur() {
    }
}
