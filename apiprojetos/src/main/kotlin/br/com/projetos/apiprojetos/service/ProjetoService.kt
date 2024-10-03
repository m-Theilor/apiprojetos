package br.com.projetos.apiprojetos.service

import br.com.projetos.apiprojetos.dto.AtualizaProjetoForm
import br.com.projetos.apiprojetos.dto.NovoProjetoForm
import br.com.projetos.apiprojetos.dto.ProjetoView
import br.com.projetos.apiprojetos.exception.NotFoundException
import br.com.projetos.apiprojetos.mapper.ProjetoFormMapper
import br.com.projetos.apiprojetos.mapper.ProjetoViewMapper
import br.com.projetos.apiprojetos.model.Projeto
import org.springframework.stereotype.Service
import java.util.stream.Collectors
import kotlin.collections.ArrayList

@Service
class ProjetoService(
    private var projetos: List<Projeto> = ArrayList(),
    private val projetoViewMapper: ProjetoViewMapper,
    private val projetoFormMapper: ProjetoFormMapper,
    private val notFoundMessage: String = "Projeto Not Found"
) {

    fun listar(): List<ProjetoView> {
        return projetos.stream().map {
            p -> projetoViewMapper.map(p)
        }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): ProjetoView {
        val projeto = projetos.stream().filter{
            p -> p.id == id
        }.findFirst().orElseThrow{ NotFoundException(notFoundMessage) }
        return projetoViewMapper.map(projeto)
    }

    fun cadastrar(form: NovoProjetoForm): ProjetoView  {
        val projeto = projetoFormMapper.map(form)
        projeto.id = projetos.size.toLong() + 1
        projetos = projetos.plus(projeto)
        return projetoViewMapper.map(projeto)
    }

    fun atualizar(form: AtualizaProjetoForm): ProjetoView {
        val projeto = projetos.stream().filter() { p -> p.id == form.id
        }.findFirst().orElseThrow{ NotFoundException(notFoundMessage) }
        val projetoAtualizado = Projeto(
            id = form.id,
            titulo = form.titulo,
            descricao = form.descricao,
            tarefas = projeto.tarefas,
            status = projeto.status,
            dataCriacao = projeto.dataCriacao
        )
        projetos = projetos.minus(projeto).plus(projetoAtualizado)
        return projetoViewMapper.map(projetoAtualizado)
    }

    fun deletar(id: Long) {
        val projeto = projetos.stream().filter() { p -> p.id == id
        }.findFirst().orElseThrow{ NotFoundException(notFoundMessage) }
        projetos = projetos.minus(projeto)
    }
}