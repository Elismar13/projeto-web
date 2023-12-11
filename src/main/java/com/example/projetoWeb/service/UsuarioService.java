package com.example.projetoWeb.service;

import com.example.projetoWeb.model.Usuario;
import com.example.projetoWeb.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public Usuario registrarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> fazerLogin(String email, String senha) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findByEmail(email);
        return usuarioOptional
                .filter(usuario -> usuario.getSenha().equals(senha))
                .map(Optional::of)
                .orElse(Optional.empty());
    }

    public List<Usuario> buscarTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }
}