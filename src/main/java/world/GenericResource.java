/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.swr_capitalist;


import com.google.gson.Gson;
import generated.PallierType;
import generated.ProductType;
import generated.World;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 * REST Web Service
 *
 * @author afroment
 */
@Path("generic")
public class GenericResource {

    @Context
    private UriInfo context;
    private Services services;

    public GenericResource() {
        this.services = new Services();
    }

    @GET
    @Path("world")
    @Produces("application/xml")
    public Response getXml(@Context HttpServletRequest request) {
        try {
            World world = services.getWorld(request.getHeader("X-user"));
            return Response.ok(world).build();
        } catch (JAXBException ex) {
            Logger.getLogger(GenericResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    @GET
    @Path("world")
    @Produces("application/json")
    public Response getJsonFromXML(@Context HttpServletRequest request){
        try {
            World world = services.getWorld(request.getHeader("X-user"));
            return Response.ok(new Gson().toJson(world)).build();
        } catch (JAXBException ex) {
            Logger.getLogger(GenericResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}