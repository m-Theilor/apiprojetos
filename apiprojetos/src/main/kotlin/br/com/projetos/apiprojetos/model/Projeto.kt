package br.com.projetos.apiprojetos.model


import jakarta.persistence.*
import java.time.LocalDateTime


@Entity
data class Projeto(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var titulo: String,
    var descricao: String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    @OneToMany(mappedBy = "projeto")
    val tarefas: List<Tarefa> = ArrayList(),
    @Enumerated(value = EnumType.STRING)
    val status: StatusProjeto = StatusProjeto.SEM_TAREFAS
)
