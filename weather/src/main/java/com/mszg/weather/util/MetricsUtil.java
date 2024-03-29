package com.mszg.weather.util;

import io.micrometer.core.instrument.Metrics;

import static com.mszg.weather.domain.config.MetricsConfig.API_COUNTER_NAME;
import static com.mszg.weather.domain.config.MetricsConfig.TAG;

public class MetricsUtil {

  public static void increaseMetric() {
    Metrics.counter(API_COUNTER_NAME, TAG, "get-weather").increment();
  }
}
