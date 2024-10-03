package br.com.projetos.apiprojetos.controller

import br.com.projetos.apiprojetos.dto.AtualizaProjetoForm
import br.com.projetos.apiprojetos.dto.NovoProjetoForm
import br.com.projetos.apiprojetos.dto.ProjetoView
import br.com.projetos.apiprojetos.model.Projeto
import br.com.projetos.apiprojetos.service.ProjetoService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/projetos")
class ProjetoController(private val service: ProjetoService) {

    @GetMapping
    fun listar(): List<ProjetoView>{
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): ProjetoView{
        return service.buscarPorId(id)
    }

    @PostMapping
    fun cadastrar(
        @RequestBody @Valid dto: NovoProjetoForm,
        uriBuilder: UriComponentsBuilder
        ): ResponseEntity<ProjetoView> {
        val projetoView =  service.cadastrar(dto)
        val uri = uriBuilder.path( "/projetos/${projetoView.id}" ).build().toUri()
        return ResponseEntity.created(uri).body(projetoView)
    }

    @PutMapping
    fun atualizar(@RequestBody @Valid form: AtualizaProjetoForm): ResponseEntity<ProjetoView> {
        val projetoView = service.atualizar(form)
        return ResponseEntity.ok(projetoView)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable id: Long){
        service.deletar(id)
    }

}