package com.example.exercise;

import java.lang.System;

/**
 * Hilt module that provides singleton (application-scoped) objects.
 */
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\u0012\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH\u0007\u00a8\u0006\t"}, d2 = {"Lcom/example/exercise/MainModule;", "", "()V", "provideApplicationCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "provideHealthServicesClient", "Landroidx/health/services/client/HealthServicesClient;", "context", "Landroid/content/Context;", "app_debug"})
@dagger.Module()
public final class MainModule {
    
    public MainModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final androidx.health.services.client.HealthServicesClient provideHealthServicesClient(@org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final kotlinx.coroutines.CoroutineScope provideApplicationCoroutineScope() {
        return null;
    }
}