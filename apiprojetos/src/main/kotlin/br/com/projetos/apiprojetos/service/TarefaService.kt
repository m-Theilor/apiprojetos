package br.com.projetos.apiprojetos.service

import br.com.projetos.apiprojetos.dto.NovaTarefaForm
import br.com.projetos.apiprojetos.dto.TarefaView
import br.com.projetos.apiprojetos.exception.NotFoundException
import br.com.projetos.apiprojetos.mapper.TarefaViewMapper
import br.com.projetos.apiprojetos.model.Projeto
import br.com.projetos.apiprojetos.model.Tarefa
import br.com.projetos.apiprojetos.repository.ProjetoRepository
import br.com.projetos.apiprojetos.repository.TarefaRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TarefaService(
    private val projetoRepository: ProjetoRepository,
    private val tarefaRepository: TarefaRepository,
    private val tarefaViewMapper: TarefaViewMapper,
    private val notFoundMessage: String = "Tarefa Not Found"
) {

    fun adicionarTarefa(projetoId: Long, form: NovaTarefaForm): TarefaView {
        val projeto = projetoRepository.findById(projetoId).orElseThrow { NotFoundException("Projeto não encontrado") }
        val tarefa = Tarefa(nome = form.nome)
        projeto.tarefas.add(tarefa)
        tarefaRepository.save(tarefa)
        return tarefaViewMapper.map(tarefa)
    }

    fun listarTarefas(projetoId: Long): List<TarefaView> {
        val projeto = projetoRepository.findById(projetoId).orElseThrow { NotFoundException("Projeto não encontrado") }
        return projeto.tarefas.stream().map { tarefaViewMapper.map(it) }.collect(Collectors.toList())
    }

    fun atualizarTarefa(projetoId: Long, tarefaId: Long, form: NovaTarefaForm): TarefaView {
        val projeto = projetoRepository.findById(projetoId).orElseThrow { NotFoundException("Projeto não encontrado") }
        val tarefa = projeto.tarefas.firstOrNull { it.id == tarefaId } ?: throw NotFoundException(notFoundMessage)
        tarefa.nome = form.nome
        tarefaRepository.save(tarefa)
        return tarefaViewMapper.map(tarefa)
    }

    fun deletarTarefa(projetoId: Long, tarefaId: Long) {
        val projeto = projetoRepository.findById(projetoId).orElseThrow { NotFoundException("Projeto não encontrado") }
        val tarefa = projeto.tarefas.firstOrNull { it.id == tarefaId } ?: throw NotFoundException(notFoundMessage)
        projeto.tarefas.remove(tarefa)
        tarefaRepository.delete(tarefa)
    }
}
