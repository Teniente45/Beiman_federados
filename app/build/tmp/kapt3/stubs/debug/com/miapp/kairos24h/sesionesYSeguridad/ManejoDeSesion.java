package com.miapp.kairos24h.sesionesYSeguridad;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0086@\u00a2\u0006\u0002\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u000b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nJ \u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/miapp/kairos24h/sesionesYSeguridad/ManejoDeSesion;", "", "()V", "obtenerFechaHoraInternet", "Ljava/util/Date;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPause", "", "onResume", "webView", "Landroid/webkit/WebView;", "onStop", "startActivitySimulationTimer", "handler", "Landroid/os/Handler;", "sessionTimeoutMillis", "", "app_debug"})
public final class ManejoDeSesion {
    @org.jetbrains.annotations.NotNull()
    public static final com.miapp.kairos24h.sesionesYSeguridad.ManejoDeSesion INSTANCE = null;
    
    private ManejoDeSesion() {
        super();
    }
    
    public final void onPause() {
    }
    
    public final void onStop(@org.jetbrains.annotations.Nullable()
    android.webkit.WebView webView) {
    }
    
    public final void onResume(@org.jetbrains.annotations.Nullable()
    android.webkit.WebView webView) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object obtenerFechaHoraInternet(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.Date> $completion) {
        return null;
    }
    
    public final void startActivitySimulationTimer(@org.jetbrains.annotations.NotNull()
    android.os.Handler handler, @org.jetbrains.annotations.Nullable()
    android.webkit.WebView webView, long sessionTimeoutMillis) {
    }
}