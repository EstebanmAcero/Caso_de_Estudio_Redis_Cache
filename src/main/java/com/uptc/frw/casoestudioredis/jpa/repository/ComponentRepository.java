package com.uptc.frw.casoestudioredis.jpa.repository;

import com.uptc.frw.casoestudioredis.jpa.model.Component;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComponentRepository extends JpaRepository<Component, Long> {
}
