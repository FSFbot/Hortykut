package com.github.hortykut.hortykut.repository;

import com.hortykut.hortykut.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}