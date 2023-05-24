package com.github.hortikut.hortikut.controller;

import com.github.hortikut.hortikut.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public List<com.hortykut.hortykut.model.Categoria> listaCategorias(){
        return categoriaRepository.findAll();
    }
    @GetMapping("/{id}")
    public Optional<com.hortykut.hortykut.model.Categoria> buscarCategoriaPorId(@PathVariable Long id){
        return categoriaRepository.findById(id);
    }
    @PostMapping
    public com.hortykut.hortykut.model.Categoria criarCategoria(@RequestBody com.hortykut.hortykut.model.Categoria categoria){
        return categoriaRepository.save(categoria);
    }
    @PutMapping("/{id}")
    public com.hortykut.hortykut.model.Categoria atualizarCategoria(@PathVariable Long id, @RequestBody com.hortykut.hortykut.model.Categoria categoriaAtualizada) {
        Optional<com.hortykut.hortykut.model.Categoria> categoriaExistente = categoriaRepository.findById(id);

        if(categoriaExistente.isPresent()) {
            com.hortykut.hortykut.model.Categoria categoria = categoriaExistente.get();
            categoria.setSemente(categoriaAtualizada.getSemente());
            return categoriaRepository.save(categoria);
        } else {
            throw new IllegalArgumentException("ID da categoria inválido: " + id);
        }
    }
    @DeleteMapping("/{id}")
    public void deletarCategoria(@PathVariable Long id) {
        categoriaRepository.deleteById(id);
    }
}
