package br.com.leonardobarral.application_06.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.leonardobarral.application_06.componentes.CaixaDeEntrada
import br.com.leonardobarral.application_06.componentes.CardResultado
import br.com.leonardobarral.application_06.models.JurosScreenViewModel

@Composable
fun JurosScreenView(jurosScreenViewModel: JurosScreenViewModel) {

    val valorInvestido by jurosScreenViewModel.valorInvestido.observeAsState(initial = "")
    val taxaJurosMensal by jurosScreenViewModel.taxa.observeAsState(initial = "")
    val periodoMeses by jurosScreenViewModel.periodo.observeAsState(initial = "")

    val jurosSimples by jurosScreenViewModel.jurosSimples.observeAsState(initial = 0.0)
    val montanteSimples by jurosScreenViewModel.montanteSimples.observeAsState(initial = 0.0)

    val jurosCompostos by jurosScreenViewModel.jurosCompostos.observeAsState(initial = 0.0)
    val montanteComposto by jurosScreenViewModel.montanteComposto.observeAsState(initial = 0.0)

    Column(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {

        Text(
            text = "Cálculo de Juros Simples",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp, bottom = 20.dp),
            color = Color(0xFFC70505),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                Text(
                    text = "Dados do Investimento",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .padding(bottom = 20.dp)
                )


                CaixaDeEntrada(
                    labelText = "Valor do investimento",
                    placeHolderText = "R$ 0.000,00",
                    valueText = valorInvestido,
                    keyboardType = KeyboardType.Decimal,
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(BorderStroke(1.dp, color = Color.Gray)),
                    colorBackGround = Color.White,
                    updaterState = {
                        jurosScreenViewModel.updateValorInvestimento(it)
                    }
                )

                Spacer(modifier = Modifier.height(20.dp))

                CaixaDeEntrada(
                    labelText = "Taxa de jusros mensal",
                    placeHolderText = "0.7%",
                    valueText = taxaJurosMensal,
                    keyboardType = KeyboardType.Decimal,
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(BorderStroke(1.dp, color = Color.Gray)),
                    colorBackGround = Color.White,
                    updaterState = {
                        jurosScreenViewModel.updateTaxa(it)
                    }
                )

                Spacer(modifier = Modifier.height(20.dp))

                CaixaDeEntrada(
                    labelText = "Período em meses",
                    placeHolderText = "9 meses",
                    valueText = periodoMeses,
                    keyboardType = KeyboardType.Number,
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(BorderStroke(1.dp, color = Color.Gray)),
                    colorBackGround = Color.White,
                    updaterState = {
                        jurosScreenViewModel.updatePerioro(it)
                    }
                )


                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = {
                        jurosScreenViewModel.calcularjurosSimples()
                        jurosScreenViewModel.calcularMontanteSimples()
                        jurosScreenViewModel.calcularMontanteComposto()
                        jurosScreenViewModel.calcularJurosCompostos()
                    },
                    modifier = Modifier.fillMaxWidth()
                ) { Text(text = "CALCULAR") }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        CardResultado(
            titulo = "Resultado - Juros simples",
            juros = jurosSimples,
            montante = montanteSimples
        )
        Spacer(modifier = Modifier.height(20.dp))
        CardResultado(
            titulo = "Resultado - Juros compostos",
            juros = jurosCompostos,
            montante = montanteComposto
        )
    }
}

