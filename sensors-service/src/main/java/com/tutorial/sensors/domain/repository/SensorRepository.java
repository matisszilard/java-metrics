package com.tutorial.sensors.domain.repository;

import com.tutorial.sensors.domain.model.Sensor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class SensorRepository {
  private List<Sensor> sensors = new ArrayList<>();

  public Mono<Sensor> createSensor(Sensor sensor) {
    sensor.setId(UUID.randomUUID().toString());
    sensors.add(sensor);
    return Mono.just(sensor);
  }

  public Mono<Sensor> getSensor(String id) {
    return Mono.just(id)
        .map(i -> sensors.stream().filter(sensor -> sensor.getId().equals(id)).findFirst().get());
  }

  public Flux<Sensor> getSensors() {
    return Flux.fromIterable(sensors);
  }

  public Mono<Void> deleteSensor(String id) {
    return getSensor(id).map(sensor -> sensors.remove(sensor)).then();
  }
}
