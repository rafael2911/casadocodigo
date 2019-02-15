package br.com.alura.spring.casadocodigo.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class Produto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 50)
	@NotBlank
	@Size(min=3, max=50)
	private String titulo;
	
	@Column(nullable = false, length = 200)
	@NotBlank
	@Size(min=10, max=200, message="Campo requerido entre {min} e {max} caracteres")
	private String descricao;
	
	@Column(nullable = false)
	private int paginas;
	
	@Column(nullable = false, name = "data_publicacao")
	@NotNull(message="Campo obrigatório")
	@DateTimeFormat(iso=ISO.DATE)
	private LocalDate dataPublicacao;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoStatus status;
	
	public TipoStatus getStatus() {
		return status;
	}
	public void setStatus(TipoStatus status) {
		this.status = status;
	}
	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}
	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public int getPaginas() {
		return paginas;
	}
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	@Override
	public String toString() {
		return "Produto [id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", paginas=" + paginas
				+ ", dataPublicacao=" + dataPublicacao + ", status=" + status + "]";
	}
	
}
