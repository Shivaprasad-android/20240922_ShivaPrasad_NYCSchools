package com.example.myapplication.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.School
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.viewmodels.ListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
   private val viewModel:ListViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val items by viewModel.list.collectAsState()
            MyApplicationTheme {


                ItemListScreen(items = items) {
                    val intent = Intent(this,DetailActivity::class.java)
                    intent.putExtra("id", it)
                    startActivity(intent)
                }
            }
        }
    }
}


@Composable
fun ItemListScreen(items : List<School> , onItemClick:(String) -> Unit){

    LazyColumn {
        items (items.size){ index ->

            Text(text = items[index].school_name, modifier = Modifier.fillMaxSize().padding(16.dp).clickable {
                onItemClick(items[index].dbn)
            })



        }
    }

}