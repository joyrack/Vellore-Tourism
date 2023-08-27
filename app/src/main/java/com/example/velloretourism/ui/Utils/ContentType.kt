package com.example.velloretourism.ui.Utils

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

enum class ContentType {
    LIST_ONLY, LIST_AND_DETAIL
}

enum class ScreenDimens(
    val spacing: Dp,
    val fontSize: TextUnit,
    val columnSize: Dp
) {
    SMALL(spacing = 16.dp, fontSize = 16.sp, columnSize = 110.dp),
    MEDIUM(spacing = 32.dp, fontSize = 20.sp, columnSize = 170.dp),
    LARGE(spacing = 56.dp, fontSize = 24.sp, columnSize = 240.dp)
}