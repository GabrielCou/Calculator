package com.example.calculator

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Calculator()
        }
    }
}

@Composable
fun Calculator() {
    var number1 by remember { mutableStateOf("") }
    var number2 by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        TextField(
            value = number1,
            onValueChange = { number1 = it },
            label = { Text("Número 1") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        TextField(
            value = number2,
            onValueChange = { number2 = it },
            label = { Text("Número 2") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CalculatorButton(
                text = "+",
                onClick = { result =
                    ((number1.toIntOrNull() ?: 0) + (number2.toIntOrNull() ?: 0)).toString()
                }
            )

            CalculatorButton(
                text = "-",
                onClick = { result =
                    ((number1.toIntOrNull() ?: 0) - (number2.toIntOrNull() ?: 0)).toString()
                }
            )

            CalculatorButton(
                text = "*",
                onClick = { result =
                    ((number1.toIntOrNull() ?: 0) * (number2.toIntOrNull() ?: 0)).toString()
                }
            )

            CalculatorButton(
                text = "/",
                onClick = { result =
                    ((number1.toIntOrNull() ?: 0) / (number2.toIntOrNull() ?: 1)).toString()
                }
            )
        }

        Text(
            text = "Resultado: $result",
            style = MaterialTheme.typography.h5,
            modifier = Modifier.align(Alignment.End)
        )
    }
}

@Composable
fun CalculatorButton(text: String, onClick: () -> Unit) {
    Button(onClick = onClick, modifier = Modifier.width(72.dp).height(72.dp)) {
        Text(text)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    Calculator()
}