/*
 * Copyright (c) 2025 Juan López
 * Todos los derechos reservados.
 *
 * Este archivo forma parte de la aplicación Kairos24h.
 * Proyecto académico de desarrollo Android.
 */

package com.miapp.kairos24h.movilAPK

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.webkit.WebView
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.miapp.beiman_federados.R
import com.miapp.kairos24h.enlaces_internos.BuildURLmovil
import com.miapp.kairos24h.enlaces_internos.EstilosBeiman
import com.miapp.kairos24h.enlaces_internos.ImagenesMovil


//============================== CUADRO PARA FICHAR ======================================
@Composable
fun SolapaWebView(
    isVisibleState: MutableState<Boolean>,
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

    // Cambiar que se accione por comportamiento de botón
    if (isVisibleState.value) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .verticalScroll(rememberScrollState())
                .zIndex(2f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(modifier = Modifier.padding(top = EstilosBeiman.Dimensiones.logoPaddingTop, bottom = EstilosBeiman.Dimensiones.logoPaddingBottom)) {
                Logo_empresa_cliente()
            }
            Box(modifier = Modifier.padding(top = EstilosBeiman.Dimensiones.navegadorPaddingTop, bottom = EstilosBeiman.Dimensiones.navegadorPaddingBottom)) {
                NavegadorBeiman(isVisibleState, webView, LocalContext.current)
            }
            Box(modifier = Modifier.padding(top = EstilosBeiman.Dimensiones.desarrolladoraPaddingTop, bottom = EstilosBeiman.Dimensiones.desarrolladoraPaddingBottom)) {
                Logo_empresa_desarrolladora()
            }
        }
    }
}

@Composable
fun Logo_empresa_cliente() {
    Box {
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
fun NavegadorIcono(label: String, iconRes: Int, onClick: () -> Unit) {
    var scale by remember { mutableFloatStateOf(1f) }
    val animatedScale by animateFloatAsState(
        targetValue = scale,
        animationSpec = tween(durationMillis = 600),
        label = ""
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .graphicsLayer(scaleX = animatedScale, scaleY = animatedScale)
            .clickable {
                scale = 1.2f
                onClick()
                Handler(Looper.getMainLooper()).postDelayed({
                    scale = 1f
                }, 1000)
            }
            .padding(bottom = 2.dp) // padding inferior general mínimo entre bloques
    ) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = label,
            modifier = Modifier.size(EstilosBeiman.Dimensiones.iconSize)
        )
        Spacer(modifier = Modifier.height(EstilosBeiman.Dimensiones.iconTextSpacing)) // separación entre imagen y texto

        val lineCount = 3
        val paddedLabel = buildString {
            append(label)
            val lines = label.count { it == '\n' } + 1
            repeat(maxOf(0, lineCount - lines)) {
                append("\n\u00A0")
            }
        }

        Text(
            text = paddedLabel,
            style = EstilosBeiman.textoEstilo.copy(
                fontSize = EstilosBeiman.Dimensiones.textFontSize,
                color = Color(0xFF0652A1)
            ),
            textAlign = TextAlign.Center,
            softWrap = true,
            maxLines = 3,
            modifier = Modifier.width(EstilosBeiman.Dimensiones.textWidth)
        )
    }
}

@Composable
fun NavegadorBeiman(isVisibleState: MutableState<Boolean>, webView: WebView, context: Context) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = EstilosBeiman.Dimensiones.paddingHorizontal, vertical = EstilosBeiman.Dimensiones.paddingVertical)
            .background(Color.Transparent),
        horizontalArrangement = Arrangement.spacedBy(EstilosBeiman.Dimensiones.rowSpacing, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.Top
    ) {
        Box(modifier = Modifier.align(Alignment.Top)) {
            Column(
                verticalArrangement = Arrangement.spacedBy(EstilosBeiman.Dimensiones.columnSpacing),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                NavegadorIcono(
                    label = "Mis Citas",
                    iconRes = R.drawable.mis_citas,
                    onClick = {
                        webView.loadUrl(BuildURLmovil.verCita(context))
                        isVisibleState.value = false
                    }
                )
                NavegadorIcono(
                    label = "Mis Datos",
                    iconRes = R.drawable.mis_datos,
                    onClick = {
                        webView.loadUrl(BuildURLmovil.verMisDatos(context))
                        isVisibleState.value = false
                    }
                )
                NavegadorIcono(
                    label = "Póliza de seguros",
                    iconRes = R.drawable.poliza_de_seguros,
                    onClick = {
                        webView.loadUrl(BuildURLmovil.verProtocoloYSeguridad(context))
                        isVisibleState.value = false
                    }
                )
                NavegadorIcono(
                    label = "Comunicar un parte",
                    iconRes = R.drawable.comunicar_un_parte,
                    onClick = {
                        webView.loadUrl(BuildURLmovil.comunicarParte(context))
                        isVisibleState.value = false
                    }
                )
            }
        }
        Box(modifier = Modifier.align(Alignment.Top)) {
            Column(
                verticalArrangement = Arrangement.spacedBy(EstilosBeiman.Dimensiones.columnSpacing),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                NavegadorIcono(
                    label = "Mis informes",
                    iconRes = R.drawable.mis_informes,
                    onClick = {
                        webView.loadUrl(BuildURLmovil.verInforme(context))
                        isVisibleState.value = false
                    }
                )
                NavegadorIcono(
                    label = "Mis accidentes deportivos",
                    iconRes = R.drawable.mis_partes,
                    onClick = {
                        webView.loadUrl(BuildURLmovil.verParteMedico(context))
                        isVisibleState.value = false
                    }
                )
                NavegadorIcono(
                    label = "Tramitar alta voluntaria",
                    iconRes = R.drawable.tramitar_alta_voluntaria,
                    onClick = {
                        webView.loadUrl(BuildURLmovil.pedirAltaVoluntaria(context))
                        isVisibleState.value = false
                    }
                )
                NavegadorIcono(
                    label = "Subir un documento",
                    iconRes = R.drawable.subir_documento,
                    onClick = {
                        webView.loadUrl(BuildURLmovil.subirDocumento(context))
                        isVisibleState.value = false
                    }
                )
            }
        }
    }
}

// Previsualización en tiempo real de SolapaWebView
@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true)
@Composable
fun PreviewSolapaWebView() {
    val context = LocalContext.current
    SolapaWebView(
        isVisibleState = mutableStateOf(true),
        webView = WebView(context)
    )
}