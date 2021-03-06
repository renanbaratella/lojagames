package com.generation.lojagames.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_produtos")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "O atributo é obrigatório")
	@Size(min = 5, max = 50)
	private String titulo;

	@Size(min = 10, max = 1000, message = "O atributo deve conter entre 10 e 1000 caracteres")
	private String descricao;

	private Double preco;

	private Integer qtd;

	private String plataforma;

	private LocalDate data_lancamento;

	private Integer classificacao_indicativa;

	private Integer espaco_hd;

	private boolean disp;

	private String foto;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JsonIgnoreProperties("produto")
	private Categoria categoria;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JsonIgnoreProperties("produto")
	private Usuario usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public LocalDate getData_lancamento() {
		return data_lancamento;
	}

	public void setData_lancamento(LocalDate data_lancamento) {
		this.data_lancamento = data_lancamento;
	}

	public Integer getClassificacao_indicativa() {
		return classificacao_indicativa;
	}

	public void setClassificacao_indicativa(Integer classificacao_indicativa) {
		this.classificacao_indicativa = classificacao_indicativa;
	}

	public Integer getEspaco_hd() {
		return espaco_hd;
	}

	public void setEspaco_hd(Integer espaco_hd) {
		this.espaco_hd = espaco_hd;
	}

	public boolean isDisp() {
		return disp;
	}

	public void setDisp(boolean disp) {
		this.disp = disp;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
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

	@Override
	public String toString() {
		return "Produto [id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", preco=" + preco + ", qtd="
				+ qtd + ", plataforma=" + plataforma + ", data_lancamento=" + data_lancamento
				+ ", classificacao_indicativa=" + classificacao_indicativa + ", espaco_hd=" + espaco_hd + ", disp="
				+ disp + ", foto=" + foto + ", categoria=" + categoria + ", usuario=" + usuario + "]";
	}

}
