package com.esocial.supplyflow.controllers;

import com.esocial.supplyflow.entities.Fournisseur;
import com.esocial.supplyflow.entities.Produit;
import com.esocial.supplyflow.service.FournisseurService;
import com.esocial.supplyflow.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;


@Controller
@RequestMapping("/fournisseurs")
public class FournisseurController {

    @Autowired
    FournisseurService fournisseurService;

    @GetMapping
    public String lister(Model model){
        model.addAttribute("fournisseurs", fournisseurService.listeTousLesFournisseurs() );
        return "listeFournisseurs";
    }
    @PostMapping("/save")
    public String save (@ModelAttribute Fournisseur f){
        fournisseurService.save(f);
        return "redirect:/fournisseurs";
    }

    @GetMapping("/find/{id}")
    public String find (@PathVariable Long id, Model model){
        Fournisseur f = fournisseurService.findById(id);
        if (f!=null){
            model.addAttribute("FournisseurTrouve",f);
            return "detailsFournisseur";
        }else {
            return "redirect:/fournisseurs";
        }

    }
    @GetMapping("/delete/{id}")
            public String delete (@PathVariable Long id){
        fournisseurService.deleteById(id);
        return "redirect:/produits";
    }

    @GetMapping("/nouveau")
    public String ajouterFournisseur(Model model) {
        model.addAttribute("fournisseur", new Fournisseur());
        return "formFournisseur";
    }

    }
