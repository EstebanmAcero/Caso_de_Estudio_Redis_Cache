package com.uptc.frw.casoestudioredis.jpa.repository;

import com.uptc.frw.casoestudioredis.jpa.model.ElectronicDevice;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio para la entidad `ElectronicDevice`.
 * Proporciona operaciones CRUD sobre dispositivos electrónicos.
 */
public interface ElectronicDeviceRepository extends JpaRepository<ElectronicDevice, Long> {
    // Métodos CRUD proporcionados automáticamente por JpaRepository.
}
