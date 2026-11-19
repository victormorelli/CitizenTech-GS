package br.com.fiap.victorcitizentech
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import br.com.fiap.citizentech.ui.screens.HomeScreen
import br.com.fiap.victorcitizentech.data.memory.InMemorySolucaoRepository
import br.com.fiap.victorcitizentech.domain.repository.SolucaoRepository
 import br.com.fiap.victorcitizentech.ui.theme.CitizenTechTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CitizenTechTheme {
                val repository: SolucaoRepository = InMemorySolucaoRepository()
                HomeScreen(repository = repository)
            }
        }
    }
}
