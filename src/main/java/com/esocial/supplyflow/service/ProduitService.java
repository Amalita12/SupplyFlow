package com.esocial.supplyflow.service;

import com.esocial.supplyflow.entities.Produit;
import com.esocial.supplyflow.repositories.ProduitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProduitService {

    @Autowired
    private ProduitRepo produitRepo;

    public List<Produit> listerTousLesProduits(){
        return produitRepo.findAll();
    }

    public Produit enregistrerProduit(Produit p){
        return produitRepo.save(p);
    }

    public Produit findById(Long id){
        return produitRepo.findById(id).orElse(null);
    }
    public void delete(Long id){
        produitRepo.deleteById(id);
    }

}

