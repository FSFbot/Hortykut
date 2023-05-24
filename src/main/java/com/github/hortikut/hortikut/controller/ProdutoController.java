package com.github.hortikut.hortikut.controller;

import com.github.hortikut.hortikut.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ProdutoRepository produtoRepository ;
    @GetMapping
    public List<com.hortykut.hortykut.model.Produto> listarUsuarios() {
        return produtoRepository.findAll();
    }
    @GetMapping("/{id}")
    public Optional<com.hortykut.hortykut.model.Produto> buscarProdutoPorId(@PathVariable Long id) {
      return produtoRepository.findById(id);
    }
    @PostMapping
    public com.hortykut.hortykut.model.Produto criarProduto(@RequestBody com.hortykut.hortykut.model.Produto produto){
        return produtoRepository.save(produto);
    }
    @PutMapping("/{id}")
    public com.hortykut.hortykut.model.Produto atualizarProduto(@PathVariable Long id, @RequestBody com.hortykut.hortykut.model.Produto produtoAtualizado) {
        Optional<com.hortykut.hortykut.model.Produto> produtoExistente = produtoRepository.findById(id);

        if (produtoExistente.isPresent()) {
            com.hortykut.hortykut.model.Produto produto = produtoExistente.get();
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
