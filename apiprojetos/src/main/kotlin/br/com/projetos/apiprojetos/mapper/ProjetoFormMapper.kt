package br.com.projetos.apiprojetos.mapper

import br.com.projetos.apiprojetos.dto.NovoProjetoForm
import br.com.projetos.apiprojetos.model.Projeto
import org.springframework.stereotype.Component

@Component
class ProjetoFormMapper: Mapper<NovoProjetoForm, Projeto> {
    override fun map(p: NovoProjetoForm): Projeto {
        return Projeto(
            titulo = p.titulo,
            descricao = p.descricao
        )
    }
}
