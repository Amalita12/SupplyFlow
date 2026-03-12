package com.esocial.supplyflow.repositories;

import com.esocial.supplyflow.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepo extends JpaRepository<Produit,Long> {
}
