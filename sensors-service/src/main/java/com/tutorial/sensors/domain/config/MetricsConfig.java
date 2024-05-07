package com.tutorial.sensors.domain.config;

import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MetricsConfig {
  public static final String API_COUNTER_NAME = "sensor_service_request_count";
  public static final String FUNCTION = "function";

  @Bean
  public Counter eventCounter(MeterRegistry registry) {
    return Counter.builder(API_COUNTER_NAME).tags(FUNCTION, "").register(registry);
  }

  @Bean
  public Timer eventTimer(MeterRegistry registry) {
    return Timer.builder("sensor_service_request.timer")
        .description("api request timer")
        .tags(FUNCTION, "")
        .register(registry);
  }

  @Bean
  public TimedAspect timedAspect(MeterRegistry registry) {
    return new TimedAspect(registry);
  }
}
