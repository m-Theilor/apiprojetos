package br.com.projetos.apiprojetos.mapper

interface Mapper<T, U> {
    fun map(p: T): U
}
