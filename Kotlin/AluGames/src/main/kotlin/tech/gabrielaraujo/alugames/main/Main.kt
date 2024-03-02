package tech.gabrielaraujo.alugames.main

import com.google.gson.Gson
import tech.gabrielaraujo.alugames.model.InfoJogo
import tech.gabrielaraujo.alugames.model.Jogo
import tech.gabrielaraujo.alugames.services.ConsumoApi
import java.util.*

fun main() {

    println("Digite um código de jogo para buscar")
    val busca = readlnOrNull();

    val endereco = "https://www.cheapshark.com/api/1.0/games?id=$busca"
    val consumoApi = ConsumoApi()
    val gson = Gson()

    var meuJogo: Jogo? = null;

    var resultado = runCatching {
        val meuInfoJogo = gson.fromJson(consumoApi.consumoApi(endereco), InfoJogo::class.java)
        meuJogo = Jogo(meuInfoJogo.info.title, meuInfoJogo.info.thumb)
    }

    resultado.onFailure {
        println("Jogo inválido, tente outro...")
    }

    resultado.onSuccess {
        println("Deseja inserir uma descrição personalizada? S/N ")
        var opcao = readlnOrNull();
        if (opcao.equals("s", true)){
            println("Digite a sua descrição personalizada: ")
            var descricao = readlnOrNull();
            meuJogo?.descricao = descricao
        } else if ((opcao.equals("n", true))){
            println("Nenhuma descrição definida")
            meuJogo?.descricao = meuJogo?.titulo
        }
    }

    resultado.onSuccess {
        println(meuJogo)
        println("Finalizado")
    }
}