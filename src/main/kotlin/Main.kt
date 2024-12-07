import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
@Preview
fun App() {
    val textos = List(50) { index ->
        val color = if (index % 2 == 0) Color.Red else Color.Yellow
        "Elemento número $index" to color
    }

    MaterialTheme {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(textos.size) { index ->
                val texto = textos[index]
                Caja(texto.first, texto.second)
            }
        }
    }
}

@Composable
fun Caja(texto: String, bgColor: Color = Color.Unspecified) {
    var isExtended by remember { mutableStateOf(false) }
    val rowPadding by animateDpAsState(
        targetValue = if (isExtended) 50.dp else 24.dp,
        animationSpec = tween(durationMillis = 500)
    )

    Row(
        modifier = Modifier
            .background(color = bgColor)
            .fillMaxWidth()
            .padding(bottom = rowPadding),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 24.dp, top = 24.dp)
        ) {
            Text(
                text = texto,
                color = Color.White
            )
        }
        Button(
            onClick = {
                isExtended = !isExtended
            },
            modifier = Modifier
                .padding(end = 24.dp, top = 24.dp)
        ) {
            Text(text = if (isExtended) "Mostrar Menos" else "Mostrar más")
        }
    }
}

@Composable
fun OnboardingScreen(
    onContinueClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("¡Bienvenido al Codelab!")
        Button(
            modifier = Modifier
                .padding(vertical = 24.dp),
            onClick = onContinueClicked
        ) {
            Text("Continuar")
        }
    }
}

fun main() = application {
    var shouldShowOnboarding by remember { mutableStateOf(true) }

    Window(onCloseRequest = ::exitApplication) {
        if (shouldShowOnboarding) {
            OnboardingScreen(onContinueClicked = { shouldShowOnboarding = false })
        } else {
            App()
        }
    }
}
