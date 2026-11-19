package br.com.fiap.victorcitizentech.model
import androidx.compose.ui.graphics.vector.ImageVector

data class SolucaoAssistiva(
    val id: Int,
    val nome: String,
    val descricao: String,
    val tecnologia: String,
    val publicoAlvo: String,
    val ods: String,
    val categorias: List<Categoria>,
    val destaque: Boolean,
    val icone: ImageVector
)
