/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhofinalpoo.model;

/**
 *
 * @author anamo
 */
public abstract class Lancamento {
    protected int id;
    protected double valor;
    protected String descricao;
    protected String categoria;
    protected String dataHora;

    public Lancamento(int id, double valor, String descricao, String categoria, String dataHora) {
        setId (id);
        setValor (valor);
        setDescricao (descricao);
        setCategoria (categoria);
        setDataHora (dataHora);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("Campo ID inválido");
        }
        this.id = id;
    }

    
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Campo VALOR inválido");
        }    this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
       if (descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("Campo DESCRIÇÃO inválido");
        }
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        if (categoria.trim().isEmpty()) {
            throw new IllegalArgumentException("Campo CATEGORIA inválido");
        }
        this.categoria = categoria;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
      if (dataHora.trim().isEmpty()) {
            throw new IllegalArgumentException("Campo DATA E HORA inválido");
        }
        this.dataHora = dataHora;
    }
    
    
      public abstract boolean isReceita();
}
