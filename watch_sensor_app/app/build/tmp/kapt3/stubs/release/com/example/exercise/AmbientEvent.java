package com.example.exercise;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b\u00a8\u0006\t"}, d2 = {"Lcom/example/exercise/AmbientEvent;", "", "()V", "Enter", "Exit", "Update", "Lcom/example/exercise/AmbientEvent$Enter;", "Lcom/example/exercise/AmbientEvent$Exit;", "Lcom/example/exercise/AmbientEvent$Update;", "app_release"})
public abstract class AmbientEvent {
    
    private AmbientEvent() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/example/exercise/AmbientEvent$Enter;", "Lcom/example/exercise/AmbientEvent;", "ambientDetails", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)V", "getAmbientDetails", "()Landroid/os/Bundle;", "app_release"})
    public static final class Enter extends com.example.exercise.AmbientEvent {
        @org.jetbrains.annotations.NotNull()
        private final android.os.Bundle ambientDetails = null;
        
        public Enter(@org.jetbrains.annotations.NotNull()
        android.os.Bundle ambientDetails) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.os.Bundle getAmbientDetails() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/exercise/AmbientEvent$Exit;", "Lcom/example/exercise/AmbientEvent;", "()V", "app_release"})
    public static final class Exit extends com.example.exercise.AmbientEvent {
        
        public Exit() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/exercise/AmbientEvent$Update;", "Lcom/example/exercise/AmbientEvent;", "()V", "app_release"})
    public static final class Update extends com.example.exercise.AmbientEvent {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.exercise.AmbientEvent.Update INSTANCE = null;
        
        private Update() {
            super();
        }
    }
}