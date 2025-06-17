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


    // == Estilos para los botones de NavegadorBeiman =====================

    // Define el padding horizontal de la fila que contiene todos los botones.
    // Se puede modificar para ajustar los márgenes laterales del grupo de iconos.
    val paddingHorizontal = 32.dp
    val paddingVertical = 6.dp

    // Define la separación horizontal entre los botones de navegación
    // Aumentar este valor separará más los iconos entre columnas
    val espaciadoEntreBotones = 8.dp

    // Define el tamaño máximo del icono dentro de cada columna del NavegadorBeiman
    // Los textos se ajustarán debajo de este ancho
    val maxIconWidth = 64.dp

    // Tamaño del icono mostrado sobre cada texto de opción en el NavegadorBeiman
    val tamanoIconoNavegador = 30.dp

    // Estilo del texto que aparece debajo de cada icono
    // Puedes ajustar el color, tamaño de fuente o grosor aquí
    val estiloTextoNavegador = TextStyle(
        color = Color(0xFF005BAC), // Color azul corporativo
        fontSize = 12.sp,
        fontWeight = FontWeight.SemiBold
    )

    // == Estilos para los botones de NavegadorBeiman =====================


// == Estilos del botón que muestra SolapaWebView =====================

}
