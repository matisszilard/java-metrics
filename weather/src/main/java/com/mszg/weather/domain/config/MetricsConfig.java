package com.mszg.weather.domain.config;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MetricsConfig {
  public static final String API_COUNTER_NAME = "weather_service_request_count";
  public static final String TAG = "tag_name";

  @Bean
  public Counter eventCounter(MeterRegistry registry) {
    return Counter.builder(API_COUNTER_NAME).tags(TAG, "").register(registry);
  }
}
