package com.uptc.frw.casoestudioredis.jpa.repository;

import com.uptc.frw.casoestudioredis.jpa.model.DeviceDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio para la entidad `DeviceDetail`.
 * Extiende JpaRepository para proporcionar operaciones CRUD sobre los detalles de los dispositivos.
 */
public interface DeviceDetailRepository extends JpaRepository<DeviceDetail, Long> {
    // Métodos CRUD proporcionados automáticamente por JpaRepository.
}
