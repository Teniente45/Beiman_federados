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
import com.miapp.kairos24h.enlaces_internos.BuildURLmovil


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
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Row {
            Text(
                text = "Ver Cita",
                modifier = Modifier.clickable {
                    webView.loadUrl(BuildURLmovil.verCita(context))
                }
            )
        }
        Row {
            Text(
                text = "Ver informe",
                modifier = Modifier.clickable {
                    webView.loadUrl(BuildURLmovil.verInforme(context))
                }
            )
        }
        Row {
            Text(
                text = "Ver protocolos y póliza de seguros",
                modifier = Modifier.clickable {
                    webView.loadUrl(BuildURLmovil.verProtocoloYSeguridad(context))
                }
            )
        }
        Row {
            Text(
                text = "Pedir alta voluntaria",
                modifier = Modifier.clickable {
                    webView.loadUrl(BuildURLmovil.pedirAltaVoluntaria(context))
                }
            )
        }
        Row {
            Text(
                text = "Subida de documento",
                modifier = Modifier.clickable {
                    webView.loadUrl(BuildURLmovil.subirDocumento(context))
                }
            )
        }
        Row {
            Text(
                text = "Comunicar un parte",
                modifier = Modifier.clickable {
                    webView.loadUrl(BuildURLmovil.comunicarParte(context))
                }
            )
        }
    }
}