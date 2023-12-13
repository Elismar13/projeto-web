package com.example.projetoWeb.service;

import com.example.projetoWeb.model.Filme;
import com.example.projetoWeb.repository.FilmeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FilmeService {

    private final FilmeRepository filmeRepository;

    public FilmeService(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    public Page<Filme> listarTodosPaginado(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return filmeRepository.findAll(pageable);
    }

    public Page<Filme> listarPorGeneroPaginado(String genero, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return filmeRepository.findByGenero(genero, pageable);
    }

    public Page<Filme> listarPorNomePaginado(String nome, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return filmeRepository.findByTituloContaining(nome, pageable);
    }
}