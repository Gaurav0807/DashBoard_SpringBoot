package com.example.demo.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repo.UserRepo;


@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	private UserRepo repo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	
	public UserServiceImpl(UserRepo repo) {
		super();
		this.repo = repo;
	}



	@Override
	public User save(UserRegister u) {
		User u1 = new User(u.getFirstName(),u.getLastName(),u.getEmail(),passwordEncoder.encode(u.getPassword()),
				Arrays.asList(new Role("Role_User")));
		return repo.save(u1);
	}



	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		User user = repo.findByEmail(username);
		if(user==null)
		{
			throw new UsernameNotFoundException("Invalid Username or password");
		}
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
	}



	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		// TODO Auto-generated method stub
		return roles.stream().map(role-> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

}
