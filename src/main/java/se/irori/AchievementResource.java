package se.irori;

import io.smallrye.mutiny.Uni;
import java.util.UUID;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import se.irori.model.Achievement;
import se.irori.model.AchievementDefinition;

@Produces(MediaType.APPLICATION_JSON)
@Path("/achievements")
public class AchievementResource {

  @Path("/{achievement-id}")
  @GET
  public Uni<Achievement> getAchievement(@PathParam("achievement-id") UUID id) {
    return null;
  }

  @Path("/{achievement-id}/definition")
  @GET
  public Uni<AchievementDefinition> getAchievementDefinition(UUID id) {
    return null;
  }
}