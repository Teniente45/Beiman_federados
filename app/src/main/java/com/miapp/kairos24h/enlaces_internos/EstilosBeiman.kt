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
    // Estilo del texto debajo de cada icono
    val textoEstilo = TextStyle(
        color = Color(0xFF005BAC), // Azul corporativo
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium
    )
// == Estilos de los inconos de PantallaFuncional =====================


    object Dimensiones {
        // Tamaño general de los iconos utilizados en la interfaz (por ejemplo, en botones o columnas)
        val iconSize = 86.dp

        // Espacio vertical entre el icono y el texto que aparece debajo de él
        val iconTextSpacing = 8.dp

        // Tamaño de fuente del texto que acompaña a los iconos
        val textFontSize = 18.sp

        // Ancho máximo que puede ocupar el texto debajo del icono antes de hacer salto de línea
        val textWidth = 96.dp

        // Espaciado horizontal entre columnas (por ejemplo, entre un conjunto de iconos alineados horizontalmente)
        val columnSpacing = 20.dp

        // Espaciado vertical entre filas de iconos o elementos visuales apilados verticalmente
        val rowSpacing = 80.dp

        // Relleno (padding) horizontal interno en los contenedores que enmarcan iconos o bloques
        val paddingHorizontal = 6.dp

        // Relleno (padding) vertical interno en los contenedores que enmarcan iconos o bloques
        val paddingVertical = 1.dp

        // Espacio adicional (margen superior) que se deja por encima del logo principal del cliente
        val logoPaddingTop = 8.dp

        // Espacio adicional (margen inferior) que se deja debajo del logo principal del cliente
        val logoPaddingBottom = 10.dp

        // Espacio superior que se deja entre el borde del contenedor y la barra de navegación inferior (si existe)
        val navegadorPaddingTop = 20.dp

        // Espacio inferior que se deja entre el borde del contenedor y la barra de navegación inferior (si existe)
        val navegadorPaddingBottom = 2.dp

        // Espacio superior aplicado sobre el logo de la desarrolladora (normalmente centrado en la parte inferior de la pantalla)
        val desarrolladoraPaddingTop = 10.dp

        // Espacio inferior aplicado debajo del logo de la desarrolladora
        val desarrolladoraPaddingBottom = 4.dp
    }

// == Estilos del botón que muestra SolapaWebView (fun NavegadorBeiman) =====================
    // Tamaños aumentados para mayor accesibilidad y visibilidad:
    // Define el tamaño total del botón flotante circular (alto y ancho en dp)
    val botonSolapaSize = 80.dp // Tamaño del botón aumentado para mayor accesibilidad

    // Tamaño del icono dentro del botón flotante para mejor visibilidad
    val iconoSolapaSize = 40.dp // Tamaño del icono aumentado para mejor visibilidad

    // Color de fondo del botón flotante (azul corporativo ligeramente grisáceo)
    val colorFondoBotonSolapa = Color(0xFF005BAC)

    // Color del icono dentro del botón flotante (blanco para buen contraste)
    val colorIconoBotonSolapa = Color.White

    // Forma del botón flotante, definida como círculo perfecto
    val formaCircular = androidx.compose.foundation.shape.CircleShape

// == Estilos del botón que muestra SolapaWebView =====================

}
