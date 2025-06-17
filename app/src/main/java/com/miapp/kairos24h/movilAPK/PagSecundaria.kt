/*
 * Copyright (c) 2025 Juan López
 * Todos los derechos reservados.
 *
 * Este archivo forma parte de la aplicación Kairos24h.
 * Proyecto académico de desarrollo Android.
 */

@file:Suppress("DEPRECATION")

package com.miapp.kairos24h.movilAPK


import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.webkit.CookieManager
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.FrameLayout
import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.miapp.beiman_federados.R
import com.miapp.kairos24h.PaginaPrincipal
import com.miapp.kairos24h.enlaces_internos.BuildURLmovil
import com.miapp.kairos24h.enlaces_internos.EstilosBeiman
import com.miapp.kairos24h.sesionesYSeguridad.AuthManager
import com.miapp.kairos24h.sesionesYSeguridad.ManejoDeSesion
import kotlinx.coroutines.delay

class PaginaSecundaria : ComponentActivity() {

    private lateinit var webView: WebView
    private val handler = Handler(Looper.getMainLooper())
    private val sessionTimeoutMillis = 2 * 60 * 60 * 1000L // 2 horas

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WebView.setWebContentsDebuggingEnabled(true)
        Log.d("Fichar", "onCreate iniciado")

        val (storedUser, storedPassword, _) = AuthManager.getUserCredentials(this)

        if (storedUser.isEmpty() || storedPassword.isEmpty()) {
            navigateToLogin()
            return
        }

        // Creamos el FrameLayout raíz
        val root = FrameLayout(this).apply { id = View.generateViewId() }

        // Creamos y configuramos el WebView
        webView = WebView(this).apply {
            val webSettings = settings
            webSettings.javaScriptEnabled = true
            webSettings.loadWithOverviewMode = true
            webSettings.useWideViewPort = true
            webSettings.domStorageEnabled = true
            webSettings.setSupportZoom(true)
            webSettings.builtInZoomControls = true
            webSettings.displayZoomControls = false
            webSettings.javaScriptCanOpenWindowsAutomatically = true
            webSettings.setSupportMultipleWindows(true)
            webSettings.databaseEnabled = true
            webSettings.allowFileAccess = true
            webSettings.allowContentAccess = true
            webSettings.userAgentString =
                "Mozilla/5.0 (Linux; Android 10; Mobile) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/110.0.0.0 Mobile Safari/537.36"

            // Habilitar scrollbars dentro del área visible
            isVerticalScrollBarEnabled = true
            isHorizontalScrollBarEnabled = true
            scrollBarStyle = WebView.SCROLLBARS_INSIDE_OVERLAY

            webChromeClient = object : WebChromeClient() {
                override fun onCreateWindow(
                    view: WebView?,
                    isDialog: Boolean,
                    isUserGesture: Boolean,
                    resultMsg: Message?
                ): Boolean {
                    val newWebView = WebView(view!!.context)
                    newWebView.settings.javaScriptEnabled = true
                    newWebView.settings.javaScriptCanOpenWindowsAutomatically = true
                    newWebView.settings.setSupportMultipleWindows(true)
                    newWebView.settings.domStorageEnabled = true
                    newWebView.settings.databaseEnabled = true
                    newWebView.settings.allowFileAccess = true
                    newWebView.settings.allowContentAccess = true

                    val transport = resultMsg?.obj as WebView.WebViewTransport
                    transport.webView = newWebView
                    resultMsg.sendToTarget()

                    return true
                }
            }

            webViewClient = object : WebViewClient() {
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    // Decodifica la contraseña antes de insertarla en el formulario
                    val passwordCodificada = AuthManager.getUserCredentials(this@PaginaSecundaria).password
                    val password = java.net.URLDecoder.decode(passwordCodificada, "UTF-8")
                    // Decodifica el usuario antes de insertarlo en el formulario
                    val usuarioCodificado = AuthManager.getUserCredentials(this@PaginaSecundaria).usuario
                    val usuario = java.net.URLDecoder.decode(usuarioCodificado, "UTF-8")
                    view?.evaluateJavascript(
                        """
                        (function() {
                            isMobile = () => true;
                            document.getElementsByName('LoginForm[username]')[0].value = '$usuario';
                            document.getElementsByName('LoginForm[password]')[0].value = '$password';
                            document.querySelector('form').submit();
                            
                            setTimeout(function() {
                                var panels = document.querySelectorAll('.panel, .panel-body, .panel-heading');
                                panels.forEach(function(panel) {
                                    panel.style.display = 'block';
                                    panel.style.visibility = 'visible';
                                    panel.style.opacity = '1';
                                    panel.style.maxHeight = 'none';
                                });
                                document.body.style.overflow = 'auto';
                                document.documentElement.style.overflow = 'auto';
                            }, 3000);
                        })();
                        """.trimIndent(),
                        null
                    )
                }
            }

