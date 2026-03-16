package com.esocial.supplyflow.controllers;

import com.esocial.supplyflow.entities.Fournisseur;
import com.esocial.supplyflow.entities.Produit;
import com.esocial.supplyflow.service.FournisseurService;
import org.springframework.ui.Model;
import com.esocial.supplyflow.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/produits")
public class ProduitController {

    @Autowired
    ProduitService produitService;

    @Autowired
    FournisseurService fournisseurService;

    @GetMapping
    public String lister(Model model){
        model.addAttribute("produits", produitService.listerTousLesProduits());
        model.addAttribute("produit", new Produit());
        return "listeProduits";

    }

    @PostMapping("/save")
    public String save (@ModelAttribute Produit p){
        produitService.enregistrerProduit(p);
        return "redirect:/produits";

    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        produitService.delete(id);
        return "redirect:/produits";
    }

    @GetMapping("/find/{id}")
    public  String find(@PathVariable Long id, Model model){
        Produit p = produitService.findById(id);
        if (p!=null){
            model.addAttribute("monProduit",p);
            return "detailsProduit";
        }else {
            return "redirect:/produits";
        }
    }

    @GetMapping("/nouveau")
    public String ajouterProduit(Model model) {
        Produit p = new Produit();
        p.setFournisseur(new Fournisseur());
        model.addAttribute("produit", new Produit());
        model.addAttribute("fournisseurs", fournisseurService.listeTousLesFournisseurs());
        return "formProduit";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        Produit p = produitService.findById(id);
        if (p != null) {
            model.addAttribute("produit", p);
            model.addAttribute("fournisseurs", fournisseurService.listeTousLesFournisseurs());
            return "formProduit";
        }else {
            return "redirect:/produits";
        }
    }


}
