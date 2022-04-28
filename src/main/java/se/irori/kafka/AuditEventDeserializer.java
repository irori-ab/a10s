package se.irori.kafka;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;
import se.irori.model.events.AuditEvent;

public class AuditEventDeserializer extends ObjectMapperDeserializer<AuditEvent> {

  public AuditEventDeserializer() {
    super(AuditEvent.class);
  }
}
