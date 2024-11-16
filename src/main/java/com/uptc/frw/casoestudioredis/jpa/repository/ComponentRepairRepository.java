package com.uptc.frw.casoestudioredis.jpa.repository;

import com.uptc.frw.casoestudioredis.jpa.model.ComponentRepair;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio para la entidad `ComponentRepair`.
 * Proporciona operaciones CRUD básicas a través de JpaRepository.
 */
public interface ComponentRepairRepository extends JpaRepository<ComponentRepair, Long> {
    // Métodos CRUD proporcionados automáticamente por JpaRepository.
}
