

import androidx.compose.material.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.*
import androidx.compose.ui.unit.*
import androidx.compose.runtime.*
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application



var nome by mutableStateOf("Luis")
var mostraBoasVindas by mutableStateOf(false)

@Composable
fun makeApp() {
        Column( Modifier.fillMaxWidth().padding(15.dp), horizontalAlignment = Alignment.CenterHorizontally ) {
          println("Desenhando UI")
          TextField(value=nome, label={ Text("Qual o seu nome?")} , onValueChange = {nome = it})
          Button( onClick = { mostraBoasVindas = !mostraBoasVindas; println("Botão Pressionado") }) { 
            Text("Pressione" + nome) 
            println("Desenhando Botao")
          }
          if (mostraBoasVindas) Text("Ola " + nome)
        }

}



fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "Ola Mundo") {
        makeApp()
    }
}

