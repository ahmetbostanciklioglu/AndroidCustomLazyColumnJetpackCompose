package com.ahmet.bostanciklioglu.androidcustomlazycolumnjetpackcompose.presentations

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ahmet.bostanciklioglu.androidcustomlazycolumnjetpackcompose.R

@Composable
fun LazyColumnList(modifier: Modifier = Modifier, lists: ListDataSource) {
    val itemsList = lists.dataSource()
    LazyColumn(
        modifier = modifier.padding(horizontal = 8.dp)
    ) {
        items(itemsList) { item ->
            Card(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                elevation = CardDefaults.elevatedCardElevation(1.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    contentColor = MaterialTheme.colorScheme.background
                )
            ) {
                Row {
                    ListImage(
                        image = painterResource(id = item.image),
                        modifier = modifier
                            .align(alignment = Alignment.CenterVertically)
                            .padding(start = 4.dp)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    ListText(
                        modifier = modifier.padding(vertical = 8.dp),
                        title = stringResource(id = item.title),
                        body = stringResource(id = item.content)
                    )

                }
            }
        }
    }
}

@Composable
fun ListImage(
    modifier: Modifier = Modifier,
    image: Painter
) {
    Box(
        modifier = modifier
    ) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }

}

@Composable
fun ListText(
    modifier: Modifier = Modifier,
    title: String,
    body: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(6.dp),
        modifier = modifier
            .padding(vertical = 4.dp)
            .padding(end = 8.dp)
    ) {
        Text(
            text = title,
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Normal,
                textAlign = TextAlign.Center
            )
        )
        Text(
            text = body,
            style = TextStyle(
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Normal,
                textAlign = TextAlign.Justify,
                lineHeight = 17.sp
            ),

            )
    }
}


@Preview(showSystemUi = true, showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun LazyColumnListPreview() {
    MaterialTheme {
        LazyColumnList(lists = ListDataSource)
    }
}