package br.com.projetos.apiprojetos.service

import br.com.projetos.apiprojetos.model.Projeto
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProjetoService(private var projetos: List<Projeto>) {

    init {
        val projeto1 = Projeto(
            id = 1,
            titulo = "Projeto Exemplo1",
            descricao = "Projeto modelo",
        )

        val projeto2 = Projeto(
            id = 2,
            titulo = "Projeto Exemplo2",
            descricao = "Projeto modelo",
        )

        val projeto3 = Projeto(
            id = 3,
            titulo = "Projeto Exemplo3",
            descricao = "Projeto modelo",
        )
        projetos =  Arrays.asList(projeto1, projeto2, projeto3)
    }

    fun listar(): List<Projeto> {
        return projetos
    }

    fun buscarPorId(id: Long): Projeto {
        return projetos.stream().filter({
            p -> p.id == id
        }).findFirst().get()
    }
}