package com.gestiondeStock.camp.services;

import com.gestiondeStock.camp.entities.Fournisseur;

import java.util.List;

public interface FournisseurService {

    List<Fournisseur> getAllFournisseurs();

    Fournisseur getFournisseurById(Long id);

    Fournisseur createFournisseur(Fournisseur fournisseur);

    Fournisseur updateFournisseur(Fournisseur fournisseur);

    void deleteFournisseur(Long id);
}

