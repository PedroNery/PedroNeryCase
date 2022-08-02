package com.projeto.moviedetail.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.material.placeholder
import com.google.accompanist.placeholder.material.shimmer
import com.projeto.designsystem.compose.components.BodyText
import com.projeto.designsystem.compose.components.TitleText
import com.projeto.designsystem.compose.ui.ErrorScreen
import com.projeto.moviedetail.model.MovieDetailDataUI

@Composable
fun MovieDetailError(
    onClickRetry: () -> Unit
) {
    ErrorScreen {
        onClickRetry()
    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun MovieDetailComponent(
    movieDetailDataUI: MovieDetailDataUI,
    isLoading: Boolean = true
) {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        val (poster, informations, plot) = createRefs()

        val informationsList = listOf(
            movieDetailDataUI.title,
            movieDetailDataUI.type,
            movieDetailDataUI.year,
            movieDetailDataUI.director,
            movieDetailDataUI.runtime,
            movieDetailDataUI.genre
        )

        val rememberImagePainter = rememberImagePainter(
            data = movieDetailDataUI.poster
        )

        Image(
            painter = rememberImagePainter,
            contentDescription = "Movie poster",
            modifier = Modifier
                .constrainAs(poster) {
                    top.linkTo(parent.top, margin = 32.dp)
                    start.linkTo(parent.start, margin = 24.dp)
                }
                .width(180.dp)
                .height(300.dp)
                .placeholder(
                    visible = isLoading,
                    highlight = PlaceholderHighlight.shimmer()
                )
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.FillBounds
        )

        Column(
            modifier = Modifier
                .constrainAs(informations) {
                    top.linkTo(poster.top)
                    start.linkTo(poster.end, margin = 24.dp)
                    end.linkTo(parent.end, margin = 12.dp)
                    width = Dimension.fillToConstraints
                }
        ) {
            for (information in informationsList)
                BodyText(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                        .placeholder(
                            visible = isLoading,
                            highlight = PlaceholderHighlight.shimmer()
                        ),
                    text = information.replaceFirstChar { it.uppercaseChar() },
                    fontSize = 24.sp,
                    maxLines = 3
                )
        }

        BodyText(
            modifier = Modifier
                .constrainAs(plot) {
                    top.linkTo(poster.bottom, margin = 24.dp)
                    bottom.linkTo(parent.bottom, margin = 12.dp)
                    start.linkTo(parent.start, margin = 24.dp)
                    end.linkTo(parent.end, margin = 24.dp)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                }
                .placeholder(
                    visible = isLoading,
                    highlight = PlaceholderHighlight.shimmer()
                ),
            text = movieDetailDataUI.plot,
            fontSize = 24.sp
        )
    }
}