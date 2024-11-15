import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
@Preview
fun App() {
    val textos = listOf(
        Pair("Que dices tio", Color.Red),
        Pair("Manolito vende calamares", Color.Yellow),
        Pair("Carmelo se dio de ostias con lorenzo", Color.Yellow),
        Pair("Manolo lama comentando este partido de TFT", Color.Red)
    )

    MaterialTheme {
        Column(modifier = Modifier.fillMaxSize()) {
            textos.forEach { texto ->
                caja(texto.first, texto.second)
            }
        }
    }
}

@Composable
fun caja(texto : String, bgColor : Color = Color.Unspecified) {
    var isExtended by remember { mutableStateOf(false) }
    var rowPadding by remember { mutableStateOf(24.dp) }

    Row(modifier = Modifier
        .background(color = bgColor)
        .padding(rowPadding)
        .fillMaxWidth()
    ) {
        Text(
            text = texto,
            modifier = Modifier.weight(1f)
        )
        Button(
            onClick = {
                isExtended = !isExtended
                rowPadding = if (isExtended) 50.dp else 24.dp
            }
        ) {
            Text(text = if (isExtended) "Mostrar Menos" else "Mostras más")
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
