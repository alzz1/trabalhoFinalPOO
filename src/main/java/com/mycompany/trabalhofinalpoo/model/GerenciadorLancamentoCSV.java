/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhofinalpoo.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anamo
 */
public class GerenciadorLancamentoCSV {
    
     
    public void salvarLancamento(Lancamento lancamento){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("lancamento.csv", true))){
            String tipo = lancamento.isReceita() ? "Receita" : "Despesa";
            writer.write(lancamento.getId() + "," + tipo + "," + lancamento.getValor() + "," +
                     lancamento.getDescricao() + "," + lancamento.getCategoria() + "," +
                     lancamento.getDataHora());
        writer.newLine();
        } catch (IOException e) {
               e.printStackTrace();
        }
    }
    
    public class carregarLancamento{
       private static final String CAMINHO_ARQUIVO = "lancamentos.csv";

        
        public List<Lancamento> carregarLancamentos(){
            List<Lancamento> lista = new ArrayList<>();
            
            try  (BufferedReader leitor = new BufferedReader(new FileReader(CAMINHO_ARQUIVO))){
                String linha;
                while ((linha = leitor.readLine()) != null) {
                   String[] parte = linha.split(";");
                    if (parte.length == 6) {
                        int id = Integer.parseInt(parte[0]);
                        double valor = Double.parseDouble(parte[1]);
                        String descricao = parte[2];
                        String categoria = parte[3];
                        String dataHora = parte[4];
                        String tipo = parte[5];
                        
                        Lancamento lancamento;
                        
                        if (tipo.equalsIgnoreCase("RECEITA")) {
                            lancamento = new Receita(id, valor, descricao, categoria, dataHora);
                        }//segundo if
                        else{
                            lancamento = new Despesas(id, valor, descricao, categoria, dataHora);
                        }//else
                        
                        lista.add(lancamento);
                        
                    } //if
                   
                } //while
            } //try 
            catch (Exception e) {
                System.out.println("Erro ao carregar lançamentos: " + e.getMessage());
            }//catch
            
            return lista;
        }  //metodo carregarLancamento list
    } //metodo carregarLancamento
} // principal
