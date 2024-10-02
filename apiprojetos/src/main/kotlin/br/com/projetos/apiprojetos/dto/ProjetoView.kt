package br.com.projetos.apiprojetos.dto

import br.com.projetos.apiprojetos.model.StatusProjeto
import java.time.LocalDateTime

data class ProjetoView(
    val id : Long?,
    val titulo: String,
    val descricao:String,
    val status: StatusProjeto,
    val dataCriacao: LocalDateTime
)