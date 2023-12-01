package ru.artysei.notes.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import ru.artysei.notes.R
import ru.artysei.notes.ViewMode

class MainViewModel : ViewModel() {
    var viewMode by mutableStateOf(ViewMode.LIST)

    val titleId: Int
        get() = when(viewMode){
            ViewMode.LIST -> R.string.title
            ViewMode.NOTE -> R.string.edit_title
        }
}