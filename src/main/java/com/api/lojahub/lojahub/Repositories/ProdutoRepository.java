package com.api.lojahub.lojahub.Repositories;

import com.api.lojahub.lojahub.Models.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, UUID> {
}
