package com.tutorial.sensors.util;

import io.micrometer.core.instrument.Metrics;

import static com.tutorial.sensors.domain.config.MetricsConfig.API_COUNTER_NAME;
import static com.tutorial.sensors.domain.config.MetricsConfig.FUNCTION;

public class MetricsUtil {

  public static void increaseMetric(String function) {
    Metrics.counter(API_COUNTER_NAME, FUNCTION, function).increment();
  }
}
