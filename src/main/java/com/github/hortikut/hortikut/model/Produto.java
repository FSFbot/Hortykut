package com.github.hortikut.hortikut.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_produto")
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
    
    public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	@ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
    
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}

