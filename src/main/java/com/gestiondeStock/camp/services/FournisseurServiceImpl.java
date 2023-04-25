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
    public Fournisseur updateFournisseur(Long id, Fournisseur fournisseurDetails) {
        Optional<Fournisseur> optionalFournisseur = fournisseurRepository.findById(id);
        if (optionalFournisseur.isPresent()) {
            Fournisseur fournisseur = optionalFournisseur.get();
            fournisseur.setLogo(fournisseurDetails.getLogo());
            fournisseur.setNom(fournisseurDetails.getNom());
            fournisseur.setEmail(fournisseurDetails.getEmail());
            fournisseur.setTelephone(fournisseurDetails.getTelephone());
            fournisseur.setAdresse(fournisseurDetails.getAdresse());
            return fournisseurRepository.save(fournisseur);
        } else {
            throw new IllegalArgumentException("Fournisseur non trouvé pour l'identifiant " + id);
        }
    }

    @Override
    public void deleteFournisseur(Long id) {
        Optional<Fournisseur> optionalFournisseur = fournisseurRepository.findById(id);
        if (optionalFournisseur.isPresent()) {
            fournisseurRepository.delete(optionalFournisseur.get());
        } else {
            throw new IllegalArgumentException("Fournisseur non trouvé pour l'identifiant " + id);
        }
    }
}
