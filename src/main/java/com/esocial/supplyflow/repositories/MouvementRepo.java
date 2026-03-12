package com.esocial.supplyflow.repositories;

import com.esocial.supplyflow.entities.MouvementStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MouvementRepo extends JpaRepository<MouvementStock,Long> {
}
