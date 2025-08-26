package com.api.lojahub.lojahub.Handlers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidation(
            MethodArgumentNotValidException ex
    ) {
        var error = ex.getAllErrors().stream()
                .map(fe -> Map.of("mensagem", fe.getDefaultMessage())).toList();

        var body = Map.of(
                "status", 400,
                "erro", "Requisição inválida",
                "errors", error
        );

        return ResponseEntity.badRequest().body(body);
    }
}