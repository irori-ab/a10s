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