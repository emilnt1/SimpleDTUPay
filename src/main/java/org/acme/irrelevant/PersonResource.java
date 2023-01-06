package org.acme.irrelevant;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/person")
public class PersonResource {
    Person person = new Person("Henrik", "Buddinge");

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPerson() {
        return person;
    }

    @GET
    //@Path("/xml")
    @Produces(MediaType.APPLICATION_XML)
    public Person getPersonXML() {
        return person;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void updatePerson(Person person) {
        this.person = person;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void updatePersonXML(Person person) {
        this.person = person;
    }
}
