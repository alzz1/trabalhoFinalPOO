/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhofinalpoo.model;

/**
 * A classe {@code Receita} é pra quando a grana *entra* no seu bolso.
 * Ela "herda" da classe geral {@link Lancamento} e é tipo um {@link Lancamento}
 * só que especializado pra ser uma receita.
 *
 * @author anamo
 */
public class Receita extends Lancamento {
    /**
 * A classe {@code Receita} é pra quando a grana *entra* no seu bolso.
 * Ela "herda" da classe geral {@link Lancamento} e é tipo um {@link Lancamento}
 * só que especializado pra ser uma receita.
 *
 * @author anamo
 */
    public Receita(int id, double valor, String descricao, String categoria, String dataHora) {
    super(id, valor, descricao, categoria, dataHora);
}
     /**
     * Sobrescreve o método {@code isReceita} que veio da classe {@link Lancamento}.
     * Pra um objeto {@code Receita}, esse método *sempre* vai retornar {@code true},
     * porque, né, é uma receita! Grana que entra!
     *
     * @return Sempre retorna {@code true}, confirmando que isso aqui é uma receita.
     */
@Override
public boolean isReceita() {
    return true;
}
}
