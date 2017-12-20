package org.example.backend.service;

import com.google.gson.Gson;
import org.example.backend.Employee;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Objects;

@Path(value = "service")
public class RestService{
    @Inject
    private EmployeeFacade employeeFacade;

    private Gson gson = new Gson();

    @GET
    @Path(value = "login")
    @Produces(MediaType.APPLICATION_JSON)
    public String login(@QueryParam("id") String id, @QueryParam("password") String password){
        Employee employee = employeeFacade.findById(Long.valueOf(id));

        if (Objects.equals(employee.getPassword(), password)){
            return gson.toJson(true);
        }
        return gson.toJson(false);
    }

    @GET
    @Path(value = "test")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.TEXT_HTML)
    public String test(){
        return gson.toJson(true);
    }
}
