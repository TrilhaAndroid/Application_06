package br.com.leonardobarral.application_06.componentes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun CardResultado(
    titulo: String,
    juros: Comparable<*>,
    montante: Comparable<*>
) {
    Card (
        modifier = Modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF29861A)
        )
    ){
        Column (
            modifier = Modifier
                .padding(20.dp)
        ){
            Text(
                text = titulo,
                color = Color.White,
                modifier = Modifier
                    .padding(bottom = 20.dp),
                fontWeight = FontWeight.SemiBold
            )
            Row(
                modifier = Modifier
                    .padding(bottom = 10.dp),
            ){
                Text(
                    text = "Juros",
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    text = "$juros",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
            Row(
                modifier = Modifier
                    .padding(bottom = 10.dp),
            ){
                Text(
                    text = "Montante",
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    text = "$montante",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}