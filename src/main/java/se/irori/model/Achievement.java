package se.irori.model;

import java.util.List;
import java.util.UUID;

public class Achievement {
  private UUID id;
  private String name;
  private String description;
  private boolean isHidden;
  private AchievementArea area;
  private AchievementDifficulty difficulty;
  private Integer reward;
  private List<UUID> dependsOn;
  private AchievementDefinition achievementDefinition;
}
