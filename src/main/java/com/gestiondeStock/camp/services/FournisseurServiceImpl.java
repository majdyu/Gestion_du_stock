package com.gestiondeStock.camp.services;

import com.gestiondeStock.camp.entities.Fournisseur;
import com.gestiondeStock.camp.repositories.FournisseurRepository;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FournisseurServiceImpl implements FournisseurService {

    @Autowired
    private FournisseurRepository fournisseurRepository;

    @Override
    public List<Fournisseur> getAllFournisseurs() {
        return fournisseurRepository.findAll();
    }

    @Override
    public Fournisseur getFournisseurById(Long id) {
        Optional<Fournisseur> fournisseur = fournisseurRepository.findById(id);
        if (fournisseur.isPresent()) {
            return fournisseur.get();
        } else {
            throw new IllegalArgumentException("Fournisseur non trouvé pour l'identifiant " + id);
        }
    }

    @Override
    public Fournisseur createFournisseur(Fournisseur fournisseur) {
        return fournisseurRepository.save(fournisseur);
    }

    @Override
    public Fournisseur updateFournisseur(Fournisseur fournisseur) {
        return fournisseurRepository.save(fournisseur);
    }

    @Override
    public void deleteFournisseur(Long id) {
        fournisseurRepository.deleteById(id);
    }
}
