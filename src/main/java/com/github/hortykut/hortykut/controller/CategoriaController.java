package com.github.hortykut.hortykut.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.github.hortykut.hortykut.model.Categoria;
import com.github.hortykut.hortykut.repository.CategoriaRepository;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	
    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public List<Categoria> listaCategorias(){
        return categoriaRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Categoria> buscarCategoriaPorId(@PathVariable Long id){
        return categoriaRepository.findById(id);
    }
    
    @PostMapping
    public Categoria criarCategoria(@RequestBody Categoria categoria){
        return categoriaRepository.save(categoria);
    }
    
    @PutMapping("/{id}")
    public Categoria atualizarCategoria(@PathVariable Long id, @RequestBody Categoria categoriaAtualizada) {
        Optional<Categoria> categoriaExistente = categoriaRepository.findById(id);

        if(categoriaExistente.isPresent()) {
            Categoria categoria = categoriaExistente.get();
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