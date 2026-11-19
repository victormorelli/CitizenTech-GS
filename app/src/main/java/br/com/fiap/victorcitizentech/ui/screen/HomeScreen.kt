package br.com.fiap.citizentech.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
 import br.com.fiap.citizentech.ui.components.CategoriaSelector
import br.com.fiap.citizentech.ui.components.DestaqueCard
import br.com.fiap.victorcitizentech.domain.repository.SolucaoRepository
import br.com.fiap.victorcitizentech.model.Categoria
import br.com.fiap.victorcitizentech.ui.components.SolucaoCard
import br.com.fiap.victorcitizentech.ui.theme.BackgroundColor
import br.com.fiap.victorcitizentech.ui.theme.PrimaryColor
import br.com.fiap.victorcitizentech.ui.theme.SecondaryTextColor
import br.com.fiap.victorcitizentech.ui.theme.TextDarkColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    repository: SolucaoRepository,
    modifier: Modifier = Modifier
) {
    var categoriaSelecionada by remember { mutableStateOf(Categoria.TODAS) }

    val destaques = remember { repository.getDestaques() }
    val solucoes = remember(categoriaSelecionada) {
        repository.getSolucoesPorCategoria(categoriaSelecionada)
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = BackgroundColor,
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "CitizenTech Acessível",
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = PrimaryColor,
                    titleContentColor = Color.White
                )
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                Text(
                    text = "Tecnologia que devolve autonomia",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextDarkColor,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Text(
                    text = "Soluções para cidades, casas e trabalho sem barreiras",
                    fontSize = 14.sp,
                    color = SecondaryTextColor,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }

            item {
                Text(
                    text = "Em destaque",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextDarkColor,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                LazyRow(
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(destaques, key = { it.id }) { solucao ->
                        DestaqueCard(solucao = solucao)
                    }
                }
            }

            item {
                Text(
                    text = "Categorias",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextDarkColor,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                CategoriaSelector(
                    categorias = Categoria.entries,
                    categoriaSelecionada = categoriaSelecionada,
                    onCategoriaClick = { categoriaSelecionada = it }
                )
            }

            items(solucoes, key = { it.id }) { solucao ->
                SolucaoCard(
                    solucao = solucao,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
        }
    }
}
