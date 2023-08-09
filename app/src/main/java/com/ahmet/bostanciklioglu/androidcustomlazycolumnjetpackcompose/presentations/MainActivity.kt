package com.ahmet.bostanciklioglu.androidcustomlazycolumnjetpackcompose.presentations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ahmet.bostanciklioglu.androidcustomlazycolumnjetpackcompose.ui.theme.AndroidCustomLazyColumnJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidCustomLazyColumnJetpackComposeTheme {
                LazyColumnList(lists = ListDataSource)
            }
        }
    }
}

