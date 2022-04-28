package se.irori.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class ProgressEvent {
  private UUID id;
  private UUID achievementId;
  private LocalDateTime timestamp;
  private ProgressState state;
  private Integer progress;
}
