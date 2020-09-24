package com.digitalhouse.br.PreDesafio

import com.sun.org.apache.xpath.internal.operations.Bool

class Livraria {
    var listaLivros = mutableListOf<Livro>()
    var listaColecoes = mutableListOf<Colecao>()

    fun cadastrarLivro(livro: Livro){
        listaLivros.add(livro)
        println("Livro cadastrado com sucesso!\n")
    }

    fun cadastrarColecao(colecao: Colecao){
        listaColecoes.add(colecao)
        println("Coleção cadastrada com sucesso!\n")
    }

    fun consultarLivro(codigo: Int) : Livro? {
        for (livro in listaLivros){
            if (livro.codigo == codigo){
                return livro
            }
        }
        return null
    }

    fun consultarColecao(codigo: Int) : Colecao? {
        for (colecao in listaColecoes){
            if (colecao.codigo == codigo){
                return colecao
            }
        }
        return null
    }

    fun vendaLivro(codigo: Int) : Boolean {
        for (livro in listaLivros){
            if (livro.codigo == codigo && livro.qtdEstoque - 1 >= 0){
                livro.qtdEstoque--
                return true
            }
        }
        return false
    }

    fun vendaColecao(codigo: Int) : Boolean {
        TODO("fazer a venda da coleção")
    }
}