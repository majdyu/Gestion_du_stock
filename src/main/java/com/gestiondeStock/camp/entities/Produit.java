package com.gestiondeStock.camp.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor

@Entity
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String libelle;

    private String photoFace;

    private String photoProfil;

    private Double prix;

    private String description;

    private Integer quantiteStock;

    private Double prixPromotion;

    private LocalDate dateExpiration;

    @ManyToOne
    @JoinColumn(name = "fournisseur_id")
    private Fournisseur fournisseur;


    public Produit() {
    }

    public Produit(String libelle, String photoFace, String photoProfil, Double prix, String description, Integer quantiteStock, Double prixPromotion, LocalDate dateExpiration, Fournisseur fournisseur) {
        this.libelle = libelle;
        this.photoFace = photoFace;
        this.photoProfil = photoProfil;
        this.prix = prix;
        this.description = description;
        this.quantiteStock = quantiteStock;
        this.prixPromotion = prixPromotion;
        this.dateExpiration = dateExpiration;
        this.fournisseur = fournisseur;
    }

}

