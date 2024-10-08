package br.com.projetos.apiprojetos.model


import jakarta.persistence.*
import java.time.LocalDateTime



data class Projeto(

    var id: Long? = null,
    var titulo: String,
    var descricao: String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    val tarefas: List<Tarefa> = ArrayList(),
    val status: StatusProjeto = StatusProjeto.SEM_TAREFAS
)
