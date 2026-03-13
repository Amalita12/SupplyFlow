package com.esocial.supplyflow.controllers;

import com.esocial.supplyflow.entities.Produit;
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

    @GetMapping
    public String lister(Model model){
        model.addAttribute("produits", produitService.listerTousLesProduits());
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


}
