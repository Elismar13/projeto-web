package com.example.projetoWeb.service;

import com.example.projetoWeb.model.Filme;
import com.example.projetoWeb.repository.FilmeRepository;

import java.util.List;

public class FilmeService {

    private FilmeRepository filmeRepository;

    public List<Filme> listarTodos(){
        return filmeRepository.findAll();
    }

    public List<Filme> listarPorGenero(String genero){
        return filmeRepository.findByGenero(genero);
    }

    public Filme listarPorNome(String nome){
        return filmeRepository.findByNome(nome);
    }

}
