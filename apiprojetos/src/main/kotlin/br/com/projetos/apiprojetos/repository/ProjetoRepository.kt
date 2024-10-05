package br.com.projetos.apiprojetos.repository

import br.com.projetos.apiprojetos.model.Projeto
import org.springframework.data.jpa.repository.JpaRepository

interface ProjetoRepository: JpaRepository<Projeto, Long> {
}