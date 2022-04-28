package se.irori.service;

import io.smallrye.mutiny.Multi;
import javax.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import se.irori.model.events.KubernetesEvent;

@ApplicationScoped
public class KubernetesEventProcessor {

  @Incoming("kubernetes-events")
  public void processKubernetesEvents(Multi<KubernetesEvent> kubernetesEvents) {

  }
}
