package com.flixclusive.feature.mobile.about.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.flixclusive.core.ui.mobile.util.onMediumEmphasis
import com.flixclusive.core.ui.common.R as UiCommonR
import com.flixclusive.core.util.R as UtilR

@Composable
internal fun Header(
    appName: String,
    versionName: String,
    isInDebugMode: Boolean,
) {
    val appNameUppercase = remember { appName.uppercase() }

    Column(
        verticalArrangement = Arrangement.spacedBy(
            space = 12.dp,
            alignment = Alignment.CenterVertically
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 25.dp)
    ) {
        Image(
            painter = painterResource(id = UiCommonR.mipmap.ic_launcher_foreground),
            contentDescription = stringResource(UtilR.string.flixclusive_icon_content_desc),
            modifier = Modifier
                .scale(2F)
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(
                space = 6.dp,
                alignment = Alignment.CenterVertically
            ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = appNameUppercase,
                style = MaterialTheme.typography.headlineSmall.copy(fontSize = 16.sp),
            )

            Surface(
                contentColor = LocalContentColor.current.onMediumEmphasis()
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(
                        space = 10.dp,
                        alignment = Alignment.CenterHorizontally
                    ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = versionName,
                        style = MaterialTheme.typography.headlineSmall.copy(
                            fontSize = 13.sp
                        ),
                    )

                    Spacer(
                        modifier = Modifier
                            .height(2.dp)
                            .width(10.dp)
                            .background(
                                LocalContentColor.current,
                                MaterialTheme.shapes.large,
                            )
                    )

                    Text(
                        text = if (isInDebugMode) stringResource(id =  UtilR.string.debug) else stringResource(id =  UtilR.string.release),
                        style = MaterialTheme.typography.headlineSmall.copy(
                            fontSize = 13.sp
                        ),
                    )
                }
            }
        }
    }
}