package com.mycompany.trabalhofinalpoo.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A classe {@code GerenciadorLancamentoCSV} é tipo o "guarda-livros" do seu app,
 * mas ele guarda os lançamentos (receitas e despesas) em um arquivo CSV.
 * Pensa nele como o cara que sabe como ler e escrever nesse arquivo,
 * pra você não perder seus dados quando fechar o programa.
 *
 * Ele cuida de salvar um {@link Lancamento} novo e de carregar todos os lançamentos
 * que já estão lá no arquivo. Ah, e também ajuda a descobrir qual vai ser o próximo ID
 * pra um lançamento, pra não dar conflito.
 *
 * @author anamo
 */
public class GerenciadorLancamentoCSV {
    
    /**
     * Define o caminho do arquivo CSV onde os lançamentos serão salvos e lidos.
     * Por padrão, ele vai procurar (ou criar) um arquivo chamado "lancamentos.csv"
     * na mesma pasta onde o programa estiver sendo executado.
     */

    private static final String CAMINHO_ARQUIVO = "lancamentos.csv";
    
    /**
     * Salva um {@link Lancamento} (seja receita ou despesa) no arquivo CSV.
     * Ele adiciona o novo lançamento no final do arquivo, sem apagar o que já existe.
     * Cada lançamento é salvo numa linha nova, separando as informações por vírgula.
     *
     * @param lancamento O objeto {@link Lancamento} que você quer guardar.
     * @see Lancamento#isReceita() Para saber se é uma Receita ou Despesa na hora de salvar o tipo.
     */

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

    /**
     * Carrega todos os lançamentos que estão salvos no arquivo CSV.
     * Ele lê linha por linha do arquivo, transforma cada linha em um objeto {@link Lancamento}
     * ({@link Receita} ou {@link Despesas}, dependendo do tipo salvo)
     * e coloca tudo numa lista.
     *
     * @return Uma {@link List} de objetos {@link Lancamento} com tudo o que estava no arquivo.
     * Se o arquivo não existir ou estiver vazio, retorna uma lista vazia.
     */
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
    
/**
     * Calcula qual deve ser o próximo ID disponível para um novo lançamento.
     * Ele lê todos os lançamentos que já estão salvos, encontra o maior ID usado
     * até agora e retorna esse ID mais um. Isso evita IDs duplicados.
     *
     * @return O próximo ID sequencial que pode ser usado para um novo {@link Lancamento}.
     * Retorna 1 se ainda não houver nenhum lançamento.
     */
    
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
