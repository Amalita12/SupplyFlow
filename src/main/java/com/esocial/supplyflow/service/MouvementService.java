package com.esocial.supplyflow.service;

import com.esocial.supplyflow.entities.MouvementStock;
import com.esocial.supplyflow.entities.Produit;
import com.esocial.supplyflow.entities.TypeMouvement;
import com.esocial.supplyflow.repositories.MouvementRepo;
import com.esocial.supplyflow.repositories.ProduitRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class MouvementService {
    @Autowired
    private ProduitRepo produitRepo;
    @Autowired
    private MouvementRepo mouvementRepo;


    @Transactional
    public void ajouterQuantite(int quantite, Long produitId) {
        Produit p = produitRepo.findById(produitId).orElseThrow(() -> new RuntimeException("Produit non trouvé"));
        p.setQuantite(p.getQuantite() + quantite);
        produitRepo.save(p);

        MouvementStock m = new MouvementStock(quantite, TypeMouvement.ENTREE, LocalDate.now(), p);
        mouvementRepo.save(m);

    }

    public void retirerQuantite(int quantite, Long ProduitId) {
        Produit p = produitRepo.findById(ProduitId).orElseThrow(() -> new RuntimeException("Produit non trouvé"));
        if (p.getQuantite() >= quantite) {
            p.setQuantite(p.getQuantite() - quantite);
            produitRepo.save(p);


            MouvementStock m = new MouvementStock(quantite, TypeMouvement.SORTIE, LocalDate.now(), p);
            mouvementRepo.save(m);
        } else {
            throw new RuntimeException("stock insuffisant");
        }
    }

    public List<MouvementStock> consulterHistorique(Long produitId){
        return mouvementRepo.findByProduitId(produitId);
    }
}
