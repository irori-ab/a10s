package se.irori.model.events;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.Getter;

@Data
public class AuditEvent {
  private String userName;
  private String userId;
  private String objectNamespace;
  private String objectResource;
  private String objectName;
  private String responseCode;
  private LocalDateTime stageTimestamp; //När stage uppfylls?
  private String verb;
  private String stage; //ResponseComplete när den lyckas? Bör bara vara "ResponseComplete" vi är intresserad av.

}
