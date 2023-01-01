package com.example.exercise;

import java.lang.System;

/**
 * Coordinates messages between [MainActivity] and [ExerciseFragment].
 * main과 fragment의 중간다리
 */
@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0005J\u0006\u0010\u0010\u001a\u00020\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/example/exercise/MainViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_ambientEventChannel", "Lkotlinx/coroutines/channels/Channel;", "Lcom/example/exercise/AmbientEvent;", "_keyPressChannel", "", "ambientEventFlow", "Lkotlinx/coroutines/flow/Flow;", "getAmbientEventFlow", "()Lkotlinx/coroutines/flow/Flow;", "keyPressFlow", "getKeyPressFlow", "sendAmbientEvent", "event", "sendKeyPress", "app_debug"})
public final class MainViewModel extends androidx.lifecycle.ViewModel {
    private final kotlinx.coroutines.channels.Channel<com.example.exercise.AmbientEvent> _ambientEventChannel = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<com.example.exercise.AmbientEvent> ambientEventFlow = null;
    private final kotlinx.coroutines.channels.Channel<kotlin.Unit> _keyPressChannel = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<kotlin.Unit> keyPressFlow = null;
    
    @javax.inject.Inject()
    public MainViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.example.exercise.AmbientEvent> getAmbientEventFlow() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<kotlin.Unit> getKeyPressFlow() {
        return null;
    }
    
    public final void sendAmbientEvent(@org.jetbrains.annotations.NotNull()
    com.example.exercise.AmbientEvent event) {
    }
    
    public final void sendKeyPress() {
    }
}