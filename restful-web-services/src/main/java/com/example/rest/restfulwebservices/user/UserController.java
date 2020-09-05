package com.example.rest.restfulwebservices.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserController {

	@Autowired
	private UserDaoService service;

	@GetMapping(path = "/users")
	public CollectionModel<EntityModel<User>> retrieveAllUsers() {
		List<User> users = service.findAll();
		ArrayList<EntityModel<User>> usersEntityModel = new ArrayList<>();
		for (final User user : users) {
			int userId = user.getId();
			EntityModel<User> userResouce = EntityModel.of(user);
			Link selfLink = linkTo(methodOn(this.getClass()).retrieveUser(userId)).withSelfRel();
			userResouce.add(selfLink);
			usersEntityModel.add(userResouce);
		}
		Link link = linkTo(this.getClass()).withSelfRel();
		CollectionModel<EntityModel<User>> resource = CollectionModel.of(usersEntityModel, link);
		return resource;
	}

	@GetMapping(path = "/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id) {
		User user = service.findOne(id);
		if (user == null)
			throw new UserNotFoundException("id-" + id);

		EntityModel<User> resource = EntityModel.of(user);

		Link selfLink = linkTo(methodOn(this.getClass()).retrieveUser(id)).withSelfRel();
		resource.add(selfLink);

		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		resource.add(linkTo.withRel("all-users"));

		return resource;
	}

	@PostMapping(path = "/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = service.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping(path = "/users/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable int id) {
		User user = service.deleteById(id);
		if (user == null)
			throw new UserNotFoundException("id-" + id);
		return ResponseEntity.noContent().build();
	}
}
