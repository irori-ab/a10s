package se.irori.model.events;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Map;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuditEvent {

  private String userName;
  private String userId;
  private String objectNamespace;
  private String objectResource;
  private String objectName;
  private Integer responseCode;
  private Instant timestamp; //När stage uppfylls?

  @JsonProperty("verb")
  private String verb;

  @JsonProperty("stage")
  private String stage; //ResponseComplete när den lyckas? Bör bara vara "ResponseComplete" vi är intresserad av.

  @JsonProperty("user")
  private void deserializeUser(Map<String, Object> userMap) {
    this.userName = (String) userMap.get("username");
    this.userId = (String) userMap.get("uid");
  }

  @JsonProperty("objectRef")
  private void deserializeObjectRef(Map<String, Object> objectRefMap) {
    this.objectName = (String) objectRefMap.get("name");
    this.objectNamespace = (String) objectRefMap.get("namespace");
    this.objectResource = (String) objectRefMap.get("resource");
  }

  @JsonProperty("responseStatus")
  private void deserializeResponseStatus(Map<String, Object> responseStatusMap) {
    this.responseCode = (Integer) responseStatusMap.get("code");

    this.timestamp = Instant.parse((String) responseStatusMap.get("stageTimestamp"));
  }
}
