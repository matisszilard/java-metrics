package com.mszg.weather.domain.port;

import reactor.core.publisher.Mono;

public interface WeatherPort {
  Mono<String> getForecast();
}
