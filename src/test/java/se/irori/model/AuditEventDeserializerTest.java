package se.irori.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import se.irori.kafka.AuditEventDeserializer;
import se.irori.model.events.AuditEvent;

public class AuditEventDeserializerTest {

  private AuditEventDeserializer implementation;

  @Test
  public void testDeserializeAuditEvent() {
    implementation = new AuditEventDeserializer();
    AuditEvent event = implementation.deserialize("topic", testEvent.getBytes());

    assertThat(event.getVerb()).isEqualTo("get");
    assertThat(event.getStage()).isEqualTo("ResponseComplete");
    assertThat(event.getUserId()).isEqualTo("5c1cb6c0-b86e-4ac8-861f-21abefe7b135");
    assertThat(event.getUserName()).isEqualTo("ove.noros@irori.se");

    assertThat(event.getObjectName()).isEqualTo("user-settings-5c1cb6c0-b86e-4ac8-861f-21abefe7b135");
    assertThat(event.getObjectNamespace()).isEqualTo("openshift-console-user-settings");
    assertThat(event.getObjectResource()).isEqualTo("configmaps");

    assertThat(event.getResponseCode()).isEqualTo(200);
    assertThat(event.getTimestamp()).isEqualTo("2022-05-19T11:39:47.923081Z");
  }

  private final String testEvent = "{\n"
      + "  \"kind\": \"Event\",\n"
      + "  \"apiVersion\": \"audit.k8s.io/v1\",\n"
      + "  \"level\": \"Metadata\",\n"
      + "  \"auditID\": \"d947c669-ba30-4033-92f6-71630f58bc25\",\n"
      + "  \"stage\": \"ResponseComplete\",\n"
      + "  \"requestURI\": \"/api/v1/namespaces/openshift-console-user-settings/configmaps/user-settings-5c1cb6c0-b86e-4ac8-861f-21abefe7b135\",\n"
      + "  \"verb\": \"get\",\n"
      + "  \"user\": {\n"
      + "    \"username\": \"ove.noros@irori.se\",\n"
      + "    \"uid\": \"5c1cb6c0-b86e-4ac8-861f-21abefe7b135\",\n"
      + "    \"groups\": [\n"
      + "      \"system:authenticated:oauth\",\n"
      + "      \"system:authenticated\"\n"
      + "    ],\n"
      + "    \"extra\": {\n"
      + "      \"scopes.authorization.openshift.io\": [\n"
      + "        \"user:full\"\n"
      + "      ]\n"
      + "    }\n"
      + "  },\n"
      + "  \"sourceIPs\": [\n"
      + "    \"213.179.7.10\",\n"
      + "    \"10.130.2.14\",\n"
      + "    \"10.128.0.16\"\n"
      + "  ],\n"
      + "  \"userAgent\": \"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/101.0.4951.64 Safari/537.36\",\n"
      + "  \"objectRef\": {\n"
      + "    \"resource\": \"configmaps\",\n"
      + "    \"namespace\": \"openshift-console-user-settings\",\n"
      + "    \"name\": \"user-settings-5c1cb6c0-b86e-4ac8-861f-21abefe7b135\",\n"
      + "    \"apiVersion\": \"v1\"\n"
      + "  },\n"
      + "  \"responseStatus\": {\n"
      + "    \"code\": 200,\n"
      + "    \"requestReceivedTimestamp\": \"2022-05-19T11:39:47.908487Z\",\n"
      + "    \"stageTimestamp\": \"2022-05-19T11:39:47.923081Z\",\n"
      + "    \"annotations\": {\n"
      + "      \"authorization.k8s.io/decision\": \"allow\",\n"
      + "      \"authorization.k8s.io/reason\": \"RBAC: allowed by RoleBinding \\\"user-settings-5c1cb6c0-b86e-4ac8-861f-21abefe7b135-rolebinding/openshift-console-user-settings\\\" of Role \\\"user-settings-5c1cb6c0-b86e-4ac8-861f-21abefe7b135-role\\\" to User \\\"ove.noros@irori.se\\\"\"\n"
      + "    },\n"
      + "    \"k8s_audit_level\": \"Metadata\",\n"
      + "    \"message\": null,\n"
      + "    \"hostname\": \"ocp-jr5lj-master-0.europe-west4-a.c.sandbox-kafka.internal\",\n"
      + "    \"pipeline_metadata\": {\n"
      + "      \"collector\": {\n"
      + "        \"ipaddr4\": \"10.0.0.4\",\n"
      + "        \"inputname\": \"fluent-plugin-systemd\",\n"
      + "        \"name\": \"fluentd\",\n"
      + "        \"received_at\": \"2022-05-19T11:39:47.924107+00:00\",\n"
      + "        \"version\": \"1.7.4 1.6.0\"\n"
      + "      }\n"
      + "    },\n"
      + "    \"openshift\": {\n"
      + "      \"labels\": {\n"
      + "        \"logType\": \"audit\"\n"
      + "      }\n"
      + "    },\n"
      + "    \"@timestamp\": \"2022-05-19T11:39:47.923415+00:00\",\n"
      + "    \"viaq_index_name\": \"audit-write\",\n"
      + "    \"viaq_msg_id\": \"MmYxNzgyZTMtNTNmZi00YTAyLTliZTUtMDRkMGIwOGJjNDQ5\",\n"
      + "    \"log_type\": \"audit\"\n"
      + "  }\n"
      + "}";
}
