package com.api.lojahub.lojahub.Services;

import com.api.lojahub.lojahub.Dtos.LojaDto;
import com.api.lojahub.lojahub.Models.LojaModel;
import com.api.lojahub.lojahub.Models.ProdutoModel;
import com.api.lojahub.lojahub.Repositories.LojaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LojaService {


    private LojaRepository lojaRepository;

    public LojaService(LojaRepository lojaRepository) {
        this.lojaRepository = lojaRepository;
    }

    public LojaModel cadastrar(LojaDto lojaDto) {

        LojaModel lojaModel = new LojaModel();

        lojaModel.setNome(lojaDto.getNome());
        lojaModel.setCnpj(lojaDto.getCnpj());
        lojaModel.setTelefone(lojaDto.getTelefone());
        lojaModel.setEmail(lojaDto.getEmail());
        lojaModel.setEndereco(lojaDto.getEndereco());

        return lojaRepository.save(lojaModel);
    }

    public LojaModel atualizar(UUID id, LojaDto lojaDto) {
        var lojaModel = lojaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        lojaModel.setNome(lojaDto.getNome());
        lojaModel.setCnpj(lojaDto.getCnpj());
        lojaModel.setTelefone(lojaDto.getTelefone());
        lojaModel.setEmail(lojaDto.getEmail());
        lojaModel.setEndereco(lojaDto.getEndereco());

        return lojaRepository.save(lojaModel);
    }

    public String excluir(UUID id) {
        var lojaModel = lojaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto encontrado"));
        lojaRepository.delete(lojaModel);

        return "Produto excluido com sucesso";
    }

    public List<LojaModel> listar() {
        return lojaRepository.findAll();
    }

    public LojaModel BuscarPorId (UUID id) {
        var lojaModel = lojaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto encontrado"));

        return lojaModel;
    }
}
