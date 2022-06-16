# a10s: Make Kubernetes fun again

**Strömma Audit-loggen**:
1. Ta reda på vilket objekt det gäller (nyckel: apiVersion/namespace/resource/name)
2. Avgör om objektet skapades / uppdaterades / lästes / togs bort (utifrån verb)
3. Notera användaren för audit-eventet
4. Uppdatera set:et med kända k8s-objekt utifrån nyckeln:

   1. Skapa objekt om det behövs (createdBy, createdTs)
   2. Uppdatera objektet om det förändrades (updatedBy, updatedTs)
   3. Uppdatera objektet om det lästes (watchedBy, watchedTs)
   4. Markera att objektet togs bort (deletedBy, deletedTs)


**Strömma Event-loggen**:
1. Filtrera ut enbart events av de typer vi är intresserade av
2. Ta reda på vilket objekt eventet avser (nyckel: apiVersion/namespace/resource/name (resource måste mappas från Kind))
3. Berika med set:et av kända K8s-objekt
4. Lägg det berikade meddelandet på ny Kafka-topic

**Kika i Kafka**
```
mkdir -p certs
kubectl get secret -n kafka kafka-rh-sandbox-cluster-ca-cert -o=go-template='{{index .data "ca.crt"}}' | base64 -d > certs/kafka-sandbox-truststore.crt
kubectl get secret -n kafka k8s-achievements.processor -o=go-template='{{index .data "user.crt"}}' | base64 -d > certs/user.crt
kubectl get secret -n kafka k8s-achievements.processor -o=go-template='{{index .data "user.key"}}' | base64 -d > certs/user.key

kcat -C -b kafka-bootstrap.rh-sandbox.irori.se:9094 -X security.protocol=ssl -X ssl.ca.location=certs/kafka-sandbox-truststore.crt -X ssl.certificate.location=certs/user.crt -X ssl.key.location=certs/user.key -t k8s-achievements.ingestion.audit-events.json
kcat -C -b kafka-bootstrap.rh-sandbox.irori.se:9094 -X security.protocol=ssl -X ssl.ca.location=certs/kafka-sandbox-truststore.crt -X ssl.certificate.location=certs/user.crt -X ssl.key.location=certs/user.key -t k8s-achievements.ingestion.kubernetes-events.json
```