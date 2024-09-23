package com.example.myapplication.view

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.data.School
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.viewmodels.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {
    val viewModel : DetailViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val id = intent.getStringExtra("id")

        setContent {
            MyApplicationTheme {
            if (id != null) {
                viewModel.getSchoolDetails(id)
                val schoolDetails by viewModel.detailedData.collectAsState()

                schoolDetails?.let {
                    if(schoolDetails.isNotEmpty()){
                        DetailsOfSchool(item = it)

                    }
                }


            }
        }

        }
    }
}

@Composable
fun DetailsOfSchool(item : List<School>){

    Column(modifier = Modifier.padding(16.dp)) {

        Text(text = item[0].school_name, modifier = Modifier.fillMaxWidth(), color = MaterialTheme.colorScheme.primary, style = MaterialTheme.typography.bodyMedium)
        Text(text = item[0].overview_paragraph, modifier = Modifier.fillMaxWidth(), color = MaterialTheme.colorScheme.primary, style = MaterialTheme.typography.bodyMedium)
        Text(text = item[0].program1, modifier = Modifier.fillMaxWidth(), color = MaterialTheme.colorScheme.primary, style = MaterialTheme.typography.bodyMedium)
        Text(text = item[0].directions1, modifier = Modifier.fillMaxWidth(), color = MaterialTheme.colorScheme.primary, style = MaterialTheme.typography.bodyMedium)
        Text(text = item[0].offer_rate1, modifier = Modifier.fillMaxWidth(), color = MaterialTheme.colorScheme.primary, style = MaterialTheme.typography.bodyMedium)
        Text(text = item[0].requirement1_1, modifier = Modifier.fillMaxWidth(), color = MaterialTheme.colorScheme.primary, style = MaterialTheme.typography.bodyMedium)
        Text(text = item[0].requirement2_1, modifier = Modifier.fillMaxWidth(), color = MaterialTheme.colorScheme.primary, style = MaterialTheme.typography.bodyMedium)
        Text(text = item[0].requirement3_1, modifier = Modifier.fillMaxWidth(), color = MaterialTheme.colorScheme.primary, style = MaterialTheme.typography.bodyMedium)
        Text(text = item[0].requirement4_1, modifier = Modifier.fillMaxWidth(), color = MaterialTheme.colorScheme.primary, style = MaterialTheme.typography.bodyMedium)
        Text(text = item[0].requirement5_1, modifier = Modifier.fillMaxWidth(), color = MaterialTheme.colorScheme.primary, style = MaterialTheme.typography.bodyMedium)

    }

}