package com.flixclusive.presentation.mobile.screens.player.controls.qualities_and_subtitles_sheet

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.DismissDirection
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SwipeToDismiss
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.flixclusive.R
import com.flixclusive_provider.models.common.Subtitle
import com.flixclusive.presentation.mobile.screens.player.controls.common.SheetItem
import com.flixclusive.presentation.utils.ComposeUtils.applyDropShadow
import com.flixclusive.presentation.utils.ModifierUtils.fadingEdge

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun QualitiesAndSubtitlesSheet(
    modifier: Modifier = Modifier,
    subtitles: List<Subtitle>,
    qualities: List<String>,
    selectedSubtitle: Int,
    selectedQuality: Int,
    onSubtitleChange: (Int, String) -> Unit,
    onVideoQualityChange: (Int, String) -> Unit,
    onDismissSheet: () -> Unit,
) {
    val listBottomFade =
        remember { Brush.verticalGradient(0.8f to Color.Red, 0.96f to Color.Transparent) }

    val dismissState = rememberDismissState(
        confirmValueChange = {
            onDismissSheet()
            true
        }
    )

    Box(
        modifier = modifier
            .fillMaxSize()
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ) { onDismissSheet() },
        contentAlignment = Alignment.CenterEnd
    ) {
        SwipeToDismiss(
            state = dismissState,
            background = {},
            dismissContent = {
                Box(
                    modifier = Modifier
                        .width(300.dp)
                        .fillMaxHeight()
                        .drawBehind {
                            drawRect(Color.Black.copy(0.3F))
                        }
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ) { /*Do nothing*/ }
                ) {
                    Box(
                        modifier = Modifier
                            .matchParentSize()
                            .drawBehind {
                                drawRect(
                                    Brush.horizontalGradient(
                                        colors = listOf(
                                            Color.Transparent,
                                            Color.Black
                                        ),
                                        startX = 0F,
                                        endX = size.width.times(0.4F)
                                    )
                                )
                            }
                    )

                    LazyColumn(
                        modifier = Modifier
                            .fadingEdge(listBottomFade)
                            .fillMaxHeight()
                    ) {
                        stickyHeader {
                            DismissSheetButton(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(50.dp),
                                onDismissIconClick = onDismissSheet
                            )
                        }

                        item {
                            Text(
                                text = stringResource(R.string.quality),
                                style = MaterialTheme.typography.labelLarge.applyDropShadow(),
                                modifier = Modifier.padding(start = 20.dp, top = 20.dp),
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }

                        itemsIndexed(
                            items = qualities,
                            key = { _, quality -> quality }
                        ) { i, quality ->
                            SheetItem(
                                name = quality,
                                index = i,
                                selectedIndex = selectedQuality,
                                onClick = {
                                    onVideoQualityChange(i, quality)
                                    onDismissSheet()
                                }
                            )
                        }

                        item {
                            Text(
                                text = stringResource(R.string.subtitle),
                                style = MaterialTheme.typography.labelLarge.applyDropShadow(),
                                modifier = Modifier.padding(start = 20.dp, top = 20.dp),
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }

                        itemsIndexed(
                            items = subtitles,
                            key = { _, subtitle -> subtitle }
                        ) { i, subtitle ->
                            SheetItem(
                                name = subtitle.lang,
                                index = i,
                                selectedIndex = selectedSubtitle,
                                onClick = {
                                    onSubtitleChange(i, subtitle.lang)
                                    onDismissSheet()
                                }
                            )
                        }

                        item {
                            Spacer(modifier = Modifier.height(80.dp))
                        }
                    }
                }
            },
            directions = setOf(DismissDirection.StartToEnd)
        )
    }
}


