package com.github.hortykut.hortykut.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.github.hortykut.hortykut.model.Produto;
import com.github.hortykut.hortykut.repository.ProdutoRepository;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
	
    @Autowired
    private ProdutoRepository produtoRepository ;
    
    @GetMapping
    public List<Produto> listarUsuarios() {
        return produtoRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Produto> buscarProdutoPorId(@PathVariable Long id) {
      return produtoRepository.findById(id);
    }
    
    @PostMapping
    public Produto criarProduto(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }
    
    @PutMapping("/{id}")
    public Produto atualizarProduto(@PathVariable Long id, @RequestBody Produto produtoAtualizado) {
        Optional<Produto> produtoExistente = produtoRepository.findById(id);
        if (produtoExistente.isPresent()) {
            Produto produto = produtoExistente.get();
            produto.setConexao(produtoAtualizado.getConexao());
            produto.setMentorias(produtoAtualizado.getMentorias());
            produto.setCursos(produtoAtualizado.getCursos());
            return produtoRepository.save(produto);
        } else {
            throw new IllegalArgumentException("ID do usuário inválido: " + id);
        }
    }
    
    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable Long id) {
        produtoRepository.deleteById(id);
    }
}