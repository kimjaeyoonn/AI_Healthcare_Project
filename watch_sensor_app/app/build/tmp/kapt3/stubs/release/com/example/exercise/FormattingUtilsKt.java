package com.example.exercise;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 2, d1 = {"\u0000*\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u001a\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b\u001a\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"MINUTES_PER_HOUR", "", "SECONDS_PER_MINUTE", "UNITS_RELATIVE_SIZE", "", "formatCalories", "Landroid/text/SpannedString;", "calories", "", "formatDistanceKm", "meters", "formatElapsedTime", "elapsedDuration", "Ljava/time/Duration;", "includeSeconds", "", "app_release"})
public final class FormattingUtilsKt {
    private static final float UNITS_RELATIVE_SIZE = 0.6F;
    private static final long MINUTES_PER_HOUR = 0L;
    private static final long SECONDS_PER_MINUTE = 0L;
    
    /**
     * Format an elapsed duration as `01m01s`. Hours are shown if present, e.g. `1h01m01s`. If
     * [includeSeconds] is `false`, seconds are omitted, e.g. `01m` or `1h01m`.
     */
    @org.jetbrains.annotations.NotNull()
    public static final android.text.SpannedString formatElapsedTime(@org.jetbrains.annotations.NotNull()
    java.time.Duration elapsedDuration, boolean includeSeconds) {
        return null;
    }
    
    /**
     * Format a distance to two decimals with a "km" suffix.
     */
    @org.jetbrains.annotations.NotNull()
    public static final android.text.SpannedString formatDistanceKm(double meters) {
        return null;
    }
    
    /**
     * Format calories burned to an integer with a "cal" suffix.
     */
    @org.jetbrains.annotations.NotNull()
    public static final android.text.SpannedString formatCalories(double calories) {
        return null;
    }
}