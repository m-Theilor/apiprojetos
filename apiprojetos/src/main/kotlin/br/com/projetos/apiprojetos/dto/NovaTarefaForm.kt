package br.com.projetos.apiprojetos.dto

import br.com.projetos.apiprojetos.model.StatusTarefa
import jakarta.validation.constraints.NotEmpty
import java.time.LocalDateTime

data class NovaTarefaForm(
    @field: NotEmpty val nome: String
)

data class TarefaView(
    val id: Long?,
    val nome: String,
    val status: StatusTarefa,
    val dataCriacao: LocalDateTime
)
