package com.example.projetoWeb.repository;

import com.example.projetoWeb.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {
    List<Filme> findByGenero(String genero);
    Filme findByNome(String nome);

}
