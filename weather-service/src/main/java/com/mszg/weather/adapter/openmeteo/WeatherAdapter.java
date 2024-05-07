package com.mszg.weather.adapter.openmeteo;

import com.mszg.weather.domain.port.WeatherPort;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class WeatherAdapter implements WeatherPort {
  private static final String URL =
      "https://api.open-meteo.com/v1/forecast?latitude=46.7712&longitude=23.6236&hourly=temperature_2m,rain";
  private final WebClient webClient = WebClient.builder().build();

  public Mono<String> getForecast() {
    return webClient.method(HttpMethod.GET).uri(URL).retrieve().bodyToMono(String.class);
  }
}
