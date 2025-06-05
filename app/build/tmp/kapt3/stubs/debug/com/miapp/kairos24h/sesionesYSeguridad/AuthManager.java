package com.miapp.kairos24h.sesionesYSeguridad;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rJj\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\b\u00a8\u0006\u0019"}, d2 = {"Lcom/miapp/kairos24h/sesionesYSeguridad/AuthManager;", "", "()V", "authenticateUser", "Lkotlin/Pair;", "", "Lcom/miapp/kairos24h/sesionesYSeguridad/UserCredentials;", "usuario", "", "password", "clearAllUserData", "", "context", "Landroid/content/Context;", "getUserCredentials", "saveUserCredentials", "xEmpleado", "lComGPS", "lComIP", "lBotonesFichajeMovil", "xEntidad", "sEmpleado", "tUrlCPP", "tLogo", "cTipEmp", "app_debug"})
public final class AuthManager {
    @org.jetbrains.annotations.NotNull()
    public static final com.miapp.kairos24h.sesionesYSeguridad.AuthManager INSTANCE = null;
    
    private AuthManager() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.miapp.kairos24h.sesionesYSeguridad.UserCredentials getUserCredentials(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    public final void saveUserCredentials(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String usuario, @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.Nullable()
    java.lang.String xEmpleado, @org.jetbrains.annotations.NotNull()
    java.lang.String lComGPS, @org.jetbrains.annotations.NotNull()
    java.lang.String lComIP, @org.jetbrains.annotations.NotNull()
    java.lang.String lBotonesFichajeMovil, @org.jetbrains.annotations.Nullable()
    java.lang.String xEntidad, @org.jetbrains.annotations.NotNull()
    java.lang.String sEmpleado, @org.jetbrains.annotations.NotNull()
    java.lang.String tUrlCPP, @org.jetbrains.annotations.NotNull()
    java.lang.String tLogo, @org.jetbrains.annotations.NotNull()
    java.lang.String cTipEmp) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.Pair<java.lang.Boolean, com.miapp.kairos24h.sesionesYSeguridad.UserCredentials> authenticateUser(@org.jetbrains.annotations.NotNull()
    java.lang.String usuario, @org.jetbrains.annotations.NotNull()
    java.lang.String password) {
        return null;
    }
    
    public final void clearAllUserData(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
}