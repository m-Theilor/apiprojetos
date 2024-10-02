package br.com.projetos.apiprojetos.service

import br.com.projetos.apiprojetos.dto.NovoProjetoForm
import br.com.projetos.apiprojetos.dto.ProjetoView
import br.com.projetos.apiprojetos.model.Projeto
import org.springframework.stereotype.Service
import java.util.stream.Collectors
import kotlin.collections.ArrayList

@Service
class ProjetoService(private var projetos: List<Projeto> = ArrayList()) {

    fun listar(): List<ProjetoView> {
        return projetos.stream().map { p -> ProjetoView(
            id = p.id,
            titulo = p.titulo,
            descricao = p.descricao,
            status = p.status,
            dataCriacao = p.dataCriacao
        )}.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): ProjetoView {
        val projeto = projetos.stream().filter{
            p -> p.id == id
        }.findFirst().get()
        return ProjetoView(
                id = projeto.id,
                titulo = projeto.titulo,
                descricao = projeto.descricao,
                status = projeto.status,
                dataCriacao = projeto.dataCriacao
        )
    }

    fun cadastrar(dto: NovoProjetoForm) {
        projetos = projetos.plus(Projeto(
            id = projetos.size.toLong() + 1,
            titulo = dto.titulo,
            descricao = dto.descricao
        ))
    }
}