package br.net.curriculos;

import jakarta.persistence.Column;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "experiencia")
public class Experiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "local")
    private String local;

    @Column(name = "cargo")
    private String cargo;

    @Column(name = "datainicio")
    @JsonProperty("datainicio")
    private LocalDate datainicio;

    @Column(name = "datafim")
    @JsonProperty("datafim")
    private LocalDate datafim;

    @Column(name = "descricao")
    private String descricao;
    
    @Column(name = "idusuario")
    private Integer idusuario;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public LocalDate getDataInicio() {
        return datainicio;
    }

    public void setDataInicio(LocalDate datainicio) {
        this.datainicio = datainicio;
    }

    public LocalDate getDataFim() {
        return datafim;
    }

    public void setDataFim(LocalDate datafim) {
        this.datafim = datafim;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }
}
