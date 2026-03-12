package com.esocial.supplyflow.repositories;

import com.esocial.supplyflow.entities.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FournisseurRepo extends JpaRepository <Fournisseur,Long> {
}
