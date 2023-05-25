package com.github.hortikut.hortikut.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.hortikut.hortikut.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
