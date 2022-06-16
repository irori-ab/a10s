package se.irori.model;

import java.util.Locale;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import se.irori.model.events.AuditEvent;

@Builder
@Getter
public class SubjectAction {

  private Subject subject;
  private Predicate predicate;
  private Resource resource;

  public static SubjectAction create(AuditEvent auditEvent) {
    return SubjectAction.builder()
        .subject(
            Subject.builder()
                .id(UUID.fromString(auditEvent.getUserId()))
                .name(auditEvent.getUserName())
                .build())
        .predicate(Predicate.valueOf(auditEvent.getVerb().toUpperCase(Locale.ROOT)))
        .resource(Resource.builder()
            .name(auditEvent.getObjectName())
            .namespace(auditEvent.getObjectNamespace()).build()).build();
  }
}
