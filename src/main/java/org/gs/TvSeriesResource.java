package org.gs;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.gs.proxy.TvSeriesProxy;

import java.util.ArrayList;
import java.util.List;

@Path("/tvSeries")
public class TvSeriesResource {

    @Inject
    @RestClient
    TvSeriesProxy proxy;

    private List<TvSerie> tvSeries = new ArrayList<>();


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTvSeries() {
        TvSerie tvSerie = proxy.get("Game of Thrones");
        tvSeries.add(tvSerie);
        return Response.ok(tvSeries).build();
    }
}
