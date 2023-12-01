package ru.artysei.notes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import ru.artysei.notes.ui.theme.NotesTheme
import ru.artysei.notes.viewmodels.MainViewModel

class MainActivity : ComponentActivity() {

    private val mvm: MainViewModel by lazy{
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesTheme {
                MainUI(
                    title = stringResource(id = mvm.titleId),
                    viewMode = mvm.viewMode,
                    addNote = { mvm.viewMode = ViewMode.NOTE }
                ){

                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainUI(
    modifier: Modifier = Modifier,
    title: String = "",
    viewMode: ViewMode = ViewMode.LIST,
    addNote: ()->Unit = {},
    content: @Composable ()->Unit,
){
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(text = title)
                },
                navigationIcon = {

                },
                actions = {

                }
            )
        },
        floatingActionButton = {
            if (viewMode == ViewMode.LIST) {
                OutlinedIconButton(
                    modifier = Modifier.defaultMinSize(48.dp, 48.dp),
                    onClick = addNote
                ) {
                    Icon(
                        painterResource(id = R.drawable.baseline_playlist_add_circle_48),
                        contentDescription = null
                    )
                }
            }
        },
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
    ){
        Column(Modifier.padding(it)){
            content()
        }
    }
}