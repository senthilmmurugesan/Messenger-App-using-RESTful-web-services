package org.senthil.restful.Messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.senthil.restful.Messenger.model.Profile;
import org.senthil.restful.Messenger.services.ProfileService;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class ProfileResource {
	private ProfileService profileService = new ProfileService();
	
	
	@GET
	public List<Profile> getAllProfiles() {
		return profileService.getAllProfiles();
	}
	
	@POST
	public Profile addProfile(Profile profile) {
		return profileService.addprofile(profile);
	}
	
	@PUT
	@Path("/{profileId}")
	public Profile updateProfile(@PathParam("profileId") String name, Profile profile) {
		profile.setProfileName(name);
		return profileService.updateprofile(profile);
	}
	
	@DELETE
	@Path("/{profileId}")
	public void removeProfile(@PathParam("profileId") String name) {
		profileService.removeprofile(name);
	}
	
	@GET
	@Path("/{profileId}")
	public Profile getProfile(@PathParam("profileId") String name) {
		return profileService.getprofile(name);
	}
}
