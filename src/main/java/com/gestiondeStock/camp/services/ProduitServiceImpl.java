package com.gestiondeStock.camp.services;

import com.gestiondeStock.camp.entities.Produit;
import com.gestiondeStock.camp.repositories.ProduitRepository;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;

@Service
public class ProduitServiceImpl implements ProduitService {

    @Autowired
    private ProduitRepository produitRepository;

    @Override
    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    @Override
    public Produit getProduitById(Long id) {
        Optional<Produit> produit = produitRepository.findById(id);
        return produit.orElse(null);
    }

    @Override
    public Produit createProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public Produit updateProduit(Long id, Produit produitDetails) {
        Optional<Produit> produit = produitRepository.findById(id);
        if (!produit.isPresent()) {
            return null;
        }

        produit.get().setLibelle(produitDetails.getLibelle());
        produit.get().setPhotoFace(produitDetails.getPhotoFace());
        produit.get().setPhotoProfil(produitDetails.getPhotoProfil());
        produit.get().setPrix(produitDetails.getPrix());
        produit.get().setDescription(produitDetails.getDescription());
        produit.get().setQuantiteStock(produitDetails.getQuantiteStock());
        produit.get().setPrixPromotion(produitDetails.getPrixPromotion());
        produit.get().setDateExpiration(produitDetails.getDateExpiration());
        produit.get().setFournisseur(produitDetails.getFournisseur());

        return produitRepository.save(produit.get());
    }

    @Override
    public void deleteProduit(Long id) {
        Optional<Produit> produit = produitRepository.findById(id);
        if (produit.isPresent()) {
            produitRepository.delete(produit.get());
        }
    }
}
