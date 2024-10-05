package br.com.projetos.apiprojetos.repository

import br.com.projetos.apiprojetos.model.Tarefa
import org.springframework.data.jpa.repository.JpaRepository

interface TarefaRpository: JpaRepository<Tarefa, Long> {
}