package br.com.projetos.apiprojetos.mapper

import br.com.projetos.apiprojetos.dto.TarefaView
import br.com.projetos.apiprojetos.model.Tarefa
import org.springframework.stereotype.Component

@Component
class TarefaViewMapper : Mapper<Tarefa, TarefaView> {
    override fun map(t: Tarefa): TarefaView {
        return TarefaView(
            id = t.id,
            nome = t.nome,
            status = t.status,
            dataCriacao = t.dataCriacao
        )
    }
}
