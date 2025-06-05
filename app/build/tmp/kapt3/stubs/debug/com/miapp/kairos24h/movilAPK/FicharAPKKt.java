package com.miapp.kairos24h.movilAPK;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000V\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a^\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\f\u001a\u00020\rH\u0007\u001a\u001e\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0007\u001a\u0010\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u000bH\u0007\u001a&\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0007\u001a\b\u0010\u0019\u001a\u00020\u0001H\u0007\u001a \u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\u001aZ\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u001c26\u0010\u001f\u001a2\u0012\u0013\u0012\u00110!\u00a2\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u00110!\u00a2\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u00010 2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003\u00a8\u0006\'"}, d2 = {"BottomNavigationBar", "", "onNavigate", "Lkotlin/Function1;", "", "onToggleFichar", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "hideCuadroParaFichar", "setIsLoading", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "FicharScreen", "webView", "Landroid/webkit/WebView;", "onLogout", "LoadingScreen", "isLoading", "NavigationButton", "text", "iconResId", "", "onClick", "PreviewFicharScreen", "fichar", "context", "Landroid/content/Context;", "tipo", "obtenerCoord", "onLocationObtained", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "lat", "lon", "onShowAlert", "app_debug"})
@kotlin.Suppress(names = {"DEPRECATION"})
public final class FicharAPKKt {
    
    @android.annotation.SuppressLint(value = {"SetJavaScriptEnabled"})
    @androidx.compose.runtime.Composable()
    public static final void FicharScreen(@org.jetbrains.annotations.NotNull()
    android.webkit.WebView webView, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onLogout) {
    }
    
    @androidx.compose.runtime.Composable()
    @androidx.compose.ui.tooling.preview.Preview(showBackground = true)
    public static final void PreviewFicharScreen() {
    }
    
    public static final void fichar(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String tipo, @org.jetbrains.annotations.NotNull()
    android.webkit.WebView webView) {
    }
    
    public static final void obtenerCoord(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super java.lang.Double, ? super java.lang.Double, kotlin.Unit> onLocationObtained, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onShowAlert) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void BottomNavigationBar(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onNavigate, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onToggleFichar, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> hideCuadroParaFichar, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> setIsLoading, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineScope scope) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void NavigationButton(@org.jetbrains.annotations.NotNull()
    java.lang.String text, int iconResId, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void LoadingScreen(boolean isLoading) {
    }
}