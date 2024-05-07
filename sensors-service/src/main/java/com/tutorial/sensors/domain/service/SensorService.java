package com.tutorial.sensors.domain.service;

import com.tutorial.sensors.domain.model.Sensor;
import com.tutorial.sensors.domain.port.SensorPort;
import com.tutorial.sensors.domain.repository.SensorRepository;
import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class SensorService implements SensorPort {
  private final SensorRepository sensorRepository;

  @Override
  public Mono<Sensor> createSensor(Sensor sensor) {
    return sensorRepository.createSensor(sensor);
  }

  @Override
  public Mono<Sensor> getSensor(String id) {
    return sensorRepository.getSensor(id);
  }

  @Timed("service_get_sensors")
  @Override
  public Flux<Sensor> getSensors() {
    return sensorRepository.getSensors();
  }

  @Override
  public Mono<Void> deleteSensor(String id) {
    return sensorRepository.deleteSensor(id);
  }
}
