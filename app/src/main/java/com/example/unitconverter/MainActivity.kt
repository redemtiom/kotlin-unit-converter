package com.example.unitconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.unitconverter.ui.theme.UnitConverterTheme

var expandedButton1 = false
var expandedButton2 = false

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UnitConverterTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    UnitConverter(innerPadding)
                }
            }
        }
    }
}

@Composable
fun UnitConverter(innerPadding: PaddingValues) {
    Column(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
            Text("Unit Converter")
            OutlinedTextField(value = "", onValueChange =  {})
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Box(modifier = Modifier){
                    Button(onClick = {
                        expandedButton1 = true
                        println("oprimi el button 1")
                    }) {
                        Row {
                            Text(text = "Centimeters")
                            Icon(Icons.Default.ArrowDropDown, contentDescription = "Pull")
                        }
                    }
                    DropdownMenu(expanded = expandedButton1, onDismissRequest = { expandedButton1 = false }) {
                        DropdownMenuItem(text = { Text("Meters") }, onClick = { /*TODO*/ })
                    }
                }
                Box(modifier = Modifier){
                    Button(onClick = { expandedButton2 = !expandedButton2}) {
                        Row {
                            Text(text = "Meters")
                            Icon(Icons.Default.ArrowDropDown, contentDescription = "Pull")
                        }
                    }
                    DropdownMenu(expanded = expandedButton2, onDismissRequest = { expandedButton2 = false }) {
                        DropdownMenuItem(text = { Text("Centimeters") }, onClick = { /*TODO*/ })
                    }
                }
            }
            Text("Results Meters")
    }
}

@Preview(showBackground = true)
@Composable
fun UnitConverterPreview(){
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        UnitConverter(innerPadding)
    }
}