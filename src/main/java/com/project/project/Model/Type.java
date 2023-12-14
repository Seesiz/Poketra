package com.project.project.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Type")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int typeId;
    String typeNom;

    public Type() {
    }

    public Type(int typeId, String typeNom) {
        this.typeId = typeId;
        this.typeNom = typeNom;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeNom() {
        return typeNom;
    }

    public void setTypeNom(String typeNom) {
        this.typeNom = typeNom;
    }
}
