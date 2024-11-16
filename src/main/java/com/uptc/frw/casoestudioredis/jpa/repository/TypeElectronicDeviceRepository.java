package com.uptc.frw.casoestudioredis.jpa.repository;

import com.uptc.frw.casoestudioredis.jpa.model.TypeElectronicDevice;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio para la entidad `TypeElectronicDevice`.
 * Proporciona operaciones CRUD sobre los tipos de dispositivos electrónicos.
 */
public interface TypeElectronicDeviceRepository extends JpaRepository<TypeElectronicDevice, Long> {
    // Métodos CRUD proporcionados automáticamente por JpaRepository.
}
