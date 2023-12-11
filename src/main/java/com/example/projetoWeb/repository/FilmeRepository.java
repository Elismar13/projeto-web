package com.example.projetoWeb.repository;

import com.example.projetoWeb.model.Filme;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {
    Page<Filme> findByGenero(String genero, Pageable pageable);
    Page<Filme> findByNome(String nome, Pageable pageable);
}
