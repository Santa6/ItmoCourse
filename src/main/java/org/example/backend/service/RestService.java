package org.example.backend.service;

import com.google.gson.Gson;
import org.example.backend.Employee;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Objects;

@Path("service")
public class RestService{
    @Inject
    private EmployeeFacade employeeFacade;

    @Inject
    private DragonFacade dragonFacade;

    @Inject
    private ExcursionFacade excursionFacade;

    private Gson gson = new Gson();

    @GET
    @Path("login")
    @Produces(MediaType.APPLICATION_JSON)
    public String login(@QueryParam("id") String id, @QueryParam("password") String password){
        Employee employee = employeeFacade.findById(Long.valueOf(id));

        if (Objects.equals(employee.getPassword(), password)){
            return gson.toJson(true);
        }
        return gson.toJson(false);
    }

    @GET
    @Path("dragons")
    @Produces(MediaType.APPLICATION_JSON)
    public String dragons(){
        return gson.toJson(dragonFacade.findAll());
    }

    @GET
    @Path("excursions")
    @Produces(MediaType.APPLICATION_JSON)
    public String excursions(){
        return gson.toJson(excursionFacade.findAll());
    }

    @GET
    @Path("testAlive")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.TEXT_HTML)
    public String test(){
        return gson.toJson(true);
    }
}
