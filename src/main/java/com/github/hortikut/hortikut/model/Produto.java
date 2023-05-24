package com.github.hortikut.hortikut.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table (name = "tb_produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Este campo é obrigatório")
    private String Conexao;
    @NotBlank(message = "Este campo é obrigatório")
    private String Mentorias;
    @NotBlank(message = "Este campo é obrigatorio")
    private String Cursos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConexao() {
        return Conexao;
    }

    public void setConexao(String conexao) {
        Conexao = conexao;
    }

    public String getMentorias() {
        return Mentorias;
    }

    public void setMentorias(String mentorias) {
        Mentorias = mentorias;
    }

    public String getCursos() {
        return Cursos;
    }

    public void setCursos(String cursos) {
        Cursos = cursos;
    }

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
}

