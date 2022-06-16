package se.irori.model;

import java.util.UUID;
import lombok.Builder;

@Builder
public class Subject {
  private UUID id;
  private String name;
}
