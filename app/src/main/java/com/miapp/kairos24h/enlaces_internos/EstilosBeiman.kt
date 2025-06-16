package com.miapp.kairos24h.enlaces_internos

import androidx.compose.foundation.layout.size
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight

object EstilosBeiman {
    // Modificador para ajustar el tamaño de los iconos
    val iconoSize = Modifier.size(60.dp)

    // Estilo del texto debajo de cada icono
    val textoEstilo = TextStyle(
        color = Color(0xFF005BAC), // Azul corporativo
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium
    )
}
