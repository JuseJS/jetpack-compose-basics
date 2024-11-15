import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
@Preview
fun App() {
    //var text by remember { mutableStateOf("Hello, World!") }
    val textos = listOf<String>(
        "Que dices tio",
        "Manolito vende calamares",
        "Carmelo se dio de ostias con lorenzo",
        "Manolo lama comentando este partido de TFT"
    )

    MaterialTheme {
        Column(modifier = Modifier.fillMaxSize()) {
            textos.forEach { texto ->
                caja(texto)
            }
        }
    }
}

@Composable
fun caja(texto : String) {
    Row(modifier = Modifier
        .background(color = Color.Blue)
        .fillMaxWidth()
    ) {
        Text(
            text = texto,
            modifier = Modifier
                .padding(10.dp)
        )
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
