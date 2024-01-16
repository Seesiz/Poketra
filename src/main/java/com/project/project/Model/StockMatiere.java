package com.project.project.Model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Stock_Matiere")
public class StockMatiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idStockmat;
    @ManyToOne
    Matiere matStockmat;
    double quanStockmatEntree;

    public double getQuanStockmatSortie() {
        return quanStockmatSortie;
    }

    public void setQuanStockmatSortie(double quanStockmatSortie) {
        this.quanStockmatSortie = quanStockmatSortie;
    }

    double quanStockmatSortie;

    Date dateStockmat;
    int etatStockmat;

    public int getIdStockmat() {
        return idStockmat;
    }

    public void setIdStockmat(int idStockmat) {
        this.idStockmat = idStockmat;
    }

    public Matiere getMatStockmat() {
        return matStockmat;
    }

    public void setMatStockmat(Matiere matStockmat) {
        this.matStockmat = matStockmat;
    }

    public double getQuanStockmatEntree() {
        return quanStockmatEntree;
    }

    public void setQuanStockmatEntree(double quanStockmat) {
        this.quanStockmatEntree = quanStockmat;
    }

    public Date getDateStockmat() {
        return dateStockmat;
    }

    public void setDateStockmat(Date dateStockmat) {
        this.dateStockmat = dateStockmat;
    }

    public int getEtatStockmat() {
        return etatStockmat;
    }

    public void setEtatStockmat(int etatStockmat) {
        this.etatStockmat = etatStockmat;
    }

    public StockMatiere() {
    }
}
