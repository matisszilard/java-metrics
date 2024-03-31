package com.mszg.weather.api.v1.controller;

import com.mszg.weather.api.v1.controller.config.Constants;
import com.mszg.weather.util.MetricsUtil;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@Tag(name = "Appliance", description = "User appliance APIs")
@RestController
@RequiredArgsConstructor
@RequestMapping(Constants.API_V1_WEATHER)
public class WeatherController {
  @GetMapping
  public Mono<String> getWeather() {
    return Mono.just("hello there").doOnNext(x -> MetricsUtil.increaseMetric());
  }
}
