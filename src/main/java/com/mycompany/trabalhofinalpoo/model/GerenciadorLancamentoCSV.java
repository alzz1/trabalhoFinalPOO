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

    private static final String CAMINHO_ARQUIVO = "lancamentos.csv";

    public void salvarLancamento(Lancamento lancamento) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CAMINHO_ARQUIVO, true))) {
            String tipo = lancamento.isReceita() ? "Receita" : "Despesa";
            writer.write(lancamento.getId() + "," + lancamento.getValor() + "," +
                         lancamento.getDescricao() + "," + lancamento.getCategoria() + "," +
                         lancamento.getDataHora() + "," + tipo);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Lancamento> carregarLancamentos() {
        List<Lancamento> lista = new ArrayList<>();

        try (BufferedReader leitor = new BufferedReader(new FileReader(CAMINHO_ARQUIVO))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                String[] parte = linha.split(",");
                if (parte.length == 6) {
                    int id = Integer.parseInt(parte[0]);
                    double valor = Double.parseDouble(parte[1]);
                    String descricao = parte[2];
                    String categoria = parte[3];
                    String dataHora = parte[4];
                    String tipo = parte[5];

                    Lancamento lancamento;

                    if (tipo.equalsIgnoreCase("Receita")) {
                        lancamento = new Receita(id, valor, descricao, categoria, dataHora);
                    } else {
                        lancamento = new Despesas(id, valor, descricao, categoria, dataHora);
                    }

                    lista.add(lancamento);
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao carregar lançamentos: " + e.getMessage());
        }

        return lista;
    }

    public int getProximoId() {
        List<Lancamento> lista = carregarLancamentos();
        int maiorId = 0;

        for (Lancamento l : lista) {
            if (l.getId() > maiorId) {
                maiorId = l.getId();
            }
        }

        return maiorId + 1;
    }
}
