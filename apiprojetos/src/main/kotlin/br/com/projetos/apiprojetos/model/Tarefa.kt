package br.com.projetos.apiprojetos.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Tarefa(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val nome: String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    @Enumerated(value = EnumType.STRING)
    val status: StatusTarefa = StatusTarefa.NAO_REALIZADA

)
