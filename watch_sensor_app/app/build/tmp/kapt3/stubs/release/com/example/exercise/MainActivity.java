package com.example.exercise;

import java.lang.System;

/**
 * This Activity serves a handful of functions:
 * - to host a [NavHostFragment]
 * - to capture KeyEvents
 * - to support Ambient Mode, because [AmbientCallbackProvider] must be an `Activity`.
 *
 * [MainViewModel] is used to coordinate between this Activity and the [ExerciseFragment], which
 * contains UI during an active exercise.
 */
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0013B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\rH\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0014"}, d2 = {"Lcom/example/exercise/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroidx/wear/ambient/AmbientModeSupport$AmbientCallbackProvider;", "()V", "viewModel", "Lcom/example/exercise/MainViewModel;", "getViewModel", "()Lcom/example/exercise/MainViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getAmbientCallback", "Landroidx/wear/ambient/AmbientModeSupport$AmbientCallback;", "onKeyUp", "", "keyCode", "", "event", "Landroid/view/KeyEvent;", "onSupportNavigateUp", "AmbientModeCallback", "app_release"})
@dagger.hilt.android.AndroidEntryPoint()
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity implements androidx.wear.ambient.AmbientModeSupport.AmbientCallbackProvider {
    private final kotlin.Lazy viewModel$delegate = null;
    
    public MainActivity() {
        super();
    }
    
    private final com.example.exercise.MainViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    public boolean onSupportNavigateUp() {
        return false;
    }
    
    @java.lang.Override()
    public boolean onKeyUp(int keyCode, @org.jetbrains.annotations.Nullable()
    android.view.KeyEvent event) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.wear.ambient.AmbientModeSupport.AmbientCallback getAmbientCallback() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/example/exercise/MainActivity$AmbientModeCallback;", "Landroidx/wear/ambient/AmbientModeSupport$AmbientCallback;", "(Lcom/example/exercise/MainActivity;)V", "onEnterAmbient", "", "ambientDetails", "Landroid/os/Bundle;", "onExitAmbient", "onUpdateAmbient", "app_release"})
    public final class AmbientModeCallback extends androidx.wear.ambient.AmbientModeSupport.AmbientCallback {
        
        public AmbientModeCallback() {
            super();
        }
        
        @java.lang.Override()
        public void onEnterAmbient(@org.jetbrains.annotations.NotNull()
        android.os.Bundle ambientDetails) {
        }
        
        @java.lang.Override()
        public void onExitAmbient() {
        }
        
        @java.lang.Override()
        public void onUpdateAmbient() {
        }
    }
}