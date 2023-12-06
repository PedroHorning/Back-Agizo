package br.net.curriculos;

import java.io.Serializable;

public class Curriculo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Adicionais adicionais;
    private Cabecalho cabecalho;
    private Experiencia experiencia;
    private Formacao formacao;
    private Habilidade habilidade;
    private Resumo resumo;

    public Adicionais getAdicionais() {
        return adicionais;
    }

    public void setAdicionais(Adicionais adicionais) {
        this.adicionais = adicionais;
    }

    public Cabecalho getCabecalho() {
        return cabecalho;
    }

    public void setCabecalho(Cabecalho cabecalho) {
        this.cabecalho = cabecalho;
    }

    public Experiencia getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(Experiencia experiencia) {
        this.experiencia = experiencia;
    }

    public Formacao getFormacao() {
        return formacao;
    }

    public void setFormacao(Formacao formacao) {
        this.formacao = formacao;
    }

    public Habilidade getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(Habilidade habilidade) {
        this.habilidade = habilidade;
    }

    public Resumo getResumo() {
        return resumo;
    }

    public void setResumo(Resumo resumo) {
        this.resumo = resumo;
    }
}
