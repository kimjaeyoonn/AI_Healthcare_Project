package com.example.exercise;

import java.lang.System;

/**
 * ServiceConnection implementation. This is implemented as a LifecycleOwner so we can launch
 * coroutines bound to its lifecycle. When the service is connected, the lifecycle will be
 * [Lifecycle.State.STARTED]; otherwise it will be [Lifecycle.State.INITIALIZED].
 */
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J@\u0010\u0015\u001a\u00020\u000f2-\u0010\u0016\u001a)\b\u0001\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0017\u00a2\u0006\u0002\b\u001bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001cR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/example/exercise/ExerciseServiceConnection;", "Landroid/content/ServiceConnection;", "Landroidx/lifecycle/LifecycleOwner;", "()V", "exerciseService", "Lcom/example/exercise/ExerciseService;", "getExerciseService", "()Lcom/example/exercise/ExerciseService;", "setExerciseService", "(Lcom/example/exercise/ExerciseService;)V", "lifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", "getLifecycle", "Landroidx/lifecycle/Lifecycle;", "onServiceConnected", "", "name", "Landroid/content/ComponentName;", "service", "Landroid/os/IBinder;", "onServiceDisconnected", "repeatWhenConnected", "block", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
public final class ExerciseServiceConnection implements android.content.ServiceConnection, androidx.lifecycle.LifecycleOwner {
    @org.jetbrains.annotations.Nullable()
    private com.example.exercise.ExerciseService exerciseService;
    private final androidx.lifecycle.LifecycleRegistry lifecycleRegistry = null;
    
    public ExerciseServiceConnection() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.exercise.ExerciseService getExerciseService() {
        return null;
    }
    
    public final void setExerciseService(@org.jetbrains.annotations.Nullable()
    com.example.exercise.ExerciseService p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.lifecycle.Lifecycle getLifecycle() {
        return null;
    }
    
    @java.lang.Override()
    public void onServiceConnected(@org.jetbrains.annotations.NotNull()
    android.content.ComponentName name, @org.jetbrains.annotations.NotNull()
    android.os.IBinder service) {
    }
    
    @java.lang.Override()
    public void onServiceDisconnected(@org.jetbrains.annotations.NotNull()
    android.content.ComponentName name) {
    }
    
    /**
     * Runs the given [block] in a new coroutine when the service is connected and suspends the
     * execution until this Lifecycle is [Lifecycle.State.DESTROYED]. The [block] will cancel and
     * re-launch as the service becomes connected or disconnected. The connected service is passed
     * to the [block] so that clients can interact with it.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object repeatWhenConnected(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function3<? super kotlinx.coroutines.CoroutineScope, ? super com.example.exercise.ExerciseService, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> block, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}