            loadUrl(BuildURLmovil.getIndex(this@PaginaSecundaria))
        }

        // ComposeView superpuesto
        val composeView = ComposeView(this).apply {
            setContent {
                WebViewScreen(
                    webView = webView,
                    onLogout = { navigateToLogin() }
                )
            }
        }

        // Ajuste de LayoutParams para WebView: altura delimitada por barra superior (30dp) y barra inferior (56dp)
        val displayMetrics = resources.displayMetrics
        val topMarginPx = (30 * displayMetrics.density).toInt()
        val bottomMarginPx = (56 * displayMetrics.density).toInt()

        val webViewLayoutParams = FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        ).apply {
            topMargin = topMarginPx
            bottomMargin = bottomMarginPx
        }

        root.addView(
            webView,
            webViewLayoutParams
        )
        root.addView(
            composeView,
            FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        )

        setContentView(root)

        ManejoDeSesion.startActivitySimulationTimer(handler, webView, sessionTimeoutMillis)
    }


    // Método del ciclo de vida que notifica pausa a la lógica de sesión
    override fun onPause() {
        super.onPause()
        ManejoDeSesion.onPause()
    }

    override fun onStop() {
        super.onStop()
        ManejoDeSesion.onStop(webView)
    }

    override fun onResume() {
        super.onResume()
        ManejoDeSesion.onResume(webView)
    }

    // Redirige a la pantalla de login eliminando cookies, datos de sesión y reinicia la actividad
    private fun navigateToLogin() {
        val cookieManager = CookieManager.getInstance()
        cookieManager.removeAllCookies(null)
        cookieManager.flush()

        val sharedPreferences = getSharedPreferences("UserSession", MODE_PRIVATE)
        with(sharedPreferences.edit()) {
            remove("usuario")
            remove("password")
            apply()
        }

        val intent = Intent(this, PaginaPrincipal::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }
    // Manejador principal usado para controlar los tiempos de la sesión activa
}

