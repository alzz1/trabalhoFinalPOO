/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhofinalpoo.model;

/**
 *
 * @author anamo
 */
public class Despesas extends Lancamento{

    public Despesas(int id, double valor, String descricao, String categoria, String dataHora) {
        super(id, valor, descricao, categoria, dataHora);
    }
 
   @Override
   public boolean isReceita() {
    return false;
}
}
