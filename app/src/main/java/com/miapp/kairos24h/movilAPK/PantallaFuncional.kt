/*
 * Copyright (c) 2025 Juan López
 * Todos los derechos reservados.
 *
 * Este archivo forma parte de la aplicación Kairos24h.
 * Proyecto académico de desarrollo Android.
 */

package com.miapp.kairos24h.movilAPK

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.miapp.kairos24h.enlaces_internos.ImagenesMovil
import android.webkit.WebView
import androidx.compose.foundation.clickable
import android.content.Context
import com.miapp.beiman_federados.R
import com.miapp.kairos24h.enlaces_internos.BuildURLmovil
import com.miapp.kairos24h.enlaces_internos.EstilosBeiman


//============================== CUADRO PARA FICHAR ======================================
@Composable
fun SolapaWebView(
    isVisibleState: MutableState<Boolean>,
    fichajes: List<String>,
    webView: WebView
) {
    // Mover refreshTrigger fuera del if para que se ejecute siempre
    val refreshTrigger = remember { mutableLongStateOf(System.currentTimeMillis()) }
    // Añadir observer de ON_RESUME para refrescar el trigger
    val lifecycleOwner = LocalLifecycleOwner.current
    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_RESUME) {
                refreshTrigger.longValue = System.currentTimeMillis()
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }
    if (isVisibleState.value) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .zIndex(2f)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .fillMaxSize()
                    // Habilita el scroll vertical:
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 20.dp)
            ) {
                // Mostrar lista de fichajes si existe
                if (fichajes.isNotEmpty()) {
                    Text(text = "Fichajes del Día", color = Color.Blue)
                    fichajes.forEach { fichaje ->
                        Text(text = fichaje, color = Color.DarkGray)
                    }
                }
                Logo_empresa_cliente()
                Logo_empresa_desarrolladora()
                NavegadorBeiman(webView, androidx.compose.ui.platform.LocalContext.current)
            }
        }
    }
}

@Composable
fun Logo_empresa_cliente() {
    Box(
        modifier = ImagenesMovil.logoBoxModifier,
        contentAlignment = Alignment.Center
    ) {
        ImagenesMovil.LogoClienteRemoto()
    }
}

@Composable
fun Logo_empresa_desarrolladora() {
    Box(
        modifier = ImagenesMovil.logoBoxModifierDev,
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = ImagenesMovil.lodoDesarrolladora),
            contentDescription = "logo de la desarrolladora",
            modifier = ImagenesMovil.logoModifierDev
        )
    }
}

@Composable
fun NavegadorBeiman(webView: WebView, context: Context) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.clickable {
                    webView.loadUrl(BuildURLmovil.verCita(context))
                }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.mis_citas),
                    contentDescription = "Icono Mis Citas",
                    modifier = EstilosBeiman.iconoSize
                )
                Text(text = "Mis Citas", style = EstilosBeiman.textoEstilo)
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.clickable {
                    webView.loadUrl(BuildURLmovil.verProtocoloYSeguridad(context))
                }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.poliza_de_seguros),
                    contentDescription = "Icono Póliza de seguros",
                    modifier = EstilosBeiman.iconoSize
                )
                Text(text = "Póliza de seguros", style = EstilosBeiman.textoEstilo)
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.clickable {
                    webView.loadUrl(BuildURLmovil.comunicarParte(context))
                }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.comunicar_un_parte),
                    contentDescription = "Icono Comunicar un parte",
                    modifier = EstilosBeiman.iconoSize
                )
                Text(text = "Comunicar un parte", style = EstilosBeiman.textoEstilo)
            }
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.clickable {
                    webView.loadUrl(BuildURLmovil.verInforme(context))
                }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.mis_informes),
                    contentDescription = "Icono Mis informes",
                    modifier = EstilosBeiman.iconoSize
                )
                Text(text = "Mis informes", style = EstilosBeiman.textoEstilo)
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.clickable {
                    webView.loadUrl(BuildURLmovil.pedirAltaVoluntaria(context))
                }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.tramitar_alta_voluntaria),
                    contentDescription = "Icono Tramitar alta voluntaria",
                    modifier = EstilosBeiman.iconoSize
                )
                Text(text = "Tramitar alta voluntaria", style = EstilosBeiman.textoEstilo)
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.clickable {
                    webView.loadUrl(BuildURLmovil.subirDocumento(context))
                }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.subir_documento),
                    contentDescription = "Icono Subir un documento",
                    modifier = EstilosBeiman.iconoSize
                )
                Text(text = "Subir un documento", style = EstilosBeiman.textoEstilo)
            }
        }
    }
}
