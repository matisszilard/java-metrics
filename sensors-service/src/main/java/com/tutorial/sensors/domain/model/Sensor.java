package com.tutorial.sensors.domain.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Sensor {
  private String id;
  private String name;
}
