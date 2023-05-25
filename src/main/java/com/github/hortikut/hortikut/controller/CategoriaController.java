package com.github.hortikut.hortikut.controller;

import com.github.hortikut.hortikut.model.Categoria;
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
            categoria.setDescricao(categoriaAtualizada.getDescricao());
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
