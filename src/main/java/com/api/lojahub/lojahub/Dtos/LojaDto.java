package com.api.lojahub.lojahub.Dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LojaDto {

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @NotBlank(message = "O cnpj é obrigatório")
    private String cnpj;

    @NotBlank(message = "O telefone é obrigatório")
    private String telefone;

    @NotBlank(message = "O email é obrigatório")
    private String email;

    @NotBlank(message = "O endereço é obrigatório")
    private String endereco;

}
