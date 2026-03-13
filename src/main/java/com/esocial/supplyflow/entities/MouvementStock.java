package com.esocial.supplyflow.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class MouvementStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantite;

    @Enumerated(EnumType.STRING)
    private TypeMouvement type;

    private LocalDate date = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "produit_id")
    private Produit produit;
    public MouvementStock(){};

    public MouvementStock(int quantite, TypeMouvement type, LocalDate date, Produit produit) {
        this.quantite = quantite;
        this.type = type;
        this.date = date;
        this.produit = produit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public TypeMouvement getType() {
        return type;
    }

    public void setType(TypeMouvement type) {
        this.type = type;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
}