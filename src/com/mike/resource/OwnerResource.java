package com.mike.resource;

import com.mike.models.Owner; 
import java.util.List; 
import java.util.ArrayList; 

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response.Status;

@Path("/owners")
public class OwnerResource {
	
	private static List<Owner> owners = new ArrayList<Owner>(3); 
	static {
		owners.add(new Owner(1, "Bill")); 
		owners.add(new Owner(2, "Ted"));
		owners.add(new Owner(3, "Rufus"));
	}
	
	public List<Owner> getOwners() {
		return owners; 
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOwner(@PathParam("id") int id) {
		for(Owner o : owners) {
			if(o.getId() == id) {
				return Response.ok(o).build(); 
			}
		}
		return Response.status(Status.NOT_FOUND).build();
	}
	
	@GET
	@Path("{id}/pets")
	@Produces(MediaType.APPLICATION_JSON)
	public PetResource getOwnerPets(@PathParam("id") int id) {
		return new PetResource(id); 
	}
}
