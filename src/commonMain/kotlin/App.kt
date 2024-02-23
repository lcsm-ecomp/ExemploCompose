import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {
    //MaterialTheme {
        var nome by remember { mutableStateOf("Luis") }
        val turmas = remember { mutableStateListOf("a", "b", "c") }
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            TextField(value = nome, onValueChange = { nome = it }, label = { Text("Nome do Professor: ")})
            for (pos in 0..(turmas.size-1)) {
                Row() {
                   TextField(value = turmas[pos], onValueChange = { turmas[pos] = it } )
                   Button( onClick = { turmas.removeAt(pos) } ) {
                      Text("delete")
                   }
                }
            }
            Button( onClick = { turmas.add("") } ) {
                 Text("Insert")
            }
            
        }
    //}
}
