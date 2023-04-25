package com.gestiondeStock.camp.controlleurs;

import com.gestiondeStock.camp.entities.Produit;
import com.gestiondeStock.camp.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/produits")
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    @GetMapping("")
    public String getAllProduits(Model model) {
        List<Produit> produits = produitService.getAllProduits();
        model.addAttribute("produits", produits);
        return "listeProduits";
    }

    @GetMapping("/{id}")
    public String getProduitById(@PathVariable Long id, Model model) {
        Produit produit = produitService.getProduitById(id);
        model.addAttribute("produit", produit);
        return "detailProduit";
    }

    @GetMapping("/ajouter")
    public String showAddProduitForm(Model model) {
        Produit produit = new Produit();
        model.addAttribute("produit", produit);
        return "ajouterProduit";
    }

    @PostMapping("/ajouter")
    public String addProduit(@ModelAttribute("produit") Produit produit) {
        produitService.createProduit(produit);
        return "redirect:/produits";
    }

    @GetMapping("/{id}/modifier")
    public String showUpdateProduitForm(@PathVariable Long id, Model model) {
        Produit produit = produitService.getProduitById(id);
        model.addAttribute("produit", produit);
        return "modifierProduit";
    }

    @PostMapping("/{id}/modifier")
    public String updateProduit(@PathVariable Long id, @ModelAttribute("produit") Produit produitDetails) {
        produitService.updateProduit(id, produitDetails);
        return "redirect:/produits";
    }

    @GetMapping("/{id}/supprimer")
    public String deleteProduit(@PathVariable Long id) {
        produitService.deleteProduit(id);
        return "redirect:/produits";
    }
}
