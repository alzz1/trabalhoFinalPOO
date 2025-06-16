/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package com.mycompany.trabalhofinalpoo.model;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.testng.Assert.*;

/**
 *
 * @author mathe
 */
public class LancamentoNGTest {
    private static class ConcreteLancamento extends Lancamento {
        public ConcreteLancamento(int id, double valor, String descricao, String categoria, String dataHora) {
            super(id, valor, descricao, categoria, dataHora);
        }

        @Override
        public boolean isReceita() {
            return false;
        }
    }


    @Test
    void testConstructorValidArguments() {
        ConcreteLancamento lancamento = new ConcreteLancamento(1, 100.0, "Salário", "Renda", "2024-06-15");
        assertNotNull(lancamento);
        assertEquals(1, lancamento.getId());
        assertEquals(100.0, lancamento.getValor());
        assertEquals("Salário", lancamento.getDescricao());
        assertEquals("Renda", lancamento.getCategoria());
        assertEquals("2024-06-15", lancamento.getDataHora());
    }


    @Test
    void testSetIdValid() {
        ConcreteLancamento lancamento = new ConcreteLancamento(1, 10.0, "Desc", "Cat", "Date");
        lancamento.setId(5);
        assertEquals(5, lancamento.getId());
    }

    @Test
    void testSetIdInvalidNegative() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new ConcreteLancamento(1, 10.0, "Desc", "Cat", "Date").setId(-1);
        });
        assertEquals("Campo ID inválido", exception.getMessage());
    }



    @Test
    void testSetValorValidPositive() {
        ConcreteLancamento lancamento = new ConcreteLancamento(1, 10.0, "Desc", "Cat", "Date");
        lancamento.setValor(200.50);
        assertEquals(200.50, lancamento.getValor());
    }

    @Test
    void testSetValorInvalidZero() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new ConcreteLancamento(1, 10.0, "Desc", "Cat", "Date").setValor(0.0);
        });
        assertEquals("Campo VALOR inválido", exception.getMessage());
    }

    @Test
    void testSetValorInvalidNegative() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new ConcreteLancamento(1, 10.0, "Desc", "Cat", "Date").setValor(-50.0);
        });
        assertEquals("Campo VALOR inválido", exception.getMessage());
    }



    @Test
    void testSetDescricaoValid() {
        ConcreteLancamento lancamento = new ConcreteLancamento(1, 10.0, "Desc", "Cat", "Date");
        lancamento.setDescricao("Nova Descrição");
        assertEquals("Nova Descrição", lancamento.getDescricao());
    }

    @Test
    void testSetDescricaoInvalidEmpty() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new ConcreteLancamento(1, 10.0, "Desc", "Cat", "Date").setDescricao("");
        });
        assertEquals("Campo DESCRIÇÃO inválido", exception.getMessage());
    }

    @Test
    void testSetDescricaoInvalidBlank() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new ConcreteLancamento(1, 10.0, "Desc", "Cat", "Date").setDescricao("   ");
        });
        assertEquals("Campo DESCRIÇÃO inválido", exception.getMessage());
    }


    @Test
    void testSetCategoriaValid() {
        ConcreteLancamento lancamento = new ConcreteLancamento(1, 10.0, "Desc", "Cat", "Date");
        lancamento.setCategoria("Nova Categoria");
        assertEquals("Nova Categoria", lancamento.getCategoria());
    }

    @Test
    void testSetCategoriaInvalidEmpty() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new ConcreteLancamento(1, 10.0, "Desc", "Cat", "Date").setCategoria("");
        });
        assertEquals("Campo CATEGORIA inválido", exception.getMessage());
    }

    @Test
    void testSetCategoriaInvalidBlank() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new ConcreteLancamento(1, 10.0, "Desc", "Cat", "Date").setCategoria("   ");
        });
        assertEquals("Campo CATEGORIA inválido", exception.getMessage());
    }


    @Test
    void testSetDataHoraValid() {
        ConcreteLancamento lancamento = new ConcreteLancamento(1, 10.0, "Desc", "Cat", "Date");
        lancamento.setDataHora("2025-01-01 10:30");
        assertEquals("2025-01-01 10:30", lancamento.getDataHora());
    }

    @Test
    void testSetDataHoraInvalidEmpty() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new ConcreteLancamento(1, 10.0, "Desc", "Cat", "Date").setDataHora("");
        });
        assertEquals("Campo DATA E HORA inválido", exception.getMessage());
    }

    @Test
    void testSetDataHoraInvalidBlank() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new ConcreteLancamento(1, 10.0, "Desc", "Cat", "Date").setDataHora("   ");
        });
        assertEquals("Campo DATA E HORA inválido", exception.getMessage());
    }
}
    

