package se.irori.service;

import io.smallrye.mutiny.Multi;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import se.irori.model.events.AuditEvent;

@ApplicationScoped
public class AuditEventProcessor {

  final List<String> relevantVerbs = List.of("create", "delete", "patch", "update", "get");

  @Incoming("audit-events")
  public Multi<AuditEvent> filterAuditEvents(Multi<AuditEvent> auditEvent) {
    return auditEvent
        .filter(this::isResponseCompleteStage)
        .filter(this::isRelevantVerb);
  }

  private boolean isRelevantVerb(AuditEvent auditEvent) {
    return relevantVerbs.contains(auditEvent.getVerb());
  }

  private Boolean isResponseCompleteStage(AuditEvent auditEvent) {
    return auditEvent.getStage().equals("ResponseComplete");
  }
}
