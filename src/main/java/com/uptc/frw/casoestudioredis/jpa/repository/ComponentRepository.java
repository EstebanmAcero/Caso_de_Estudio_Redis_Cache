package com.uptc.frw.casoestudioredis.jpa.repository;

import com.uptc.frw.casoestudioredis.jpa.model.Component;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio para la entidad `Component`.
 * Extiende JpaRepository para proporcionar operaciones CRUD sobre los componentes.
 */
public interface ComponentRepository extends JpaRepository<Component, Long> {
    // Métodos CRUD proporcionados automáticamente por JpaRepository.
}
