package br.com.projetos.apiprojetos.model

import java.time.LocalDateTime

data class Projeto(

    var id: Long? = null,
    val titulo: String,
    val descricao: String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    val tarefas: List<Tarefa> = ArrayList(),
    val status: StatusProjeto = StatusProjeto.SEM_TAREFAS
)
