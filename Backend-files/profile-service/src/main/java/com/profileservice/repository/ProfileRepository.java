package com.profileservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.profileservice.model.Profile;

public interface ProfileRepository extends MongoRepository<Profile,String>{

	boolean existsBymemberId(String memberId);

	Profile findBymemberId(String memberId);

	void deleteBymemberId(String memberId);
	
	

}
