package com.api.lojahub.lojahub.Controllers;

import com.api.lojahub.lojahub.Dtos.LojaDto;
import com.api.lojahub.lojahub.Models.LojaModel;
import com.api.lojahub.lojahub.Services.LojaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/loja")
public class LojaController {

    private LojaService lojaService;
    public LojaController(LojaService lojaService) {
        this.lojaService = lojaService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> Cadastrar(
            @RequestBody @Valid LojaDto lojaDto)
    {
        LojaModel loja = lojaService.cadastrar(lojaDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(loja);
    }

    @PutMapping("/{id}")
    public LojaModel Atualizar(
            @PathVariable(value = "id") UUID id,
            @RequestBody @Valid LojaDto lojaDto)
    {
        return lojaService.atualizar(id, lojaDto);
    }

    @DeleteMapping
    public String Excluir(@PathVariable(value = "id") UUID id){
        return  lojaService.excluir(id);
    }

    @GetMapping
    public List<LojaModel> listar(){
        return lojaService.listar();
    }

    @GetMapping("/{id}")
    public LojaModel buscarPorId(@PathVariable(value = "id") UUID id){
        return lojaService.BuscarPorId(id);
    }
}
