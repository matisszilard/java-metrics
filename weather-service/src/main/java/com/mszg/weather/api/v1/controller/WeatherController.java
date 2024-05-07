package com.mszg.weather.api.v1.controller;

import com.mszg.weather.api.v1.controller.config.Constants;
import com.mszg.weather.domain.port.WeatherPort;
import com.mszg.weather.util.MetricsUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(Constants.API_V1_WEATHER)
public class WeatherController {
  private final WeatherPort weatherPort;

  @GetMapping
  public Mono<String> getWeather() {
    return weatherPort.getForecast().doOnNext(x -> MetricsUtil.increaseMetric());
  }
}
