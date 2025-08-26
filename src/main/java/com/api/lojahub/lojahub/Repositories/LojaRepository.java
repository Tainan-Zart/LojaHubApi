package com.api.lojahub.lojahub.Repositories;

import com.api.lojahub.lojahub.Models.LojaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LojaRepository extends JpaRepository<LojaModel, UUID> {
}
