package com.gestiondeStock.camp.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor

@Entity
public class Fournisseur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String logo;

    private String nom;

    private String email;

    private String telephone;

    private String adresse;

    @OneToMany(mappedBy = "fournisseur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Produit> produits = new ArrayList<>();



    public Fournisseur() {
    }

    public Fournisseur(String logo, String nom, String email, String telephone, String adresse) {
        this.logo = logo;
        this.nom = nom;
        this.email = email;
        this.telephone = telephone;
        this.adresse = adresse;
    }
}

