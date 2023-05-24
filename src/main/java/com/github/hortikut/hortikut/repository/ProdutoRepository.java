package com.github.hortikut.hortikut.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.github.hortikut.hortikut.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
