/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhofinalpoo.model;

/**
 * A classe {@code Despesas} é pra registrar quando a grana *sai* do seu bolso.
 * Ela também "herda" da classe geral {@link Lancamento}, mas se especializa
 * pra ser um tipo de lançamento que é uma despesa.
 *
 * @author anamo
 */
public class Despesas extends Lancamento{

     /**
     * Cria uma nova transação de {@code Despesas} (saída de dinheiro) com os detalhes que você passar.
     * Assim como na Receita, todos os dados são enviados pro construtor da classe "mãe" ({@link Lancamento})
     * pra serem inicializados e validados. Isso ajuda a manter tudo organizado e correto.
     *
     * @param id O número único pra essa despesa.
     * @param valor A quantia de dinheiro que saiu.
     * @param descricao Uma descrição breve do motivo dessa saída de grana.
     * @param categoria A que grupo essa despesa pertence (tipo "Alimentação", "Transporte").
     * @param dataHora A data e hora em que a despesa rolou.
     * @throws IllegalArgumentException se algum dado não passar nas checagens
     * que tão lá na classe {@link Lancamento} (tipo ID negativo, valor zero/negativo, textos vazios).
     */
    public Despesas(int id, double valor, String descricao, String categoria, String dataHora) {
        super(id, valor, descricao, categoria, dataHora);
    }
 
   /**
     * Sobrescreve o método {@code isReceita} que veio da classe {@link Lancamento}.
     * Pra um objeto {@code Despesas}, esse método *sempre* vai retornar {@code false},
     * porque, afinal, é uma despesa, não uma receita! Grana que sai!
     *
     * @return Sempre retorna {@code false}, confirmando que isso aqui é uma despesa.
     */
    @Override
   public boolean isReceita() {
    return false;
}
}
