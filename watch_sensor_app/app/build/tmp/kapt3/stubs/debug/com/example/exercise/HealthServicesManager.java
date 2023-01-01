package com.example.exercise;

import java.lang.System;

/**
 * Entry point for [HealthServicesClient] APIs, wrapping them in coroutine-friendly APIs.
 */
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000f\u0018\u0000 #2\u00020\u0001:\u0001#B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0011\u0010\u0014\u001a\u00020\u0015H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u0004\u0018\u00010\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u0011\u0010\u0018\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u0011\u0010\u0019\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u0011\u0010\u001a\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u0011\u0010\u001b\u001a\u00020\u0015H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u0011\u0010\u001c\u001a\u00020\u0015H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u0011\u0010\u001d\u001a\u00020\u0015H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u0011\u0010\u001e\u001a\u00020\u0015H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u0011\u0010\u001f\u001a\u00020\u0015H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u0010\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\nH\u0002J\u0010\u0010\"\u001a\u00020\b2\u0006\u0010!\u001a\u00020\nH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006$"}, d2 = {"Lcom/example/exercise/HealthServicesManager;", "", "healthServicesClient", "Landroidx/health/services/client/HealthServicesClient;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "(Landroidx/health/services/client/HealthServicesClient;Lkotlinx/coroutines/CoroutineScope;)V", "capabilitiesLoaded", "", "exerciseCapabilities", "Landroidx/health/services/client/data/ExerciseTypeCapabilities;", "exerciseClient", "Landroidx/health/services/client/ExerciseClient;", "exerciseUpdateFlow", "Lkotlinx/coroutines/flow/Flow;", "Lcom/example/exercise/ExerciseMessage;", "getExerciseUpdateFlow$annotations", "()V", "getExerciseUpdateFlow", "()Lkotlinx/coroutines/flow/Flow;", "endExercise", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getExerciseCapabilities", "hasExerciseCapability", "isExerciseInProgress", "isTrackingExerciseInAnotherApp", "markLap", "pauseExercise", "prepareExercise", "resumeExercise", "startExercise", "supportsCalorieGoal", "capabilities", "supportsDistanceMilestone", "Companion", "app_debug"})
public final class HealthServicesManager {
    private final androidx.health.services.client.ExerciseClient exerciseClient = null;
    private androidx.health.services.client.data.ExerciseTypeCapabilities exerciseCapabilities;
    private boolean capabilitiesLoaded = false;
    
    /**
     * A shared flow for [ExerciseUpdate]s.
     *
     * When the flow starts, it will register an [ExerciseUpdateListener] and start to emit
     * messages. When there are no more subscribers, or when the coroutine scope of [shareIn] is
     * cancelled, this flow will unregister the listener.
     *
     * A shared flow is used because only a single [ExerciseUpdateListener] can be reigstered at a
     * time, even if there are multiple consumers of the flow.
     *
     * [callbackFlow] is used to bridge between a callback-based API and Kotlin flows.
     */
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<com.example.exercise.ExerciseMessage> exerciseUpdateFlow = null;
    @org.jetbrains.annotations.NotNull()
    private static final com.example.exercise.HealthServicesManager.Companion Companion = null;
    @java.lang.Deprecated()
    public static final double CALORIES_THRESHOLD = 250.0;
    @java.lang.Deprecated()
    public static final double DISTANCE_THRESHOLD = 1000.0;
    
    @javax.inject.Inject()
    public HealthServicesManager(@org.jetbrains.annotations.NotNull()
    androidx.health.services.client.HealthServicesClient healthServicesClient, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineScope coroutineScope) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getExerciseCapabilities(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super androidx.health.services.client.data.ExerciseTypeCapabilities> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object hasExerciseCapability(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object isExerciseInProgress(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object isTrackingExerciseInAnotherApp(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> continuation) {
        return null;
    }
    
    /**
     * *
     * Note: don't call this method from outside of foreground service (ie. [ExerciseService])
     * when acquiring calories or distance.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object startExercise(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final boolean supportsCalorieGoal(androidx.health.services.client.data.ExerciseTypeCapabilities capabilities) {
        return false;
    }
    
    private final boolean supportsDistanceMilestone(androidx.health.services.client.data.ExerciseTypeCapabilities capabilities) {
        return false;
    }
    
    /**
     * *
     * Note: don't call this method from outside of [ExerciseService]
     * when acquiring calories or distance.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object prepareExercise(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object endExercise(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object pauseExercise(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object resumeExercise(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object markLap(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.example.exercise.ExerciseMessage> getExerciseUpdateFlow() {
        return null;
    }
    
    /**
     * A shared flow for [ExerciseUpdate]s.
     *
     * When the flow starts, it will register an [ExerciseUpdateListener] and start to emit
     * messages. When there are no more subscribers, or when the coroutine scope of [shareIn] is
     * cancelled, this flow will unregister the listener.
     *
     * A shared flow is used because only a single [ExerciseUpdateListener] can be reigstered at a
     * time, even if there are multiple consumers of the flow.
     *
     * [callbackFlow] is used to bridge between a callback-based API and Kotlin flows.
     */
    @kotlin.OptIn(markerClass = {kotlinx.coroutines.ExperimentalCoroutinesApi.class})
    @java.lang.Deprecated()
    public static void getExerciseUpdateFlow$annotations() {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/example/exercise/HealthServicesManager$Companion;", "", "()V", "CALORIES_THRESHOLD", "", "DISTANCE_THRESHOLD", "app_debug"})
    static final class Companion {
        
        private Companion() {
            super();
        }
    }
}