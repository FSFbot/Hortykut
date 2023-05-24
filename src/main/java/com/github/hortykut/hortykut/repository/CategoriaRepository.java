package com.github.hortykut.hortykut.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.github.hortykut.hortykut.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}