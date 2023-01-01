package com.example.exercise;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b\u00a8\u0006\t"}, d2 = {"Lcom/example/exercise/ExerciseMessage;", "", "()V", "ExerciseUpdateMessage", "LapSummaryMessage", "LocationAvailabilityMessage", "Lcom/example/exercise/ExerciseMessage$ExerciseUpdateMessage;", "Lcom/example/exercise/ExerciseMessage$LapSummaryMessage;", "Lcom/example/exercise/ExerciseMessage$LocationAvailabilityMessage;", "app_debug"})
public abstract class ExerciseMessage {
    
    private ExerciseMessage() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/example/exercise/ExerciseMessage$ExerciseUpdateMessage;", "Lcom/example/exercise/ExerciseMessage;", "exerciseUpdate", "Landroidx/health/services/client/data/ExerciseUpdate;", "(Landroidx/health/services/client/data/ExerciseUpdate;)V", "getExerciseUpdate", "()Landroidx/health/services/client/data/ExerciseUpdate;", "app_debug"})
    public static final class ExerciseUpdateMessage extends com.example.exercise.ExerciseMessage {
        @org.jetbrains.annotations.NotNull()
        private final androidx.health.services.client.data.ExerciseUpdate exerciseUpdate = null;
        
        public ExerciseUpdateMessage(@org.jetbrains.annotations.NotNull()
        androidx.health.services.client.data.ExerciseUpdate exerciseUpdate) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.health.services.client.data.ExerciseUpdate getExerciseUpdate() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/example/exercise/ExerciseMessage$LapSummaryMessage;", "Lcom/example/exercise/ExerciseMessage;", "lapSummary", "Landroidx/health/services/client/data/ExerciseLapSummary;", "(Landroidx/health/services/client/data/ExerciseLapSummary;)V", "getLapSummary", "()Landroidx/health/services/client/data/ExerciseLapSummary;", "app_debug"})
    public static final class LapSummaryMessage extends com.example.exercise.ExerciseMessage {
        @org.jetbrains.annotations.NotNull()
        private final androidx.health.services.client.data.ExerciseLapSummary lapSummary = null;
        
        public LapSummaryMessage(@org.jetbrains.annotations.NotNull()
        androidx.health.services.client.data.ExerciseLapSummary lapSummary) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.health.services.client.data.ExerciseLapSummary getLapSummary() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/example/exercise/ExerciseMessage$LocationAvailabilityMessage;", "Lcom/example/exercise/ExerciseMessage;", "locationAvailability", "Landroidx/health/services/client/data/LocationAvailability;", "(Landroidx/health/services/client/data/LocationAvailability;)V", "getLocationAvailability", "()Landroidx/health/services/client/data/LocationAvailability;", "app_debug"})
    public static final class LocationAvailabilityMessage extends com.example.exercise.ExerciseMessage {
        @org.jetbrains.annotations.NotNull()
        private final androidx.health.services.client.data.LocationAvailability locationAvailability = null;
        
        public LocationAvailabilityMessage(@org.jetbrains.annotations.NotNull()
        androidx.health.services.client.data.LocationAvailability locationAvailability) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.health.services.client.data.LocationAvailability getLocationAvailability() {
            return null;
        }
    }
}