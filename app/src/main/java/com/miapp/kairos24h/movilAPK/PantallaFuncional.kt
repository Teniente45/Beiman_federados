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
import androidx.compose.material3.Text
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
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .zIndex(2f)
        ) {
            Logo_empresa_cliente()
            Logo_empresa_desarrolladora()
            NavegadorBeiman(isVisibleState, webView, androidx.compose.ui.platform.LocalContext.current)
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
fun NavegadorBeiman(isVisibleState: MutableState<Boolean>, webView: WebView, context: Context) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(EstilosBeiman.paddingGeneral),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(EstilosBeiman.espaciadoEntreBotones)
        ) {
            var scaleMisCitas by remember { mutableFloatStateOf(1f) }
            val animatedScaleMisCitas by animateFloatAsState(
                targetValue = scaleMisCitas,
                animationSpec = tween(durationMillis = 600),
                label = ""
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .graphicsLayer(scaleX = animatedScaleMisCitas, scaleY = animatedScaleMisCitas)
                    .clickable {
                        scaleMisCitas = 1.2f
                        webView.loadUrl(BuildURLmovil.verCita(context))
                        Handler(Looper.getMainLooper()).postDelayed({
                            isVisibleState.value = false
                            scaleMisCitas = 1f
                        }, 1000)
                    }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.mis_citas),
                    contentDescription = "Icono Mis Citas",
                    modifier = EstilosBeiman.iconoSize
                )
                Text(text = "Mis Citas", style = EstilosBeiman.textoEstilo)
            }

            var scalePoliza by remember { mutableFloatStateOf(1f) }
            val animatedScalePoliza by animateFloatAsState(
                targetValue = scalePoliza,
                animationSpec = tween(durationMillis = 600),
                label = ""
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .graphicsLayer(scaleX = animatedScalePoliza, scaleY = animatedScalePoliza)
                    .clickable {
                        scalePoliza = 1.2f
                        webView.loadUrl(BuildURLmovil.verProtocoloYSeguridad(context))
                        Handler(Looper.getMainLooper()).postDelayed({
                            isVisibleState.value = false
                            scalePoliza = 1f
                        }, 1000)
                    }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.poliza_de_seguros),
                    contentDescription = "Icono Póliza de seguros",
                    modifier = EstilosBeiman.iconoSize
                )
                Text(text = "Póliza de seguros", style = EstilosBeiman.textoEstilo)
            }

            var scaleComunicarParte by remember { mutableFloatStateOf(1f) }
            val animatedScaleComunicarParte by animateFloatAsState(
                targetValue = scaleComunicarParte,
                animationSpec = tween(durationMillis = 600),
                label = ""
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .graphicsLayer(scaleX = animatedScaleComunicarParte, scaleY = animatedScaleComunicarParte)
                    .clickable {
                        scaleComunicarParte = 1.2f
                        webView.loadUrl(BuildURLmovil.comunicarParte(context))
                        Handler(Looper.getMainLooper()).postDelayed({
                            isVisibleState.value = false
                            scaleComunicarParte = 1f
                        }, 1000)
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
            verticalArrangement = Arrangement.spacedBy(EstilosBeiman.espaciadoEntreBotones)
        ) {
            var scaleMisInformes by remember { mutableFloatStateOf(1f) }
            val animatedScaleMisInformes by animateFloatAsState(
                targetValue = scaleMisInformes,
                animationSpec = tween(durationMillis = 600),
                label = ""
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .graphicsLayer(scaleX = animatedScaleMisInformes, scaleY = animatedScaleMisInformes)
                    .clickable {
                        scaleMisInformes = 1.2f
                        webView.loadUrl(BuildURLmovil.verInforme(context))
                        Handler(Looper.getMainLooper()).postDelayed({
                            isVisibleState.value = false
                            scaleMisInformes = 1f
                        }, 1000)
                    }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.mis_informes),
                    contentDescription = "Icono Mis informes",
                    modifier = EstilosBeiman.iconoSize
                )
                Text(text = "Mis informes", style = EstilosBeiman.textoEstilo)
            }

            var scaleAltaVoluntaria by remember { mutableFloatStateOf(1f) }
            val animatedScaleAltaVoluntaria by animateFloatAsState(
                targetValue = scaleAltaVoluntaria,
                animationSpec = tween(durationMillis = 600),
                label = ""
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .graphicsLayer(scaleX = animatedScaleAltaVoluntaria, scaleY = animatedScaleAltaVoluntaria)
                    .clickable {
                        scaleAltaVoluntaria = 1.2f
                        webView.loadUrl(BuildURLmovil.pedirAltaVoluntaria(context))
                        Handler(Looper.getMainLooper()).postDelayed({
                            isVisibleState.value = false
                            scaleAltaVoluntaria = 1f
                        }, 1000)
                    }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.tramitar_alta_voluntaria),
                    contentDescription = "Icono Tramitar alta voluntaria",
                    modifier = EstilosBeiman.iconoSize
                )
                Text(text = "Tramitar alta voluntaria", style = EstilosBeiman.textoEstilo)
            }

            var scaleSubirDocumento by remember { mutableFloatStateOf(1f) }
            val animatedScaleSubirDocumento by animateFloatAsState(
                targetValue = scaleSubirDocumento,
                animationSpec = tween(durationMillis = 600),
                label = ""
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .graphicsLayer(scaleX = animatedScaleSubirDocumento, scaleY = animatedScaleSubirDocumento)
                    .clickable {
                        scaleSubirDocumento = 1.2f
                        webView.loadUrl(BuildURLmovil.subirDocumento(context))
                        Handler(Looper.getMainLooper()).postDelayed({
                            isVisibleState.value = false
                            scaleSubirDocumento = 1f
                        }, 1000)
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
