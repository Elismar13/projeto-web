package com.example.projetoWeb.controller;

import com.example.projetoWeb.model.Usuario;
import com.example.projetoWeb.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registrar")
    public ResponseEntity<Usuario> registrarUsuario(@RequestBody Usuario usuario) {
        Usuario novoUsuario = usuarioService.registrarUsuario(usuario);
        return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> fazerLogin(@RequestParam String email, @RequestParam String senha) {
        Optional<Usuario> usuarioOptional = usuarioService.fazerLogin(email, senha);
        return usuarioOptional.map(usuario -> usuario.getSenha().equals(senha) ?
                new ResponseEntity<>("Login bem-sucedido", HttpStatus.OK) :
                new ResponseEntity<>("Credenciais inválidas", HttpStatus.UNAUTHORIZED)).orElseGet(() -> usuarioOptional.map(usuario -> new ResponseEntity<>("Login bem-sucedido", HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>("Credenciais inválidas", HttpStatus.UNAUTHORIZED)));
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Usuario>> buscarTodosUsuarios() {
        List<Usuario> usuarios = usuarioService.buscarTodosUsuarios();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id) {
        Optional<Usuario> usuarioOptional = usuarioService.buscarPorId(id);
        return usuarioOptional.map(usuario -> new ResponseEntity<>(usuario, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}