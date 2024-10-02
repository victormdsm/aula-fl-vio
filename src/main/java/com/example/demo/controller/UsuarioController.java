package com.example.demo.controller;

import com.example.demo.entities.Usuario;
import com.example.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/save")
    public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario){
        try {
            return new ResponseEntity<>(usuarioService.save(usuario), HttpStatus.CREATED);
        } catch (Exception e){
            throw new RuntimeException("Erro ao criar o usuario");
        }
    }


}
