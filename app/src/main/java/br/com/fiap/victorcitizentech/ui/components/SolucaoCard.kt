package br.com.fiap.victorcitizentech.ui.components
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.victorcitizentech.model.SolucaoAssistiva
import br.com.fiap.victorcitizentech.ui.theme.PrimaryColor
import br.com.fiap.victorcitizentech.ui.theme.PrimaryLightColor
import br.com.fiap.victorcitizentech.ui.theme.SecondaryColor
import br.com.fiap.victorcitizentech.ui.theme.SecondaryTextColor
import br.com.fiap.victorcitizentech.ui.theme.TextDarkColor

@Composable
fun SolucaoCard(
    solucao: SolucaoAssistiva,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.Top
        ) {
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape)
                    .background(PrimaryLightColor),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = solucao.icone,
                    contentDescription = null,
                    tint = PrimaryColor,
                    modifier = Modifier.size(28.dp)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = solucao.nome,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextDarkColor
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = solucao.descricao,
                    fontSize = 14.sp,
                    color = SecondaryTextColor
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Tecnologia: ${solucao.tecnologia}",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = TextDarkColor
                )
                Text(
                    text = "Público: ${solucao.publicoAlvo}",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = TextDarkColor
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = solucao.ods,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = SecondaryColor
                )
            }
        }
    }
}