// Composable principal de la pantalla de fichaje. Muestra WebView con login automático, cuadro para fichar, barra superior e inferior y lógica de navegación.
@SuppressLint("SetJavaScriptEnabled")
@Composable
fun WebViewScreen(
    webView: WebView,
    onLogout: () -> Unit
) {
    // Controla si debe mostrarse la pantalla de carga
    var isLoading by remember { mutableStateOf(true) }
    // Siempre visible al iniciar PagSecundaria, hasta que el usuario lo cierre manualmente
    val showSolapaWebViewState = rememberSaveable { mutableStateOf(true) }
    // Ámbito de corrutina usado para manejar delays y tareas asincrónicas
    // Controla la visibilidad del diálogo de confirmación para cerrar sesión
    val showLogoutDialog = remember { mutableStateOf(false) }


    // Ya no se necesita webViewState; usamos webView directamente
    // Contexto actual de la aplicación (necesario para acceder a preferencias y otros recursos)
    val context = LocalContext.current
    // Accede a las preferencias guardadas del usuario (credenciales y flags)
    val sharedPreferences = context.getSharedPreferences("UserSession", Context.MODE_PRIVATE)
    // Recupera el nombre de usuario desde las preferencias o usa valor por defecto
    val cUsuario = sharedPreferences.getString("usuario", "Usuario") ?: "Usuario"

    // Simula carga inicial de 1,5 segundos antes de mostrar contenido
    LaunchedEffect(Unit) {
        isLoading = true
        delay(1500)
        isLoading = false
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(WindowInsets.systemBars.asPaddingValues())
    ) {
        // Barra superior con avatar del usuario y botón para cerrar sesión
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
                .background(Color(0xFFE2E4E5))
                .padding(2.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Sección izquierda: icono de avatar fijo + nombre del usuario
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.cliente32),
                    contentDescription = "Usuario",
                    modifier = Modifier.size(30.dp),
                    tint = Color.Unspecified
                )
                Text(
                    text = cUsuario,
                    color = Color(0xFF7599B6),
                    fontSize = 18.sp
                )
            }
            // Sección derecha: botón para cerrar sesión, abre un diálogo de confirmación
            IconButton(onClick = { showLogoutDialog.value = true }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_cerrar32),
                    contentDescription = "Cerrar sesión",
                    modifier = Modifier.size(30.dp),
                    tint = Color.Unspecified
                )
            }
        }

        // Contenedor central que ocupa el espacio restante; contiene el WebView, cuadro de fichaje y mensajes
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            // Pantalla de carga que se muestra mientras se realiza la autenticación automática
            LoadingScreen(isLoading = isLoading)
            // Solapa blanca superpuesta al WebView
            SolapaWebView(
                isVisibleState = showSolapaWebViewState,
                webView = webView
            )
        }

        // Barra inferior: botón flotante circular centrado para mostrar el cuadro de fichaje
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            contentAlignment = Alignment.Center
        ) {
            IconButton(
                onClick = { showSolapaWebViewState.value = true },
                modifier = Modifier
                    .size(EstilosBeiman.botonSolapaSize)
                    .background(EstilosBeiman.colorFondoBotonSolapa, shape = EstilosBeiman.formaCircular)
                    .zIndex(2f)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.menu_opciones),
                    contentDescription = "Abrir menú",
                    tint = EstilosBeiman.colorIconoBotonSolapa,
                    modifier = Modifier.size(EstilosBeiman.iconoSolapaSize)
                )
            }
        }
    }

    // Diálogo modal que solicita confirmación para cerrar la sesión
    if (showLogoutDialog.value) {
        AlertDialog(
            onDismissRequest = { showLogoutDialog.value = false },
            title = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFF7599B6))
                        .padding(12.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "¿Cerrar sesión?",
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            },
            text = {
                Text(
                    "Si continuas cerrarás tu sesión, ¿Seguro que es lo que quieres hacer?",
                    color = Color.Black
                )
            },
            confirmButton = {},
            dismissButton = {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Button(
                        onClick = {
                            showLogoutDialog.value = false
                            webView.apply {
                                clearCache(true)
                                clearHistory()
                            }
                            CookieManager.getInstance().removeAllCookies(null)
                            CookieManager.getInstance().flush()
                            AuthManager.clearAllUserData(context)
                            onLogout()
                        },
                        modifier = Modifier.weight(1f),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF7599B6),
                            contentColor = Color.White
                        ),
                        shape = RectangleShape
                    ) {
                        Text("Sí")
                    }

                    Spacer(modifier = Modifier.width(30.dp))

                    Button(
                        onClick = {
                            showLogoutDialog.value = false
                        },
                        modifier = Modifier.weight(1f),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF7599B6),
                            contentColor = Color.White
                        ),
                        shape = RectangleShape
                    ) {
                        Text("No")
                    }
                }
            },
            shape = RoundedCornerShape(30.dp)
        )
    }
}

// ================================== Preview de la pantalla ==================================
@Composable
@Preview(showBackground = true)
fun PreviewWebViewScreen() {
    // No se puede previsualizar el WebView real en preview, así que pasamos un dummy
    WebViewScreen(
        webView = WebView(LocalContext.current),
        onLogout = {}
    )
}
// ================================== Preview de la pantalla ==================================


@Composable
fun LoadingScreen(isLoading: Boolean) {
    if (isLoading) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .zIndex(2f),
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(R.drawable.version_2)
                    .build(),
                contentDescription = "Cargando...",
            )
        }
    }
}