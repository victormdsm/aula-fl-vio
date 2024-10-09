package com.example.demo.service;

import com.example.demo.entities.Usuario;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public Usuario save(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    @Transactional(readOnly = true)
    public Usuario findById(Long id){
        var user = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException());
        return user;
    }

    @Transactional(readOnly = true)
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Transactional
    public Usuario update(Long id, Usuario atualizar) {

        var user =  findById(id);

        if (!atualizar.getNome().isBlank() && atualizar.getNome() != null){
            user.setNome(atualizar.getNome());
        }
        if (atualizar.getIdade() != null){
            user.setIdade(atualizar.getIdade());
        }
        return usuarioRepository.save(user);
    }

    @Transactional
    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }



}
