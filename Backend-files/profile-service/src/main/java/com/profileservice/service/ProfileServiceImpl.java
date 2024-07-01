package com.profileservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.profileservice.model.Profile;
import com.profileservice.repository.ProfileRepository;

@Service
public class ProfileServiceImpl implements ProfileService{

	@Autowired
	private ProfileRepository repo;
	
	@Override
	public Profile addProfile(Profile newprofile) {
          if(repo.existsBymemberId(newprofile.getMemberId())) {
        	  throw new RuntimeException("Account already exist");
          }
		 return repo.save(newprofile);	
	}

	@Override
	public List<Profile> getMember() {
		// TODO Auto-generated method stub
		List<Profile>list=new ArrayList<>();
		list=repo.findAll();
		if(list.isEmpty()) {
      	  throw new RuntimeException("No Account Found");
        }
		 return list;
	}

	@Override
	public Profile getMemberById(String memberId) {
	
		if(!repo.existsBymemberId(memberId)) {
      	  throw new RuntimeException("Account does not exist");
        }
		 return repo.findBymemberId(memberId);
	}

	@Override
	public Profile updateProfile(String memberId, Profile newprofile) {
	
		newprofile.setMemberId(memberId);
		return repo.save(newprofile);	
		 
	}

	@Override
	public void removeProfile(String memberId) {
		// TODO Auto-generated method stub
		repo.deleteBymemberId(memberId);
		
	}
	
	

	
}
