package com.miapp.kairos24h.sesionesYSeguridad;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c7\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002JB\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r0\fH\u0086@\u00a2\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0006H\u0086@\u00a2\u0006\u0002\u0010\u0011J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0014\u001a\u00020\u0004J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0017"}, d2 = {"Lcom/miapp/kairos24h/sesionesYSeguridad/SeguridadUtils;", "", "()V", "checkSecurity", "", "context", "Landroid/content/Context;", "lComGPS", "", "lComIP", "lBotonesFichajeMovil", "onShowAlert", "Lkotlin/Function1;", "", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectarUbicacionReal", "Lcom/miapp/kairos24h/sesionesYSeguridad/SeguridadUtils$ResultadoUbicacion;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasLocationPermission", "isInternetAvailable", "isMockLocationEnabled", "isUsingVPN", "ResultadoUbicacion", "app_debug"})
public final class SeguridadUtils {
    @org.jetbrains.annotations.NotNull()
    public static final com.miapp.kairos24h.sesionesYSeguridad.SeguridadUtils INSTANCE = null;
    
    private SeguridadUtils() {
        super();
    }
    
    public final boolean isUsingVPN(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return false;
    }
    
    public final boolean isInternetAvailable(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return false;
    }
    
    public final boolean isMockLocationEnabled() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object detectarUbicacionReal(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.miapp.kairos24h.sesionesYSeguridad.SeguridadUtils.ResultadoUbicacion> $completion) {
        return null;
    }
    
    public final boolean hasLocationPermission(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object checkSecurity(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String lComGPS, @org.jetbrains.annotations.NotNull()
    java.lang.String lComIP, @org.jetbrains.annotations.NotNull()
    java.lang.String lBotonesFichajeMovil, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onShowAlert, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/miapp/kairos24h/sesionesYSeguridad/SeguridadUtils$ResultadoUbicacion;", "", "(Ljava/lang/String;I)V", "OK", "GPS_DESACTIVADO", "UBICACION_SIMULADA", "app_debug"})
    public static enum ResultadoUbicacion {
        /*public static final*/ OK /* = new OK() */,
        /*public static final*/ GPS_DESACTIVADO /* = new GPS_DESACTIVADO() */,
        /*public static final*/ UBICACION_SIMULADA /* = new UBICACION_SIMULADA() */;
        
        ResultadoUbicacion() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public static kotlin.enums.EnumEntries<com.miapp.kairos24h.sesionesYSeguridad.SeguridadUtils.ResultadoUbicacion> getEntries() {
            return null;
        }
    }
}