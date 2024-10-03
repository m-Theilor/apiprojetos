package br.com.projetos.apiprojetos.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size

data class NovoProjetoForm (
    @field: NotEmpty @field: Size(min = 5, max = 100) val titulo: String,
    @field: NotEmpty val descricao: String,
)
