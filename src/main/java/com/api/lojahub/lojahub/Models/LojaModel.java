package com.api.lojahub.lojahub.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "loja")
public class LojaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String nome;

    private String cnpj;

    private String telefone;

    private String email;

    private String endereco;
}
