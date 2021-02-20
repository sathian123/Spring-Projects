package com.in28minutes.rest.webservice.restfulwebservices.users.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28minutes.rest.webservice.restfulwebservices.users.Exception.PostNotFoundException;
import com.in28minutes.rest.webservice.restfulwebservices.users.Exception.UserNotFoundException;
import com.in28minutes.rest.webservice.restfulwebservices.users.bean.Posts;
import com.in28minutes.rest.webservice.restfulwebservices.users.bean.User;
import com.in28minutes.rest.webservice.restfulwebservices.users.dao.UsersDAO;

@RestController
public class UserController {

	@Autowired
	private UsersDAO usersDAO;

	@GetMapping("users")
	public List<User> retrieveAllUsers() {

		return usersDAO.getAllUsers();

	}

	@GetMapping("users/{id}")
	public User retrieveAllUsers(@PathVariable int id) {

		User user = usersDAO.findOneUser(id);
		if (user == null) {
			throw new UserNotFoundException("id -> " + id);
		}

		return usersDAO.findOneUser(id);

	}

	@PostMapping("users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = usersDAO.saveUser(user);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

	@GetMapping("users/{id}/posts")
	public List<Posts> retrieveAllPostsforaUser(@PathVariable Integer id) {

		return usersDAO.getAllPostsforaUsers(id);

	}

	@PostMapping("users/{id}/posts")
	public List<Posts> addPostsforaUser(@PathVariable Integer id, @RequestBody Posts post) {

		return usersDAO.addPostsforaUser(id, post);

	}

	@GetMapping("users/{id}/posts/{pid}")
	public Posts addPostsforaUser(@PathVariable Integer id, @PathVariable Integer pid) {

		Posts post = usersDAO.getParticulatPostsforaUser(id, pid);
		if (post == null) {
			throw new PostNotFoundException("posts not found for user " + id);
		}
		return post;

	}

	@DeleteMapping("users/{id}")
	public void deleteUser(@PathVariable int id) {

		User user = usersDAO.deleteUser(id);
		if (user == null) {
			throw new UserNotFoundException("id -> " + id);
		}

	}

}
