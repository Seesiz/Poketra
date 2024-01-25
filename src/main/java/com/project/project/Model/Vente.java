package com.project.project.Model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "vente")
public class Vente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idVente;

    @ManyToOne
    @JoinColumn(name = "idClient")
    Client client;

    @ManyToOne
    @JoinColumn(name = "idSac")
    Sac sac;
    double quantite;
    Date date;

    public int getIdVente() {
        return idVente;
    }

    public void setIdVente(int idVente) {
        this.idVente = idVente;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Sac getSac() {
        return sac;
    }

    public void setSac(Sac sac) {
        this.sac = sac;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Vente() {
    }
}
