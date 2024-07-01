package com.profileservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.profileservice.model.Cart;
import com.profileservice.model.Profile;
import com.profileservice.service.ProfileService;

@RestController
@RequestMapping("/profile")
public class ProfileController {
	
	@Autowired
	private ProfileService service;
	
	@Autowired
	RestTemplate restTemplate;

	@PostMapping("/adduser")
	public Profile addProfile(@RequestBody Profile newprofile) {
		Profile user=service.addProfile(newprofile);
		restTemplate.postForObject("http://localhost:8100/cart/newcart/"+user.getMemberId(), user, Cart.class);	
		return user;
	}
	
	@GetMapping("/getProfile")
	public List<Profile> getMember() {
		return service.getMember();
	}
	
	@GetMapping("/getProfile/{memberId}")
	public Profile getMemberById(@PathVariable("memberId") String memberId) {
		return service.getMemberById(memberId);
	}
	
	@PutMapping("/updateprofile/{memberId}")
	public Profile updateProfile(@PathVariable("memberId") String memberId,Profile newprofile) {
		return service.updateProfile(memberId,newprofile);
	}
	
	@DeleteMapping("/removeprofile/{memberId}")
	public void removeProfile(@PathVariable("memberId") String memberId) {
		service.removeProfile(memberId);
		
	}
	
	
	
}
