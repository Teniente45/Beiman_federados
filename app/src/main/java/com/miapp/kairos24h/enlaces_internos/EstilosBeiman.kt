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


// == Estilos del botón que muestra SolapaWebView (fun NavegadorBeiman) =====================
    // Define el tamaño total del botón flotante circular (alto y ancho en dp)
    val botonSolapaSize = 56.dp

    // Tamaño del icono dentro del botón flotante para mantener una proporción visual adecuada
    val iconoSolapaSize = 28.dp

    // Color de fondo del botón flotante (azul corporativo ligeramente grisáceo)
    val colorFondoBotonSolapa = Color(0xFF005BAC)

    // Color del icono dentro del botón flotante (blanco para buen contraste)
    val colorIconoBotonSolapa = Color.White

    // Forma del botón flotante, definida como círculo perfecto
    val formaCircular = androidx.compose.foundation.shape.CircleShape


    // == Estilos para los botones de NavegadorBeiman =====================
        // Define el padding horizontal general de toda la fila de botones
        val paddingGeneral = 12.dp

        // Define la separación horizontal entre cada botón dentro del NavegadorBeiman
        val espaciadoEntreBotones = 8.dp

        // Define el tamaño del icono dentro de cada botón del NavegadorBeiman
        val tamanoIconoNavegador = 30.dp

        // Define el estilo del texto mostrado debajo de cada icono del NavegadorBeiman
        val estiloTextoNavegador = TextStyle(
            color = Color(0xFF005BAC), // Color azul corporativo para el texto
            fontSize = 12.sp, // Tamaño de fuente pequeño
            fontWeight = FontWeight.SemiBold // Grosor del texto medio-alto para mejor legibilidad
        )

    // == Estilos para los botones de NavegadorBeiman =====================


// == Estilos del botón que muestra SolapaWebView =====================

}
