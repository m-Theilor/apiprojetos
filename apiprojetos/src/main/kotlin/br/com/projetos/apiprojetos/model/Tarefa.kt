package br.com.projetos.apiprojetos.model

import java.time.LocalDateTime

data class Tarefa(

    val id: Long? = null,
    val nome: String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    val status: StatusTarefa = StatusTarefa.NAO_REALIZADA

)