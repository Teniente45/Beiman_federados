package com.miapp.kairos24h.enlaces_internos;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/miapp/kairos24h/enlaces_internos/BuildURLmovil;", "", "()V", "ACTION_CONSULTAR", "", "ACTION_CONSULTFIC_DIA", "ACTION_CONSULTHORARIO", "ACTION_CONSULT_ALERTAS", "ACTION_FICHAJE", "ACTION_FORGOTPASS", "ACTION_LOGIN", "C_FIC_ORI", "C_KIOSKO", "ENTRY_POINT", "X_GRUPO", "getCrearFichaje", "context", "Landroid/content/Context;", "getFichaje", "getForgotPassword", "getHorarios", "getHost", "getIncidencia", "getIndex", "getMostrarAlertas", "getMostrarFichajes", "getMostrarHorarios", "getSolicitudes", "getStaticParams", "getURLUsada", "app_debug"})
public final class BuildURLmovil {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ENTRY_POINT = "/index.php";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTION_FORGOTPASS = "r=site/solicitudRestablecerClave";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTION_LOGIN = "r=site/index";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTION_FICHAJE = "r=explotacion/creaFichaje";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTION_CONSULTAR = "r=explotacion/consultarExplotacion";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTION_CONSULTHORARIO = "r=wsExterno/consultarHorarioExterno";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTION_CONSULTFIC_DIA = "r=wsExterno/consultarFichajesExterno";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTION_CONSULT_ALERTAS = "r=wsExterno/consultarAlertasExterno";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String X_GRUPO = "";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String C_KIOSKO = "";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String C_FIC_ORI = "APP";
    @org.jetbrains.annotations.NotNull()
    public static final com.miapp.kairos24h.enlaces_internos.BuildURLmovil INSTANCE = null;
    
    private BuildURLmovil() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getHost(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getURLUsada(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getIndex(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getForgotPassword(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFichaje(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getIncidencia(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getHorarios(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSolicitudes(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getStaticParams(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCrearFichaje(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMostrarHorarios(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMostrarFichajes(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMostrarAlertas(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
}