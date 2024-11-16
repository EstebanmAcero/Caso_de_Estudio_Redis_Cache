package com.uptc.frw.casoestudioredis.jpa.repository;

import com.uptc.frw.casoestudioredis.jpa.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio para la entidad `Client`.
 * Hereda de `JpaRepository`, proporcionando operaciones CRUD básicas.
 */
public interface ClientRepository extends JpaRepository<Client, Long> {
    // Métodos CRUD proporcionados automáticamente por JpaRepository.
}
