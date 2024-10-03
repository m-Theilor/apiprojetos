package br.com.projetos.apiprojetos.mapper

import br.com.projetos.apiprojetos.dto.ProjetoView
import br.com.projetos.apiprojetos.model.Projeto
import org.springframework.stereotype.Component

@Component
class ProjetoViewMapper: Mapper<Projeto, ProjetoView> {
    override fun map(p: Projeto): ProjetoView {
        return ProjetoView(
            id = p.id,
            titulo = p.titulo,
            descricao = p.descricao,
            status = p.status,
            dataCriacao = p.dataCriacao
        )
    }
}