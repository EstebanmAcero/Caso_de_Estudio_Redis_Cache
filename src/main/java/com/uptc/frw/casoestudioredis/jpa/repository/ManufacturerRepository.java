package com.uptc.frw.casoestudioredis.jpa.repository;

import com.uptc.frw.casoestudioredis.jpa.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio para la entidad `Manufacturer`.
 * Proporciona operaciones CRUD sobre fabricantes.
 */
public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {
    // Métodos CRUD proporcionados automáticamente por JpaRepository.
}
