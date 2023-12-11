package com.example.projetoWeb.controller;

import com.example.projetoWeb.model.Filme;
import com.example.projetoWeb.service.FilmeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FilmeController {

    private FilmeService filmeService;

    @GetMapping("/listar")
    public ResponseEntity<List<Filme>> listarFilmes(){
        List<Filme> filmes = filmeService.listarTodos();
        return ResponseEntity.ok(filmes);
    }

    @GetMapping("/buscarFilme")
    public ResponseEntity<Filme> buscarFilme(@RequestParam String nomeFilme){
        Filme filmeBuscado = filmeService.listarPorNome(nomeFilme);
        return ResponseEntity.ok(filmeBuscado);
    }


    @GetMapping("/buscarCategoria")
    public ResponseEntity<List<Filme>> buscarFilmePorGenero(@RequestParam String genero){
        List<Filme> filmesGenero = filmeService.listarPorGenero(genero);
        return ResponseEntity.ok(filmesGenero);
    }



}
