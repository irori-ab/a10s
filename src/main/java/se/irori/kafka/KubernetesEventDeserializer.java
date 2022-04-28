package se.irori.kafka;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;
import se.irori.model.events.KubernetesEvent;

public class KubernetesEventDeserializer extends ObjectMapperDeserializer<KubernetesEvent> {

  public KubernetesEventDeserializer() {
    super(KubernetesEvent.class);
  }
}
