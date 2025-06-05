package com.miapp.kairos24h.tabletAPK;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 22\u00020\u0001:\u00012B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0018\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0017H\u0002J\b\u0010\u001d\u001a\u00020\u0011H\u0002J$\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0017H\u0003J\u0010\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020%H\u0016J\u0012\u0010&\u001a\u00020\u00112\b\u0010\'\u001a\u0004\u0018\u00010(H\u0015J\b\u0010)\u001a\u00020\u0011H\u0014J\u0010\u0010*\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u0019H\u0016J\u0010\u0010,\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\u0017H\u0002J\b\u0010.\u001a\u00020\u0011H\u0002J\b\u0010/\u001a\u00020\u0011H\u0002J\b\u00100\u001a\u00020\u0011H\u0002J\n\u00101\u001a\u00020!*\u00020\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00060\u000ej\u0002`\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00063"}, d2 = {"Lcom/miapp/kairos24h/tabletAPK/MainActivityTablet;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "campoTexto", "Landroid/widget/EditText;", "duracionMensajeMs", "", "handler", "Landroid/os/Handler;", "mediaPlayer", "Landroid/media/MediaPlayer;", "mensajeDinamico", "Landroid/widget/TextView;", "stringBuilder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "animarBoton", "", "button", "Landroid/widget/Button;", "borrarCampoTexto", "enviarFichajeAServidor", "url", "", "hayConexionInternet", "", "manejarCodigoEntradaSalida", "codigo", "tipo", "mostrarDialogoConfirmacionSalida", "mostrarMensajeDinamico", "texto", "color", "", "nombreAudio", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onWindowFocusChanged", "hasFocus", "reproducirAudio", "nombreArchivo", "resetearInactividad", "salirAlLauncher", "solicitarPinParaSalir", "toPixelSize", "Companion", "app_debug"})
public final class MainActivityTablet extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    private final android.os.Handler handler = null;
    private android.widget.EditText campoTexto;
    private android.widget.TextView mensajeDinamico;
    @org.jetbrains.annotations.Nullable()
    private android.media.MediaPlayer mediaPlayer;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.StringBuilder stringBuilder = null;
    private final long duracionMensajeMs = 6000L;
    private static final int COLOR_INCORRECTO = 0;
    private static final int COLOR_CORRECTO = 0;
    @org.jetbrains.annotations.NotNull()
    public static final com.miapp.kairos24h.tabletAPK.MainActivityTablet.Companion Companion = null;
    
    public MainActivityTablet() {
        super();
    }
    
    @java.lang.Override()
    @android.annotation.SuppressLint(value = {"ClickableViewAccessibility", "DiscouragedApi", "UseKtx"})
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void mostrarDialogoConfirmacionSalida() {
    }
    
    private final void solicitarPinParaSalir() {
    }
    
    private final void salirAlLauncher() {
    }
    
    @android.annotation.SuppressLint(value = {"ClickableViewAccessibility"})
    private final void mostrarMensajeDinamico(java.lang.String texto, int color, java.lang.String nombreAudio) {
    }
    
    private final void manejarCodigoEntradaSalida(java.lang.String codigo, java.lang.String tipo) {
    }
    
    @kotlin.Suppress(names = {"DEPRECATION"})
    private final boolean hayConexionInternet() {
        return false;
    }
    
    private final void animarBoton(android.widget.Button button) {
    }
    
    private final void resetearInactividad() {
    }
    
    private final void borrarCampoTexto() {
    }
    
    private final void enviarFichajeAServidor(java.lang.String url) {
    }
    
    @kotlin.Suppress(names = {"DiscouragedApi"})
    private final void reproducirAudio(java.lang.String nombreArchivo) {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    @java.lang.Override()
    public void onWindowFocusChanged(boolean hasFocus) {
    }
    
    public final int toPixelSize(@org.jetbrains.annotations.NotNull()
    java.lang.String $this$toPixelSize) {
        return 0;
    }
    
    @java.lang.Override()
    public void onConfigurationChanged(@org.jetbrains.annotations.NotNull()
    android.content.res.Configuration newConfig) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/miapp/kairos24h/tabletAPK/MainActivityTablet$Companion;", "", "()V", "COLOR_CORRECTO", "", "getCOLOR_CORRECTO", "()I", "COLOR_INCORRECTO", "getCOLOR_INCORRECTO", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final int getCOLOR_INCORRECTO() {
            return 0;
        }
        
        public final int getCOLOR_CORRECTO() {
            return 0;
        }
    }
}