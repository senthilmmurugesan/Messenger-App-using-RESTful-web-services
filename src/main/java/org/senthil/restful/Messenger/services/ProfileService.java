package org.senthil.restful.Messenger.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.senthil.restful.Messenger.database.DatabaseClass;
import org.senthil.restful.Messenger.model.Profile;

public class ProfileService {

	public ProfileService() {
		profiles.put("senthil", new Profile(1L, "senthil", "Senthil", "Murugesan"));
		profiles.put("kumar", new Profile(2L, "kumar", "Kumar", "Murugesan"));
	}

	private Map<String, Profile> profiles = DatabaseClass.getProfiles(); 
	
	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile> (profiles.values());
	}
	
	public Profile getprofile(String name) {
		return profiles.get(name);
	}
	
	public Profile addprofile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateprofile(Profile profile) {
		if(profile.getProfileName().isEmpty())
			return null;
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeprofile(String name) {
		return profiles.remove(name);
	}
	
}
