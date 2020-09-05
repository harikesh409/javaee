package com.example.rest.restfulwebservices.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
public class UserJPAController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	@GetMapping(path = "/jpa/users")
	public CollectionModel<EntityModel<User>> retrieveAllUsers() {
		List<User> users = userRepository.findAll();
		ArrayList<EntityModel<User>> usersEntityModel = new ArrayList<>();
		for (final User user : users) {
			int userId = user.getId();
			EntityModel<User> userResouce = EntityModel.of(user);
			Link selfLink = linkTo(methodOn(this.getClass()).retrieveUser(userId)).withSelfRel();
			userResouce.add(selfLink);
			Link postsLink = linkTo(methodOn(this.getClass()).retrieveAllPostsByUser(userId)).withRel("posts");
			userResouce.add(postsLink);
			usersEntityModel.add(userResouce);
		}
		Link link = linkTo(this.getClass()).withSelfRel();
		CollectionModel<EntityModel<User>> resource = CollectionModel.of(usersEntityModel, link);
		return resource;
	}

	@GetMapping(path = "/jpa/users/{id}")
	public EntityModel<Optional<User>> retrieveUser(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id);
		if (!user.isPresent())
			throw new UserNotFoundException("id-" + id);

		EntityModel<Optional<User>> resource = EntityModel.of(user);

		Link selfLink = linkTo(methodOn(this.getClass()).retrieveUser(id)).withSelfRel();
		resource.add(selfLink);

		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		resource.add(linkTo.withRel("all-users"));

		return resource;
	}

	@PostMapping(path = "/jpa/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = userRepository.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping(path = "/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userRepository.deleteById(id);
	}

	@GetMapping(path = "/jpa/users/{id}/posts")
	public CollectionModel<Post> retrieveAllPostsByUser(@PathVariable int id) {
		Optional<User> userOptional = userRepository.findById(id);
		if (!userOptional.isPresent())
			throw new UserNotFoundException("id-" + id);
		List<Post> posts = userOptional.get().getPosts();

		Link selfLink = linkTo(methodOn(this.getClass()).retrieveAllPostsByUser(id)).withSelfRel();
		Link userLink = linkTo(methodOn(this.getClass()).retrieveUser(id)).withRel("user");
		CollectionModel<Post> resource = CollectionModel.of(posts, selfLink, userLink);
		return resource;
	}

	@PostMapping(path = "/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPost(@PathVariable int id, @Valid @RequestBody Post post) {
		Optional<User> userOptional = userRepository.findById(id);
		if (!userOptional.isPresent())
			throw new UserNotFoundException("id-" + id);

		User user = userOptional.get();
		post.setUser(user);
		postRepository.save(post);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
}
