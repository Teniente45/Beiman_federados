/*
 * Copyright (c) 2025 Juan López
 * Todos los derechos reservados.
 *
 * Este archivo forma parte de la aplicación Kairos24h.
 * Proyecto académico de desarrollo Android.
 */

package com.miapp.kairos24h.movilAPK

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
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
import android.os.Handler
import android.os.Looper
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.ui.unit.sp


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
            Box(modifier = Modifier.padding(top = 8.dp, bottom = 10.dp)) {
                Logo_empresa_cliente()
            }
            Box(modifier = Modifier.padding(top = 20.dp, bottom = 2.dp)) {
                NavegadorBeiman(isVisibleState, webView, LocalContext.current)
            }
            Box(modifier = Modifier.padding(top = 10.dp, bottom = 4.dp)) {
                Logo_empresa_desarrolladora()
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
            modifier = Modifier.size(86.dp)
        )
        Spacer(modifier = Modifier.height(8.dp)) // separación entre imagen y texto

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
                fontSize = 18.sp,
                color = Color(0xFF0652A1)
            ),
            textAlign = TextAlign.Center,
            softWrap = true,
            maxLines = 3,
            modifier = Modifier.width(96.dp)
        )
    }
}

@Composable
fun NavegadorBeiman(isVisibleState: MutableState<Boolean>, webView: WebView, context: Context) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 6.dp, vertical = 1.dp)
            .background(Color.Transparent),
        horizontalArrangement = Arrangement.spacedBy(80.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.Top
    ) {
        Box(modifier = Modifier.align(Alignment.Top)) {
            Column(
                verticalArrangement = Arrangement.spacedBy(20.dp),
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
                verticalArrangement = Arrangement.spacedBy(20.dp),
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