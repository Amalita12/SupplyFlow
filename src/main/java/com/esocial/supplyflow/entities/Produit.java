package com.esocial.supplyflow.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

    @Entity

    public class Produit {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String nom;
        private String categorie;

        @Column(precision = 10, scale = 2)
        private BigDecimal prix;

        private Integer quantite;

        @ManyToOne
        @JoinColumn(name = "fournisseur_id")
        private Fournisseur fournisseur;

        @OneToMany(mappedBy = "produit")
        private List<MouvementStock> mouvements;
        public Produit(){};

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }

        public String getCategorie() {
            return categorie;
        }

        public void setCategorie(String categorie) {
            this.categorie = categorie;
        }

        public BigDecimal getPrix() {
            return prix;
        }

        public void setPrix(BigDecimal prix) {
            this.prix = prix;
        }

        public Integer getQuantite() {
            return quantite;
        }

        public void setQuantite(Integer quantite) {
            this.quantite = quantite;
        }

        public Fournisseur getFournisseur() {
            return fournisseur;
        }

        public void setFournisseur(Fournisseur fournisseur) {
            this.fournisseur = fournisseur;
        }

        public List<MouvementStock> getMouvements() {
            return mouvements;
        }

        public void setMouvements(List<MouvementStock> mouvements) {
            this.mouvements = mouvements;
        }
    }

