package com.project.project.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "SacMatiere")
public class SacMatiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int sacMatiereId;
    @JoinColumn(name = "sacMatiereIdMatiere")
    @ManyToOne
    Matiere sacMatiere;
    @ManyToOne
    @JoinColumn(name = "sacMatiereIdSac")
    Sac sacSac;

    public int getSacMatiereId() {
        return sacMatiereId;
    }

    public void setSacMatiereId(int sacMatiereId) {
        this.sacMatiereId = sacMatiereId;
    }

    public Matiere getSacMatiere() {
        return sacMatiere;
    }

    public void setSacMatiere(Matiere sacMatiere) {
        this.sacMatiere = sacMatiere;
    }

    public Sac getSacSac() {
        return sacSac;
    }

    public void setSacSac(Sac sacSac) {
        this.sacSac = sacSac;
    }

    public SacMatiere() {
    }

    public SacMatiere(int sacMatiereId, Matiere sacMatiere, Sac sacSac) {
        this.sacMatiereId = sacMatiereId;
        this.sacMatiere = sacMatiere;
        this.sacSac = sacSac;
    }
}
