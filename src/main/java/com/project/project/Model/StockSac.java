package com.project.project.Model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name= "Stock_Sac")
public class StockSac {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idStock;

    @ManyToOne
    Sac sacStock;
    double quanStockEntre;
    double quanStockSortie;

    public double getQuanStockSortie() {
        return quanStockSortie;
    }

    public void setQuanStockSortie(double quanStockSortie) {
        this.quanStockSortie = quanStockSortie;
    }

    Date dateSac;

    public int getEtatStock() {
        return etatStock;
    }

    public void setEtatStock(int etatStock) {
        this.etatStock = etatStock;
    }

    int etatStock;

    public int getIdStock() {
        return idStock;
    }

    public void setIdStock(int idStock) {
        this.idStock = idStock;
    }

    public Sac getSacStock() {
        return sacStock;
    }

    public void setSacStock(Sac sacStock) {
        this.sacStock = sacStock;
    }

    public double getQuanStockEntre() {
        return quanStockEntre;
    }

    public void setQuanStockEntre(double quanStock) {
        this.quanStockEntre = quanStock;
    }

    public Date getDateSac() {
        return dateSac;
    }

    public void setDateSac(Date dateSac) {
        this.dateSac = dateSac;
    }

    public StockSac() {
    }
}
