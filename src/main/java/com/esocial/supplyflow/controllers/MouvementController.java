package com.esocial.supplyflow.controllers;

import com.esocial.supplyflow.service.MouvementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller

public class MouvementController {

    @Autowired
    private MouvementService mouvementService;

    @PostMapping("/mouvement/{id}")
    public String traiterMouvement(@PathVariable Long id, @RequestParam int quantite, @RequestParam String type) {
        if ("ENTREE".equalsIgnoreCase(type)) {
            mouvementService.ajouterQuantite(quantite, id);
        } else {
            mouvementService.retirerQuantite(quantite,id);
        }
        return "redirect:/produits";
    }
}
