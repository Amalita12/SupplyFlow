package com.esocial.supplyflow;

import com.esocial.supplyflow.entities.Produit;

import com.esocial.supplyflow.repositories.ProduitRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(ProduitRepo produitRepo) {
        return args -> {
            Produit p = new Produit();
            p.setNom("Ordinateur DELL");
            p.setCategorie("Informatique");
            p.setPrix(new BigDecimal("300.00"));
            p.setQuantite(20);



            produitRepo.save(p);

            System.out.println("Produit enregistré avec succès ! ID: " + p.getId());
        };
    }
}