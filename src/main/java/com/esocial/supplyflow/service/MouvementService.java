package com.esocial.supplyflow.service;

import com.esocial.supplyflow.entities.MouvementStock;
import com.esocial.supplyflow.entities.Produit;
import com.esocial.supplyflow.entities.TypeMouvement;
import com.esocial.supplyflow.repositories.MouvementRepo;
import com.esocial.supplyflow.repositories.ProduitRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service

public class MouvementService {
    @Autowired
    private ProduitRepo produitRepo;
    @Autowired
    private MouvementRepo mouvementRepo;

    @Transactional
    public void enregistrerMouvement(MouvementStock mouvement , Long produitId){
        Produit p = produitRepo.findById(produitId).orElseThrow(()-> new RuntimeException("Produit non trouvé"));
        if (TypeMouvement.ENTREE == mouvement.getType()){
            p.setQuantite(p.getQuantite()+mouvement.getQuantite());

        }else if (TypeMouvement.SORTIE == mouvement.getType()){
            if (mouvement.getQuantite() > p.getQuantite()){
                throw  new RuntimeException("stock insuffisant");
            }else {
                p.setQuantite(p.getQuantite()-mouvement.getQuantite());
            }
        }
        produitRepo.save(p);
        mouvementRepo.save(mouvement);
    }
}
