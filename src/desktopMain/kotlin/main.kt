

import androidx.compose.material.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.*
import androidx.compose.ui.unit.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.foundation.background
import androidx.compose.animation.*

fun main() = application {
    var tela by mutableStateOf(0)
    var nome by mutableStateOf("Luis")
    var quantidade by mutableStateOf(0)
    var mostraSaudacao by mutableStateOf(true)


    Window(onCloseRequest = ::exitApplication, title = "Ola Compose") {
         Column(Modifier.fillMaxWidth().padding(60.dp), horizontalAlignment = Alignment.CenterHorizontally) {
           Text("Minha Primeira Aplicação Compose")
           AnimatedVisibility (tela==0) {
              Column(Modifier.fillMaxWidth().padding(60.dp), horizontalAlignment = Alignment.CenterHorizontally) {

              Text("Ola Pessoal")
              Button( onClick={ tela=1 }) {
                Text("Iniciar Aplicacao")
              }   
              }
           } 
           AnimatedVisibility(tela==1) {
              Column(Modifier.fillMaxWidth().padding(60.dp), horizontalAlignment = Alignment.CenterHorizontally) {

              TextField(value=nome, label={Text("Digite o seu Nome: ")}, onValueChange={ novoNome -> 
                  println("O usuario modificou o seu nome para ${novoNome}")
                  nome = novoNome
              })
              Text("")
              Button(onClick={ 
                println("O usuario apertou o botao") 
                quantidade = quantidade + 1
                mostraSaudacao = !mostraSaudacao
              }) {
                  println("UI Botão esta sendo construida")
                  Text("$nome\napertou este botão\n$quantidade vezes")
                  
              }
              Text("")
              AnimatedVisibility(mostraSaudacao) {
                  Text("Bom dia $nome")
              }

              Button(onClick= { tela=0 }) {
                Text("Sair da Aplicação")
              }
           }
           }
         }
    }
}

