package br.com.projetos.apiprojetos.controller

import br.com.projetos.apiprojetos.dto.*
import br.com.projetos.apiprojetos.model.Projeto
import br.com.projetos.apiprojetos.model.Tarefa
import br.com.projetos.apiprojetos.service.ProjetoService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/projetos")
class ProjetoController(private val service: ProjetoService) {

    @GetMapping
    fun listar(): List<ProjetoView>{
        return service.listar()
    }

    @GetMapping("/{id}/tarefas")
    fun listarTarefas(@PathVariable id: Long): List<TarefaView> {
        return service.listarTarefas(id)
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): ProjetoView{
        return service.buscarPorId(id)
    }

    @PostMapping
    @Transactional
    fun cadastrar(
        @RequestBody @Valid dto: NovoProjetoForm,
        uriBuilder: UriComponentsBuilder
        ): ResponseEntity<ProjetoView> {
        val projetoView =  service.cadastrar(dto)
        val uri = uriBuilder.path( "/projetos/${projetoView.id}" ).build().toUri()
        return ResponseEntity.created(uri).body(projetoView)
    }

    @PostMapping("/{id}/tarefas")
    @Transactional
    fun adicionarTarefa(
        @PathVariable id: Long,
        @RequestBody @Valid tarefaForm: NovaTarefaForm
    ): ResponseEntity<Tarefa> {
        val tarefa = service.adicionarTarefa(id, tarefaForm)
        return ResponseEntity.ok(tarefa)
    }


    @PutMapping
    @Transactional
    fun atualizar(@RequestBody @Valid form: AtualizaProjetoForm): ResponseEntity<ProjetoView> {
        val projetoView = service.atualizar(form)
        return ResponseEntity.ok(projetoView)
    }

    @PutMapping("/{id}/tarefas/{tarefaId}")
    @Transactional
    fun atualizarTarefa(
        @PathVariable id: Long,
        @PathVariable tarefaId: Long,
        @RequestBody @Valid tarefaForm: NovaTarefaForm
    ): ResponseEntity<TarefaView> {
        val tarefaView = service.atualizarTarefa(id, tarefaId, tarefaForm)
        return ResponseEntity.ok(tarefaView)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun deletar(@PathVariable id: Long){
        service.deletar(id)
    }

    @DeleteMapping("/{id}/tarefas/{tarefaId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun deletarTarefa(@PathVariable id: Long, @PathVariable tarefaId: Long) {
        service.deletarTarefa(id, tarefaId)
    }

}

