package br.com.projetos.apiprojetos.dto

import jakarta.validation.constraints.Size
import org.jetbrains.annotations.NotNull

data class AtualizaProjetoForm(
    @field:NotNull val id: Long,
    @field:NotNull @field: Size(min = 5, max = 100) val titulo: String,
    @field:NotNull val descricao: String
)