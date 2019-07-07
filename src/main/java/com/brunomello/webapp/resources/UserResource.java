package com.brunomello.webapp.resources;

import java.net.Authenticator.RequestorType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.brunomello.webapp.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> findAll() {
		User maria = new User("1", "Maria Silva", "maria@gmail.com");
		User carlos = new User("2", "Carlos Alberto", "carlosal@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria,carlos));
		return ResponseEntity.ok().body(list);
		
	}

}
