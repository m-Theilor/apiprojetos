package br.com.projetos.apiprojetos.service

import br.com.projetos.apiprojetos.dto.AtualizaProjetoForm
import br.com.projetos.apiprojetos.dto.NovoProjetoForm
import br.com.projetos.apiprojetos.dto.ProjetoView
import br.com.projetos.apiprojetos.exception.NotFoundException
import br.com.projetos.apiprojetos.mapper.ProjetoFormMapper
import br.com.projetos.apiprojetos.mapper.ProjetoViewMapper
import br.com.projetos.apiprojetos.model.Projeto
import br.com.projetos.apiprojetos.repository.ProjetoRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors
import kotlin.collections.ArrayList

@Service
class ProjetoService(
    private val repository: ProjetoRepository,
    private val projetoViewMapper: ProjetoViewMapper,
    private val projetoFormMapper: ProjetoFormMapper,
    private val notFoundMessage: String = "Projeto Not Found"
) {

    fun listar(): List<ProjetoView> {
        return repository.findAll().stream().map {
            p -> projetoViewMapper.map(p)
        }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): ProjetoView {
        val projeto = repository.findById(id).orElseThrow{ NotFoundException(notFoundMessage) }
        return projetoViewMapper.map(projeto)
    }

    fun cadastrar(form: NovoProjetoForm): ProjetoView  {
        val projeto = projetoFormMapper.map(form)
        repository.save(projeto)
        return projetoViewMapper.map(projeto)
    }

    fun atualizar(form: AtualizaProjetoForm): ProjetoView {
        val projeto = repository.findById(form.id).orElseThrow{ NotFoundException(notFoundMessage) }
        projeto.titulo = form.titulo
        projeto.descricao = form.descricao
        return projetoViewMapper.map(projeto)
    }

    fun deletar(id: Long) {
       repository.deleteById(id)
    }
}