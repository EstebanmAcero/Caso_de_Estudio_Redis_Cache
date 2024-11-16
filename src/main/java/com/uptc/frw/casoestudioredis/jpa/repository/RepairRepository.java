package com.uptc.frw.casoestudioredis.jpa.repository;

import com.uptc.frw.casoestudioredis.jpa.model.Repair;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio para la entidad `Repair`.
 * Proporciona operaciones CRUD sobre reparaciones.
 */
public interface RepairRepository extends JpaRepository<Repair, Long> {
    // Métodos CRUD proporcionados automáticamente por JpaRepository.
}
