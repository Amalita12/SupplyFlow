package com.esocial.supplyflow.repositories;

import com.esocial.supplyflow.entities.MouvementStock;
import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MouvementRepo extends JpaRepository<MouvementStock,Long> {
    List<MouvementStock> findByProduitId(Long produitId);
}
