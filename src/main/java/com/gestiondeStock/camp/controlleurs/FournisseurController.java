package com.gestiondeStock.camp.controlleurs;

import com.gestiondeStock.camp.entities.Fournisseur;
import com.gestiondeStock.camp.services.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/fournisseurs")
public class FournisseurController {

    @Autowired
    private FournisseurService fournisseurService;

    @GetMapping("")
    public String getAllFournisseurs(Model model) {
        List<Fournisseur> fournisseurs = fournisseurService.getAllFournisseurs();
        model.addAttribute("fournisseurs", fournisseurs);
        return "fournisseur/listeFournisseurs";
    }

    @GetMapping("/{id}")
    public String getFournisseurById(@PathVariable(value = "id") Long id, Model model) {
        Fournisseur fournisseur = fournisseurService.getFournisseurById(id);
        model.addAttribute("fournisseur", fournisseur);
        return "fournisseur/detailsFournisseur";
    }

    @GetMapping("/ajouter")
    public String ajouterFournisseur(Model model) {
        Fournisseur fournisseur = new Fournisseur();
        model.addAttribute("fournisseur", fournisseur);
        return "fournisseur/ajouterFournisseur";
    }

    @PostMapping("/ajouter")
    public String saveFournisseur(@ModelAttribute("fournisseur") Fournisseur fournisseur) {
        fournisseurService.createFournisseur(fournisseur);
        return "redirect:/fournisseurs";
    }

    @GetMapping("/{id}/modifier")
    public String modifierFournisseur(@PathVariable(value = "id") Long id, Model model) {
        Fournisseur fournisseur = fournisseurService.getFournisseurById(id);
        model.addAttribute("fournisseur", fournisseur);
        return "fournisseur/modifierFournisseur";
    }

    @PostMapping("/{id}/modifier")
    public String updateFournisseur(@PathVariable(value = "id") Long id, @ModelAttribute("fournisseur") Fournisseur fournisseurDetails) {
        fournisseurService.updateFournisseur(id, fournisseurDetails);
        return "redirect:/fournisseurs";
    }

    @GetMapping("/{id}/supprimer")
    public String supprimerFournisseur(@PathVariable(value = "id") Long id) {
        fournisseurService.deleteFournisseur(id);
        return "redirect:/fournisseurs";
    }
}

