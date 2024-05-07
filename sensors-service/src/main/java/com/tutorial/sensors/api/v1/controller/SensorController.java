package com.tutorial.sensors.api.v1.controller;

import com.tutorial.sensors.api.v1.controller.config.Constants;
import com.tutorial.sensors.domain.model.Sensor;
import com.tutorial.sensors.domain.port.SensorPort;
import com.tutorial.sensors.util.MetricsUtil;
import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(Constants.API_V1_SENSORS)
public class SensorController {
  private final SensorPort sensorPort;

  @PostMapping
  public Mono<Sensor> createSensors(@RequestBody Sensor sensor) {
    return sensorPort
        .createSensor(sensor)
        .doOnNext(x -> MetricsUtil.increaseMetric("createSensors"));
  }

  @GetMapping("{id}")
  public Mono<Sensor> getSensor(@PathVariable(name = "id") String id) {
    return sensorPort.getSensor(id).doOnNext(x -> MetricsUtil.increaseMetric("getSensor"));
  }

  @Timed("controller_get_sensors")
  @GetMapping
  public Flux<Sensor> getSensors() {
    return sensorPort.getSensors().doOnNext(x -> MetricsUtil.increaseMetric("getSensors"));
  }

  @DeleteMapping("{id}")
  public Mono<Void> deleteSensor(@PathVariable(name = "id") String id) {
    return sensorPort.deleteSensor(id).doOnNext(x -> MetricsUtil.increaseMetric("deleteSensor"));
  }
}
