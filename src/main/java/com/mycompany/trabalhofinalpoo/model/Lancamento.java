/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhofinalpoo.model;

/**
 * A classe abstrata {@code Lancamento} é tipo que representa qualquer transação financeira.
 * Pensa nela como a base para outras classes mais específicas, tipo {@link Receita} (grana que entra)
 * e {@link Despesas} (grana que sai).
 *
 * Ela guarda as informações básicas que todo lançamento tem: ID, valor, o que é (descrição),
 * a que categoria pertence e quando aconteceu.
 * Ah, e já faz umas validações básicas pra não entrar dado errado, tá?
 *
 * @author anamo
 */
public abstract class Lancamento {
    protected int id;
    protected double valor;
    protected String descricao;
    protected String categoria;
    protected String dataHora;
    
    /**
     * Cria um novo {@code Lancamento} com todos os detalhes.
     * Os dados que você passa aqui já são checados pelos métodos "set", então fica tranquilo.
     *
     * @param id Um número único pra identificar o lançamento. Não pode ser negativo, beleza?
     * @param valor A quantia de dinheiro envolvida. Tem que ser um valor positivo.
     * @param descricao Uma pequena frase pra dizer o que foi o lançamento. Não pode ficar em branco.
     * @param categoria A qual grupo essa transação pertence (tipo "Comida", "Salário"). Também não pode ficar em branco.
     * @param dataHora A data e a hora exatas em que rolou a transação (ex: "2024-06-15 10:30"). Sem deixar em branco!
     * @throws IllegalArgumentException Se algum dado estiver errado (tipo ID negativo, valor zero/negativo, ou textos vazios), ele avisa.
     */

    public Lancamento(int id, double valor, String descricao, String categoria, String dataHora) {
        setId (id);
        setValor (valor);
        setDescricao (descricao);
        setCategoria (categoria);
        setDataHora (dataHora);
    }

        /**
     * Pega o ID único do lançamento.
     * @return O ID do lançamento.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o ID do lançamento.
     * @param id O ID pra colocar. Lembre-se, não pode ser negativo.
     * @throws IllegalArgumentException Se o ID for negativo, dá erro.
     */
    public void setId(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("Campo ID inválido");
        }
        this.id = id;
    }

     /**
     * Pega o valor monetário do lançamento.
     * @return O valor do lançamento.
     */
    public double getValor() {
        return valor;
    }

     /**
     * Define o valor monetário do lançamento.
     * @param valor O valor pra colocar. Tem que ser positivo!
     * @throws IllegalArgumentException Se o valor for zero ou negativo, dá erro.
     */
    public void setValor(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Campo VALOR inválido");
        }    this.valor = valor;
    }

     /**
     * Pega a descrição do lançamento.
     * @return A descrição do lançamento.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Define a descrição do lançamento.
     * @param descricao A descrição pra colocar. Não pode ser vazia ou só com espaços, hein?
     * @throws IllegalArgumentException Se a descrição for vazia ou em branco, dá erro.
     */
    public void setDescricao(String descricao) {
       if (descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("Campo DESCRIÇÃO inválido");
        }
        this.descricao = descricao;
    }

    /**
     * Pega a categoria do lançamento.
     * @return A categoria do lançamento.
     */
    public String getCategoria() {
        return categoria;
    }

     /**
     * Define a categoria do lançamento.
     * @param categoria A categoria pra colocar. Não pode ser vazia ou só com espaços.
     * @throws IllegalArgumentException Se a categoria for vazia ou em branco, dá erro.
     */
    public void setCategoria(String categoria) {
        if (categoria.trim().isEmpty()) {
            throw new IllegalArgumentException("Campo CATEGORIA inválido");
        }
        this.categoria = categoria;
    }
/**
     * Pega a data e hora do lançamento.
     * @return A string com a data e hora do lançamento.
     */
    public String getDataHora() {
        return dataHora;
    }

     /**
     * Define a data e hora do lançamento.
     * @param dataHora A string de data e hora pra colocar. Não pode ser vazia ou só com espaços.
     * @throws IllegalArgumentException Se a string de data e hora for vazia ou em branco, dá erro.
     */
    public void setDataHora(String dataHora) {
      if (dataHora.trim().isEmpty()) {
            throw new IllegalArgumentException("Campo DATA E HORA inválido");
        }
        this.dataHora = dataHora;
    }
    
    /**
     * Esse método abstrato diz se o lançamento é uma entrada (Receita) ou não.
     * As classes que herdam de {@link Lancamento} (tipo {@link Receita} e {@link Despesas})
     * precisam dizer exatamente como isso funciona pra elas.
     * @return {@code true} se for uma receita, {@code false} se não for.
     */
    
      public abstract boolean isReceita();
}
