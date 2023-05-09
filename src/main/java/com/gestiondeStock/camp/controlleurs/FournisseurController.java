package com.gestiondeStock.camp.controlleurs;

import com.gestiondeStock.camp.entities.Fournisseur;
import com.gestiondeStock.camp.services.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RequestMapping("/fournisseurs")
public class FournisseurController {

    public static String uploadDirectory = System.getProperty("user.dir")+"/src/main/resources/static/upload";

    @Autowired
    private FournisseurService fournisseurService;

    @GetMapping("/getAllFournisseurs")
    public String getAllFournisseurs(Model model) {
        List<Fournisseur> fournisseurs = fournisseurService.getAllFournisseurs();
        if(fournisseurs.size()==0){
            fournisseurs=null;
        }
        model.addAttribute("fournisseurs", fournisseurs);
        return "back/fournisseur/listeFournisseurs";
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
        return "back/fournisseur/ajouterFournisseur";
    }

    @PostMapping("/ajouter")
    public String saveFournisseur(@ModelAttribute Fournisseur fournisseur, @RequestParam("files") MultipartFile[] files) {
        /// part upload

        StringBuilder fileName = new StringBuilder();
        MultipartFile file = files[0];
        Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());

        fileName.append(file.getOriginalFilename());
        try {
            Files.write(fileNameAndPath, file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        fournisseur.setLogo(fileName.toString());
        fournisseurService.createFournisseur(fournisseur);
        return "redirect:getAllFournisseurs";

    }

    @GetMapping("edit/{id}")
    public String showArticleFormToUpdate(@PathVariable("id") long id, Model model) {
        Fournisseur fournisseur = fournisseurService.getFournisseurById(id);
        model.addAttribute("fournisseur",fournisseur);

        return "back/fournisseur/updateFournisseur";
    }

    @PostMapping("/update")
    public String updateArticle(Fournisseur fournisseur) {
        fournisseurService.updateFournisseur(fournisseur);
        return "redirect:getAllFournisseurs";
    }

    @GetMapping("delete/{id}")
    public String deleteProvider(@PathVariable("id") long id, Model model) {
        fournisseurService.deleteFournisseur(id);
        return "redirect:/fournisseurs/getAllFournisseurs";
    }
}

