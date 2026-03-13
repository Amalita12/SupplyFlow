package com.esocial.supplyflow.controllers;

import com.esocial.supplyflow.entities.Fournisseur;
import com.esocial.supplyflow.entities.Produit;
import com.esocial.supplyflow.service.FournisseurService;
import com.esocial.supplyflow.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class FournisseurController {

    @Autowired
    FournisseurService fournisseurService;

    @GetMapping
    public String lister(Model model){
        model.addAttribute("fournisseurs", fournisseurService.listeTousLesFournisseurs() );
        return "listeFournisseurs";
    }
    @PostMapping
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



    }
