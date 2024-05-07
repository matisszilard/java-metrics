package com.tutorial.sensors.domain.port;

import com.tutorial.sensors.domain.model.Sensor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SensorPort {

  Mono<Sensor> createSensor(Sensor sensor);

  Mono<Sensor> getSensor(String id);

  Flux<Sensor> getSensors();

  Mono<Void> deleteSensor(String id);
}
