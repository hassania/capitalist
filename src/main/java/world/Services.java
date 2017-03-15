package com.mycompany.swr_capitalist;

import generated.PallierType;
import generated.ProductType;
import generated.World;
import java.io.File;
import java.io.InputStream;
import java.math.BigInteger;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.UnmarshalException;
import javax.xml.bind.Unmarshaller;

public class Services {

   private World readWorldFromXml() throws JAXBException {
        JAXBContext cont = JAXBContext.newInstance(World.class);
        Unmarshaller u = cont.createUnmarshaller();
        World world;
        try {
            world = (World) u.unmarshal(new File("world.xml"));
        } catch(UnmarshalException e) {
            InputStream input = getClass().getClassLoader().getResourceAsStream("world.xml");
            world = (World) u.unmarshal(input);
        }
        return world;
    }

    private void saveWorldToXml(World world) throws JAXBException {
        JAXBContext cont = JAXBContext.newInstance(World.class);
        Marshaller m = cont.createMarshaller();
        m.marshal(world, new File("world.xml"));
    }
    
    public World getWorld(String username) throws JAXBException {
        World world = readWorldFromXml();
        return world;
    }

}
