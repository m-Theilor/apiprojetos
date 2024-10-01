package br.com.projetos.apiprojetos.controller

import br.com.projetos.apiprojetos.model.Projeto
import br.com.projetos.apiprojetos.model.Tarefa
import br.com.projetos.apiprojetos.service.ProjetoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/projetos")
class ProjetoController(private val service: ProjetoService) {

    @GetMapping
    fun listar(): List<Projeto>{
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): Projeto{
        return service.buscarPorId(id)
    }

}