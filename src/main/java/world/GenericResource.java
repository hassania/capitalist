/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world;
//import com.google.gson.Gson;
import com.google.gson.Gson;
import generated.World;
import java.io.IOException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBException;

/**
 * REST Web Service
 *
 * @author packardbell
 */
@Path("generic")
public class GenericResource {

    @Context
    private UriInfo context;
    private Services services;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
        this.services = new Services();
    }

    /**
     * Retrieves representation of an instance of world.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("xml")
    @Produces(MediaType.APPLICATION_XML)
    public World getXml() throws JAXBException, IOException {
        //TODO return proper representation object
        World world = services.readWorldFromXml();
        return world;
    }

    @GET
    @Path("json")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() throws JAXBException, IOException {        
        World world = services.readWorldFromXml();
        String gson = new Gson().toJson(world);
        return gson;  
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
