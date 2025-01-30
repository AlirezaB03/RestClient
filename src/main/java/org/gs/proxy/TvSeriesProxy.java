package org.gs.proxy;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.gs.TvSerie;

@ApplicationScoped
@RegisterRestClient(baseUri = "https://api.tvmaze.com/singlesearch")
public interface TvSeriesProxy {
    @GET
    @Path("/shows")
    @Produces(MediaType.APPLICATION_JSON)
    TvSerie get(@QueryParam("q") String title);

}
