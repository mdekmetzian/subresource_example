package com.mike.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response.Status;

import com.mike.models.Pet;

import java.util.Collections;
import java.util.List; 
import java.util.ArrayList; 

@Path("/pets")
public class PetResource {

	private final int owner; 
	
	private static List<Pet> pets = new ArrayList<Pet>(4); 
	
	static {
		/* owner 1 */
		pets.add(new Pet(1, 1, "Molly")); 
		pets.add(new Pet(2, 1, "Subie")); 
		/* owner 2 */
		pets.add(new Pet(3, 2, "Barry"));
		/* owner 3 */
		pets.add(new Pet(4, 3, "Ellie")); 
	}
	
	public PetResource() {
		this.owner = -1; 
	}
	public PetResource(int owner) {
		this.owner = owner; 
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pet> getPets() {
		if(owner == -1) {
			return pets; 
		}
		List<Pet> ret = null; //new ArrayList<Pet>(4);
		for(Pet p: pets) {
			if(p.getOwnerId() == owner) {
				if(ret == null) ret = new ArrayList<Pet>(4); 
				ret.add(p); 
			}
		}
		if(ret != null) return ret; 
		return Collections.emptyList();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{petId}")
	public Response getPet(@PathParam("petId") int petId) {
		for(Pet p: pets) {
			if(p.getId() == petId) {
				if(owner == -1 /* all owners */ || owner == p.getOwnerId() /* only specific owner */) return Response.ok(p).build();
			}
		}
		return Response.status(Status.NOT_FOUND).build();
		
	}	
}
