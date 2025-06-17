package com.miapp.kairos24h.enlaces_internos

import androidx.compose.foundation.layout.size
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight

object EstilosBeiman {
// == Estilos de los inconos de PantallaFuncional =====================
    // Modificador para ajustar el tamaño de los iconos
    val iconoSize = Modifier.size(60.dp)

    // Estilo del texto debajo de cada icono
    val textoEstilo = TextStyle(
        color = Color(0xFF005BAC), // Azul corporativo
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium
    )
// == Estilos de los inconos de PantallaFuncional =====================


// == Estilos del botón que muestra SolapaWebView =====================
    // Tamaño del botón flotante, define un área cuadrada de 56x56 dp
    val botonSolapaSize = 56.dp
    // Tamaño del icono dentro del botón, para mantener proporción visual adecuada
    val iconoSolapaSize = 28.dp
    // Color de fondo del botón, un tono azul grisáceo para destacar sin ser muy brillante
    val colorFondoBotonSolapa = Color(0xFF005BAC)
    // Color del icono dentro del botón, blanco para buen contraste sobre el fondo azul
    val colorIconoBotonSolapa = Color.White
    // Forma del botón, un círculo perfecto para un diseño moderno y amigable
    val formaCircular = androidx.compose.foundation.shape.CircleShape
// == Estilos del botón que muestra SolapaWebView =====================

}

