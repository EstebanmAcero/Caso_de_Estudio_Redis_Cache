package com.uptc.frw.casoestudioredis.jpa.repository;

import com.uptc.frw.casoestudioredis.jpa.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
