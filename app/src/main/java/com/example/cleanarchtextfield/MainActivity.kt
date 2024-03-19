package com.example.cleanarchtextfield

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cleanarchtextfield.ui.theme.CleanArchTextFieldTheme

class MainActivity : ComponentActivity() {

    private val viewModel = PhoneNumScreenViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CleanArchTextFieldTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    InputPhoneNumScreen(viewModel)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputPhoneNumScreen(viewModel: PhoneNumScreenViewModel) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp)
    ) {
        var nums by remember { mutableStateOf("") }
        var convNums by remember { mutableStateOf("") }

        OutlinedTextField(
            value = nums,
            onValueChange = { nums = it },
            label = { Text("enter the numbers after +7") },
        )

        Button(onClick = {
            viewModel.onPhoneNumberChange(nums)
            convNums = viewModel.message
        },
        modifier = Modifier.padding(24.dp)
        ) {
            Text(text = "Convert phone number")
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color.Gray,
                    shape = MaterialTheme.shapes.medium
                )
                .padding(2.dp)
                .background(
                    color = viewModel.getStateColor(),
                    shape = MaterialTheme.shapes.medium
                )

        ) {
            Text(
                text = viewModel.message,
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.Center)
            )
        }
    }
}