package com.github.hortykut.hortykut.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Categoria {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSemente() {
        return Semente;
    }

    public void setSemente(String semente) {
        Semente = semente;
    }

    public String getFrutos() {
        return Frutos;
    }

    public void setFrutos(String frutos) {
        Frutos = frutos;
    }

    @NotBlank(message = "Este campo é obrigatório, por favor coloque uma mensagem")
    private String Semente;

    @NotBlank(message = "Este campo é obrigatório, por favor coloque uma mensagem")
    private String Frutos;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("categoria")
    private List<Produto> produtos;
}