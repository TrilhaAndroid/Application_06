package br.com.leonardobarral.application_06.componentes

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun CaixaDeEntrada(
    labelText:String,
    placeHolderText: String,
    valueText:String,
    keyboardType:KeyboardType,
    modifier: Modifier,
    colorBackGround: Color,
    updaterState: (String) -> Unit
) {
    TextField(
        value = valueText,
        onValueChange = updaterState,
        placeholder = { Text(text = placeHolderText) },
        label = { Text(text = labelText)},
        modifier = modifier,
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = colorBackGround
        ) ,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),

    )

    
}