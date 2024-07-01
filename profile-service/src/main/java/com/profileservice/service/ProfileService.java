package com.profileservice.service;

import java.util.List;

import com.profileservice.model.Profile;

public interface ProfileService{

	Profile addProfile(Profile newprofile);

	List<Profile> getMember();

	Profile getMemberById(String memberId);

	Profile updateProfile(String memberId, Profile newprofile);

	void removeProfile(String memberId);

}
