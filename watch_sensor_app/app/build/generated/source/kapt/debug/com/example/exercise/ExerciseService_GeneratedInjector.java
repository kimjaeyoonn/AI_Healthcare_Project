package com.example.exercise;

import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ServiceComponent;
import dagger.hilt.codegen.OriginatingElement;
import dagger.hilt.internal.GeneratedEntryPoint;

@OriginatingElement(
    topLevelClass = ExerciseService.class
)
@GeneratedEntryPoint
@InstallIn(ServiceComponent.class)
public interface ExerciseService_GeneratedInjector {
  void injectExerciseService(ExerciseService exerciseService);
}
