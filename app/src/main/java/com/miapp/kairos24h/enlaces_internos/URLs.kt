/*
 * Copyright (c) 2025 Juan López
 * Todos los derechos reservados.
 *
 * Este archivo forma parte de la aplicación Kairos24h.
 * Proyecto académico de desarrollo Android.
 */

package com.miapp.kairos24h.enlaces_internos

import android.content.Context
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.miapp.kairos24h.R
import com.miapp.kairos24h.sesionesYSeguridad.AuthManager

// Este objeto centraliza el acceso a los recursos gráficos usados en la aplicación
object ImagenesMovil {
    // Imagen del logo principal que se muestra en la pantalla de login
    @DrawableRes
    val logoCliente = R.drawable.beimancpp
    fun getLogoClienteXPrograma(context: Context): String? {
        val tLogo = AuthManager.getUserCredentials(context).tLogo
        return if (tLogo.isNotBlank() && tLogo != "null") tLogo else null
    }
    val lodoDesarrolladora = R.drawable.logo_i3data



    // Centraliza las características del logo de empresa cliente
    val logoBoxModifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 5.dp)
    // Estilo aplicado al logo (tamaño y proporción)
    val logoModifier = Modifier
        .width(356.dp)
        .height(100.dp)


    // Centraliza las características del contenedor del logo de desarrolladora
    val logoBoxModifierDev = Modifier
        .fillMaxWidth()
    // Estilo aplicado al logo de desarrolladora (tamaño y proporción)
    val logoModifierDev = Modifier
        .width(200.dp)
        .height(75.dp)

    @Composable
    fun LogoClienteRemoto(modifier: Modifier = Modifier) {
        val context = LocalContext.current
        val logoUrl = getLogoClienteXPrograma(context)
        val painter = rememberAsyncImagePainter(
            model = logoUrl ?: R.drawable.beimancpp,
            contentScale = ContentScale.Fit,
            placeholder = painterResource(id = R.drawable.beimancpp),
            error = painterResource(id = R.drawable.beimancpp)
        )

        Image(
            painter = painter,
            contentDescription = "Logo del cliente",
            modifier = modifier
        )
    }
}



// Estás son las URL que se nos mostrarán en el WebView, se usa sólo para logearse desde la APK
object WebViewURL {
    const val HOST = "https://beimancpp.tucitamedica.es"
    const val ENTRY_POINT = "/index.php"
    const val URL_USADA = "$HOST$ENTRY_POINT"

    const val ACTION_LOGIN = "r=wsExterno/loginExterno"

    const val LOGINAPK = "$URL_USADA?$ACTION_LOGIN"
}

// Esta será la URL que construiremos cuando desde el login de nuestra APK introduzcamos el Usuario y la Contraseña
object BuildURLmovil {
    // Remove HOST constant and use function instead
    fun getHost(context: Context): String {
        val tUrlCPP = AuthManager.getUserCredentials(context).tUrlCPP
        val hostFinal = if (tUrlCPP.isNotBlank() && tUrlCPP != "null") tUrlCPP else WebViewURL.HOST
        android.util.Log.d("BuildURLmovil", "Host seleccionado: $hostFinal")
        return hostFinal
    }
    const val ENTRY_POINT = "/index.php"
    fun getURLUsada(context: Context): String = getHost(context) + ENTRY_POINT + "?"

    const val ACTION_FORGOTPASS = "r=site/solicitudRestablecerClave"
    const val ACTION_LOGIN = "r=site/index"
    const val ACTION_VERCITA = ""
    const val ACTION_VERINFORME = ""
    const val ACTION_VERPROTOCOLOYSEGURIDAD = ""
    const val ACTION_PEDIRALTAVOLUNTARIA = ""
    const val ACTION_SUBIRDOCUMENTO = ""
    const val ACTION_COMUNICARPARTE = ""


    fun getIndex(context: Context): String = getURLUsada(context) + ACTION_LOGIN
    fun getForgotPassword(context: Context): String = getURLUsada(context) + ACTION_FORGOTPASS

    fun verCita(context: Context): String {
        val url = getURLUsada(context) + ACTION_VERCITA
        return url
    }

    fun verInforme(context: Context): String {
        val url = getURLUsada(context) + ACTION_VERINFORME
        return url
    }

    fun verProtocoloYSeguridad(context: Context): String {
        val url = getURLUsada(context) + ACTION_VERPROTOCOLOYSEGURIDAD
        return url
    }

    fun pedirAltaVoluntaria(context: Context): String {
        val url = getURLUsada(context) + ACTION_PEDIRALTAVOLUNTARIA
        return url
    }

    fun subirDocumento(context: Context): String {
        val url = getURLUsada(context) + ACTION_SUBIRDOCUMENTO
        return url
    }

    fun comunicarParte(context: Context): String {
        val url = getURLUsada(context) + ACTION_COMUNICARPARTE
        return url
    }

    const val X_GRUPO = ""
    const val C_KIOSKO = ""
    const val C_FIC_ORI = "APP"

    fun getStaticParams(context: Context): String {
        val creds = AuthManager.getUserCredentials(context)
        val xEntidad = creds.xEntidad ?: ""
        val xEmpleado = creds.xEmpleado ?: ""
        return "&xGrupo=$X_GRUPO" +
                "&xEntidad=$xEntidad" +
                "&xEmpleado=$xEmpleado" +
                "&cKiosko=$C_KIOSKO" +
                "&cFicOri=$C_FIC_ORI"
    }
}