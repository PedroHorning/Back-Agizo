package br.net.curriculos;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "curriculo")
public class Curriculo {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;
  
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonIgnore
    private Usuario id_usuario;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cabecalho", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonIgnore
    private Cabecalho id_cabecalho;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_experiencia", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonIgnore
    private Experiencia id_experiencia;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_formacao", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonIgnore
    private Formacao id_formacao;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_habilidade", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonIgnore
    private Habilidade id_habilidade;
    
    @Column(name = "resumo_profissional")
    private String resumo_profissional;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getIdUsuario() {
        return id_usuario;
    }

    public void setIdUsuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Cabecalho getIdCabecalho() {
        return id_cabecalho;
    }

    public void setIdCabecalho(Cabecalho id_cabecalho) {
        this.id_cabecalho = id_cabecalho;
    }

    public String getResumoProfissional() {
        return resumo_profissional;
    }

    public void setResumoProfissional(String resumo_profissional) {
        this.resumo_profissional = resumo_profissional;
    }

    public Experiencia getIdExperiencia() {
        return id_experiencia;
    }

    public void setIdExperiencia(Experiencia id_experiencia) {
        this.id_experiencia = id_experiencia;
    }

    public Formacao getIdFormacao() {
        return id_formacao;
    }

    public void setIdFormacao(Formacao id_formacao) {
        this.id_formacao = id_formacao;
    }

    public Habilidade getIdHabilidade() {
        return id_habilidade;
    }

    public void setIdHabilidade(Habilidade id_habilidade) {
        this.id_habilidade = id_habilidade;
    }
    
}
