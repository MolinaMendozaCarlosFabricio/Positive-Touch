package com.charly.positive_touch.src.features.news.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.charly.positive_touch.src.features.news.domain.entities.News
import com.charly.positive_touch.src.features.news.presentation.viewmodels.NewsCardViewModel

@Composable
fun NewsCard(
    viewModel: NewsCardViewModel = viewModel(),
    news: News
) {
    val expanded by viewModel.expanded.collectAsState()
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { viewModel.changeExpantion() }
            .animateContentSize(),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column {
            if (news.image_url != "") {
                AsyncImage(
                    model = news.image_url,
                    contentDescription = news.title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp),
                    contentScale = ContentScale.Crop
                )
            }

            Column(modifier = Modifier.padding(12.dp)) {

                Text(
                    text = news.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(news.source, style = MaterialTheme.typography.bodySmall)
                    Text(news.date, style = MaterialTheme.typography.bodySmall)
                }

                AnimatedVisibility(visible = expanded) {

                    Column {
                        Spacer(modifier = Modifier.height(12.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text("Author: ${news.author}", style = MaterialTheme.typography.bodySmall)
                            Text("Category: ${news.category}", style = MaterialTheme.typography.bodySmall)
                        }

                        Spacer(modifier = Modifier.height(4.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text("Country: ${news.country}", style = MaterialTheme.typography.bodySmall)
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            text = news.description,
                            style = MaterialTheme.typography.bodyMedium
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            text = "Ref: ${news.ref}",
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.Blue
                        )
                    }
                }
            }
        }
    }
}