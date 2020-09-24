package com.digitalhouse.br.PreDesafio

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    val livraria = Livraria()

    do {
        println("---------- Menu Principal ----------")
        println("Olá! Digite a opção desejada:")
        println("(1) Cadastrar livro")
        println("(2) Cadastrar coleção")
        println("(3) Consultar livro ou coleção")
        println("(4) Efetuar venda")
        println("(0) Sair")
        println("------------------------------------")


        val input = scanner.nextInt()

        when (input) {
            1 -> {
                println("---------- Cadastro de livro ----------")
                println("Digite o código do livro:")
                val codigo = scanner.nextInt()

                println("Digite o título do livro:")
                val titulo = readLine()!!

                println("Digite o autor do livro:")
                val autor = readLine()!!

                println("Digite o ano do livro:")
                val ano = scanner.nextInt()

                println("Digite a quantidade em estoque:")
                val qtdEstoque = scanner.nextInt()

                println("Digite o preco do livro:")
                val preco = scanner.nextDouble()

                val livro = Livro(codigo, titulo, autor, ano, qtdEstoque, preco.toDouble())
                livraria.cadastrarLivro(livro)
            }
            2 -> {
                val listaLivros = mutableListOf<Livro>()
                println("---------- Cadastro de coleção ----------")
                println("Digite o código da coleção:")
                val codigoColecao = scanner.nextInt()

                println("Digite o preço da coleção:")
                val preco = scanner.nextDouble()

                println("Digite a descrição da coleção:")
                val descricao = readLine()!!

                do {
                    println("Digite o código do livro a ser adicionado na coleção:")
                    val codigoLivro = scanner.nextInt()
                    val livro = livraria.consultarLivro(codigoLivro)
                    if (livro != null){
                        listaLivros.add(livro)
                    } else {
                        println("Livro não encontrado")
                    }
                    println("Deseja adicionar mais um livro? (Digite S para sim, N para não)")
                    val resposta = readLine()!!
                } while (resposta == "S" || resposta == "s")

                val colecao = Colecao(codigoColecao, preco, descricao, listaLivros)
                livraria.cadastrarColecao(colecao)

            }
            3 -> {
                println("---------- Consulta de item ou coleção ----------")
                println("Digite L para consultar um livro ou C para uma coleção")
                val resposta = readLine()!!
                if (resposta == "L" || resposta == "l") {
                    println("Digite o código do livro que deseja procurar:")
                    val codLivro = scanner.nextInt()
                    val retorno = livraria.consultarLivro(codLivro)
                    if ( retorno == null) {
                        println("Livro não encontrado!\n")
                    } else {
                        println("Código: ${retorno.codigo} | Título: ${retorno.titulo} | Autor: ${retorno.autor} | Ano de lançamento: ${retorno.anoLancamento} | Quantidade em estoque: ${retorno.qtdEstoque} | Preço: ${retorno.preco}\n")
                    }
                }
                else if (resposta == "C" || resposta == "c") {
                    println("---------- Consulta de coleção ----------")
                    println("Digite o código da coleção que deseja procurar:")
                    val codColecao = scanner.nextInt()
                    val retorno = livraria.consultarColecao(codColecao)

                    if ( retorno == null) {
                        println("Coleção não encontrada!\n")
                    } else {
                        println("Coleção código: ${retorno.codigo} | Preço: ${retorno.preco} | Descricao: ${retorno.descricao}")
                        for (item in retorno.listaLivrosColecao){
                            println("Itens da coleção:")
                            println("Código: ${item.codigo} | Título: ${item.titulo} | Autor: ${item.autor} | Ano de lançamento: ${item.anoLancamento} | Quantidade em estoque: ${item.qtdEstoque} | Preço: ${item.preco}\n")
                        }
                    }
                }
                else {
                    println("Opção inválida. Tente novamente.\n")
                    continue
                }
            }
            4 -> {
                println("---------- Efetuar venda de livro ou coleção ----------")
                println("Digite L para vender um livro ou C para uma coleção")
                val resposta = readLine()!!
                if (resposta == "L" || resposta == "l") {
                    println("---------- Venda de livro ----------")
                    println("Digite o código do livro que deseja vender:")
                    val codLivro = scanner.nextInt()
                    val retorno = livraria.consultarLivro(codLivro)
                    if ( retorno == null) {
                        println("Livro não encontrado!\n")
                    } else {
                        val venda = livraria.vendaLivro(codLivro)
                        if (venda){
                            println("Venda efetuada com sucesso!\n")
                        } else {
                            println("Estoque esgotado!\n")
                        }
                    }
                }
                else if (resposta == "C" || resposta == "c") {
                    println("---------- Venda de coleção ----------")
                    println("Digite o código da coleção que deseja vender:")
                    val codColecao = scanner.nextInt()
                    val retorno = livraria.consultarColecao(codColecao)

                    if ( retorno == null) {
                        println("Coleção não encontrada!\n")
                    } else {
                        TODO("venda coleção")
                    }
                }
                else {
                    println("Opção inválida. Tente novamente.\n")
                    continue
                }
            }
            0 -> {
                println("Encerrando...")
            }
            else -> println("Opção inválida. Tente novamente.\n")
        }


    } while (input != 0)
}