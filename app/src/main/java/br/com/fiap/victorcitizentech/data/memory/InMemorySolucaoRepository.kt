package br.com.fiap.victorcitizentech.data.memory

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ThumbUp
import br.com.fiap.victorcitizentech.domain.repository.SolucaoRepository
import br.com.fiap.victorcitizentech.model.Categoria
import br.com.fiap.victorcitizentech.model.SolucaoAssistiva

class InMemorySolucaoRepository : SolucaoRepository {

    private val solucoes = listOf(
        SolucaoAssistiva(
            id = 1,
            nome = "Cursor pelo nariz",
            descricao = "Move o cursor do computador acompanhando o nariz, sem usar mouse ou toque.",
            tecnologia = "Visão computacional (MediaPipe Face Mesh)",
            publicoAlvo = "Pessoas sem uso dos braços",
            ods = "ODS 10 - Redução das desigualdades",
            categorias = listOf(Categoria.ACESSIBILIDADE, Categoria.TRABALHO),
            destaque = true,
            icone = Icons.Filled.Face
        ),
        SolucaoAssistiva(
            id = 2,
            nome = "Clique por piscada",
            descricao = "Detecta a piscada voluntária e a transforma em clique do mouse.",
            tecnologia = "Visão computacional (Eye Aspect Ratio)",
            publicoAlvo = "Pessoas com mobilidade reduzida",
            ods = "ODS 10 - Redução das desigualdades",
            categorias = listOf(Categoria.ACESSIBILIDADE, Categoria.EDUCACAO),
            destaque = true,
            icone = Icons.Filled.Person
        ),
        SolucaoAssistiva(
            id = 3,
            nome = "Controle por gestos da mão",
            descricao = "Reconhece a mão fechada como clique e o dedo indicador como cursor.",
            tecnologia = "Visão computacional (MediaPipe Hands)",
            publicoAlvo = "Pessoas com dificuldade motora fina",
            ods = "ODS 9 - Indústria, inovação e infraestrutura",
            categorias = listOf(Categoria.ACESSIBILIDADE, Categoria.CASA_INTELIGENTE),
            destaque = true,
            icone = Icons.Filled.ThumbUp
        ),
        SolucaoAssistiva(
            id = 4,
            nome = "Cadeira de rodas conectada",
            descricao = "Sensores monitoram trajeto, obstáculos e enviam alertas ao cuidador.",
            tecnologia = "Sensores IoT e aplicativo mobile",
            publicoAlvo = "Cadeirantes e cuidadores",
            ods = "ODS 11 - Cidades e comunidades sustentáveis",
            categorias = listOf(Categoria.MOBILIDADE, Categoria.SAUDE),
            destaque = false,
            icone = Icons.Filled.Build
        ),
        SolucaoAssistiva(
            id = 5,
            nome = "Rotas urbanas acessíveis",
            descricao = "Sugere trajetos considerando calçadas, rampas, iluminação e segurança.",
            tecnologia = "Dados abertos e geolocalização",
            publicoAlvo = "Idosos e pessoas com deficiência",
            ods = "ODS 11 - Cidades e comunidades sustentáveis",
            categorias = listOf(Categoria.MOBILIDADE),
            destaque = false,
            icone = Icons.Filled.Place
        ),
        SolucaoAssistiva(
            id = 6,
            nome = "Casa por comandos",
            descricao = "Liga luzes e aparelhos usando gestos ou comandos de voz.",
            tecnologia = "Automação residencial e voz",
            publicoAlvo = "Pessoas com mobilidade reduzida",
            ods = "ODS 9 - Indústria, inovação e infraestrutura",
            categorias = listOf(Categoria.CASA_INTELIGENTE, Categoria.ACESSIBILIDADE),
            destaque = false,
            icone = Icons.Filled.Home
        ),
        SolucaoAssistiva(
            id = 7,
            nome = "Alertas de emergência",
            descricao = "Avisa a comunidade e contatos de confiança em situações de risco.",
            tecnologia = "Notificações push e geolocalização",
            publicoAlvo = "Moradores de áreas de risco",
            ods = "ODS 13 - Ação contra a mudança global do clima",
            categorias = listOf(Categoria.MOBILIDADE, Categoria.SAUDE),
            destaque = true,
            icone = Icons.Filled.Notifications
        ),
        SolucaoAssistiva(
            id = 8,
            nome = "Assistente de estudos acessível",
            descricao = "Organiza materiais e permite estudar sem teclado ou mouse.",
            tecnologia = "Inteligência artificial e visão computacional",
            publicoAlvo = "Estudantes com deficiência",
            ods = "ODS 4 - Educação de qualidade",
            categorias = listOf(Categoria.EDUCACAO, Categoria.ACESSIBILIDADE),
            destaque = false,
            icone = Icons.Filled.AccountCircle
        ),
        SolucaoAssistiva(
            id = 9,
            nome = "Teleorientação em saúde",
            descricao = "Atendimento remoto preventivo para quem mora longe de unidades de saúde.",
            tecnologia = "Videochamada e triagem digital",
            publicoAlvo = "Populações distantes ou isoladas",
            ods = "ODS 3 - Saúde e bem-estar",
            categorias = listOf(Categoria.SAUDE),
            destaque = false,
            icone = Icons.Filled.Phone
        ),
        SolucaoAssistiva(
            id = 10,
            nome = "Posto de trabalho adaptado",
            descricao = "Configura o computador para trabalho remoto sem uso das mãos.",
            tecnologia = "Software assistivo e visão computacional",
            publicoAlvo = "Profissionais com deficiência motora",
            ods = "ODS 10 - Redução das desigualdades",
            categorias = listOf(Categoria.TRABALHO, Categoria.ACESSIBILIDADE),
            destaque = false,
            icone = Icons.Filled.Settings
        )
    )

    override fun getSolucoes(): List<SolucaoAssistiva> {
        return solucoes
    }

    override fun getSolucoesPorCategoria(categoria: Categoria): List<SolucaoAssistiva> {
        return if (categoria == Categoria.TODAS) {
            solucoes
        } else {
            solucoes.filter { categoria in it.categorias }
        }
    }

    override fun getDestaques(): List<SolucaoAssistiva> {
        return solucoes.filter { it.destaque }
    }
}
