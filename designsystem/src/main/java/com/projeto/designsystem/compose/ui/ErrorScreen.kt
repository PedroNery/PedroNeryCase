package com.projeto.designsystem.compose.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.projeto.designsystem.R
import com.projeto.designsystem.compose.components.ButtonText
import com.projeto.designsystem.compose.components.TitleText

@Composable
fun ErrorScreen(
    onClickButton : () -> Unit
) {
    
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
    ) {

        val column = createRef()

        Column(
            modifier = Modifier
                .constrainAs(column) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ) {
            Image(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                painter = painterResource(id = R.drawable.ic_error_default),
                contentDescription = "Error Image"
            )
            TitleText(
                modifier = Modifier
                    .padding(
                        top = dimensionResource(id = R.dimen.error_button_top_padding)
                    )
                    .align(Alignment.CenterHorizontally),
                text = "Algo deu errado",
                fontSize = 24.sp
            )
            OutlinedButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(dimensionResource(id = R.dimen.error_screen_button_height))
                    .padding(
                        start = dimensionResource(id = R.dimen.error_button_horizontal_padding),
                        end = dimensionResource(id = R.dimen.error_button_horizontal_padding),
                        top = dimensionResource(id = R.dimen.error_button_top_padding)
                    ),
                onClick = { onClickButton() },
                border = BorderStroke(1.dp, colorResource(R.color.colorPrimary)),
                shape = RoundedCornerShape(dimensionResource(id = R.dimen.margin_receipt_divider_top)),
                colors = ButtonDefaults.outlinedButtonColors(
                    backgroundColor = colorResource(id = R.color.colorLightPrimary)
                )
            ) {
                ButtonText(text = "Tentar novamente", fontSize = 16.sp)
            }
        }

    }
}