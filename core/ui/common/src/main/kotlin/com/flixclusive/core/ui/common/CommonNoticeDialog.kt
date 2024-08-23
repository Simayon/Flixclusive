package com.flixclusive.core.ui.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.flixclusive.core.theme.FlixclusiveTheme
import com.flixclusive.core.ui.common.util.onMediumEmphasis
import com.flixclusive.core.util.R as UtilR

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommonNoticeDialog(
    label: String,
    description: String,
    confirmButtonLabel: String = stringResource(id = UtilR.string.ok),
    dismissButtonLabel: String = stringResource(id = UtilR.string.cancel),
    onConfirm: () -> Unit,
    onDismiss: () -> Unit,
) {
    val buttonMinHeight = 60.dp

    BasicAlertDialog(
        onDismissRequest = onDismiss
    ) {
        Surface(
            shape = RoundedCornerShape(10),
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(180.dp)
                    .padding(10.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = label,
                        style = MaterialTheme.typography.labelLarge.copy(
                            fontWeight = FontWeight.Bold,
                            fontSize = 17.sp
                        ),
                        color = MaterialTheme.colorScheme.onSurface,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(10.dp)
                    )

                    Text(
                        text = description,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurface,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 20.dp)
                            .padding(horizontal = 10.dp)
                    )
                }

                Row(
                    verticalAlignment = Alignment.Bottom
                ) {
                    Button(
                        onClick = {
                            onConfirm()
                            onDismiss()
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary.onMediumEmphasis(),
                            contentColor = Color.Black
                        ),
                        shape = MaterialTheme.shapes.medium,
                        modifier = Modifier
                            .weight(1F)
                            .heightIn(min = buttonMinHeight)
                            .padding(5.dp)
                    ) {
                        Text(
                            text = confirmButtonLabel,
                            style = MaterialTheme.typography.labelLarge,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(end = 2.dp)
                        )
                    }

                    Button(
                        onClick = onDismiss,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.surfaceVariant,
                            contentColor = MaterialTheme.colorScheme.onSurfaceVariant
                        ),
                        shape = MaterialTheme.shapes.medium,
                        modifier = Modifier
                            .weight(1F)
                            .heightIn(min = buttonMinHeight)
                            .padding(5.dp)
                    ) {
                        Text(
                            text = dismissButtonLabel,
                            style = MaterialTheme.typography.labelLarge,
                            fontWeight = FontWeight.Light
                        )
                    }
                }
            }
        }
    }
}


@Preview
@Composable
private fun CommonNoticeDialogPreview() {
    FlixclusiveTheme {
        Surface {
            CommonNoticeDialog(
                label = "Alert!",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis vel turpis placerat, accumsan nisi vel, consequat purus. Nulla at tortor urna. Aenean vitae urna sem. Nunc turpis odio, pharetra in pretium vitae, fermentum id urna. Maecenas eleifend consequat leo, id sagittis augue varius nec. Curabitur varius, sapien vitae hendrerit condimentum,",
                onConfirm = {},
                onDismiss = {}
            )
        }
    }
}