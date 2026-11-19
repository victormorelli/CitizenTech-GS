package br.com.fiap.victorcitizentech.domain.repository
import br.com.fiap.victorcitizentech.model.Categoria
import br.com.fiap.victorcitizentech.model.SolucaoAssistiva

interface SolucaoRepository {

    fun getSolucoes(): List<SolucaoAssistiva>

    fun getSolucoesPorCategoria(categoria: Categoria): List<SolucaoAssistiva>

    fun getDestaques(): List<SolucaoAssistiva>
}
