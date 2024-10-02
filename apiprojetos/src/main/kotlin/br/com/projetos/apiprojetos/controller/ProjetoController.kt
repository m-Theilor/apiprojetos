package br.com.projetos.apiprojetos.controller

import br.com.projetos.apiprojetos.dto.NovoProjetoForm
import br.com.projetos.apiprojetos.dto.ProjetoView
import br.com.projetos.apiprojetos.model.Projeto
import br.com.projetos.apiprojetos.service.ProjetoService
import org.springframework.web.bind.annotation.*

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
    fun cadastrar(@RequestBody dto: NovoProjetoForm){
        service.cadastrar(dto)
    }

}