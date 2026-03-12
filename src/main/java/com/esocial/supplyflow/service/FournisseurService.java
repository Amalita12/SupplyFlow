package com.esocial.supplyflow.service;

import com.esocial.supplyflow.entities.Fournisseur;
import com.esocial.supplyflow.repositories.FournisseurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FournisseurService {



    @Autowired
    private FournisseurRepo fournisseurRepo;

    public List<Fournisseur> listeTousLesFournisseurs(){
        return fournisseurRepo.findAll();
    }
    public Fournisseur save(Fournisseur f){
        return fournisseurRepo.save(f);
    }
    public Fournisseur findById(Long id){
        return fournisseurRepo.findById(id).orElse(null);
    }
    public void deleteById(Long id){
        fournisseurRepo.deleteById(id);
    }
}

