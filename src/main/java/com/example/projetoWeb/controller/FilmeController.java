package com.example.projetoWeb.controller;

import com.example.projetoWeb.model.Filme;
import com.example.projetoWeb.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/filmes")
@CrossOrigin
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @PostMapping("/criarFilme")
    public ResponseEntity<Filme> criarFilme(@RequestBody Filme novoFilme) {
        Filme filmeCriado = filmeService.criarFilme(novoFilme);
        return new ResponseEntity<>(filmeCriado, HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<Page<Filme>> listarFilmes(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<Filme> filmes = filmeService.listarTodosPaginado(page, size);
        return ResponseEntity.ok(filmes);
    }

    @GetMapping("/buscarFilme")
    public ResponseEntity<Page<Filme>> buscarFilme(
            @RequestParam String nomeFilme,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<Filme> filmesEncontrados = filmeService.listarPorNomePaginado(nomeFilme, page, size);

        if (!filmesEncontrados.isEmpty()) {
            return ResponseEntity.ok(filmesEncontrados);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

        @GetMapping("/buscarCategoria")
        public ResponseEntity<Page<Filme>> buscarFilmePorGenero(
                @RequestParam String genero,
                @RequestParam(defaultValue = "0") int page,
                @RequestParam(defaultValue = "10") int size) {
            Page<Filme> filmesGenero = filmeService.listarPorGeneroPaginado(genero, page, size);
            return ResponseEntity.ok(filmesGenero);
        }
}