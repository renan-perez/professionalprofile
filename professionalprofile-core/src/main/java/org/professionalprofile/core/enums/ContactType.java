package org.professionalprofile.core.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum ContactType {
	
    EMAIL(false),
    TELEPHONE(false),
    LINKEDIN(true),
    GITHUB(true),
    TWITTER(true),
    WEBSITE(false);
	
	public Boolean socialNetwork;
	
	public static List<ContactType> ENUMS = Arrays.asList(values());
	
	private ContactType(Boolean socialNetwork) {
		this.socialNetwork = socialNetwork;
	}
	
	public static List<ContactType> listSocialNetworkTypes() {
		return ENUMS.stream()
				.filter(t -> t.socialNetwork == true)
				.collect(Collectors.toList());
	}

}
