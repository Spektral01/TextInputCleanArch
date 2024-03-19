package com.example.cleanarchtextfield

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel

class PhoneNumScreenViewModel : ViewModel() {

    var uiState by mutableStateOf(PhoneNumState.Start)
        private set

    var message by mutableStateOf("")
    val convertBLogic = ConvertBLogic()

    fun onPhoneNumberChange(newPhoneNumber: String) {
         when {
            convertBLogic.isCorrect(newPhoneNumber) -> {
                uiState = PhoneNumState.Accept
                message = convertBLogic.ConvertNums(newPhoneNumber)
            }
            else -> {
                uiState = PhoneNumState.Error
                message = "Ошибка: Неверный формат ввода"
            }
        }
    }

    fun getStateColor(): Color{
        return when(uiState) {
            PhoneNumState.Start -> Color.Gray
            PhoneNumState.Accept -> Color.Green
            PhoneNumState.Error -> Color.Red
        }
    }
}

enum class PhoneNumState {
    Start,
    Accept,
    Error
}