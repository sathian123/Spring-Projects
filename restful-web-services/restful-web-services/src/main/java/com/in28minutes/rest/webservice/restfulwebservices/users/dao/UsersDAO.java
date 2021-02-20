package com.in28minutes.rest.webservice.restfulwebservices.users.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.in28minutes.rest.webservice.restfulwebservices.users.bean.Posts;
import com.in28minutes.rest.webservice.restfulwebservices.users.bean.User;

@Component
public class UsersDAO {

	private static List<User> los = new ArrayList<User>();
	private static List<Posts> post1 = new ArrayList<Posts>();
	private static List<Posts> post2 = new ArrayList<Posts>();

	private static int userCount = 2;

	static {

		post1.add(new Posts(1, "valimai"));
		post1.add(new Posts(2, "master"));

		post2.add(new Posts(1, "singam"));
		post2.add(new Posts(2, "siruthai"));

		los.add(new User(1, "sathian", new Date(), post1));
		los.add(new User(2, "nivetha", new Date(), post2));

	}

	public List<User> getAllUsers() {
		return los;
	}

	public User saveUser(User user) {
		if (user.getId() == null) {
			user.setId(++userCount);
		}
		los.add(user);
		return user;
	}

	public User findOneUser(int id) {
		for (User user : los) {
			if (user.getId() == id) {
				return user;
			}

		}
		return null;
	}

	public List<Posts> getAllPostsforaUsers(Integer id) {
		for (User user : los) {
			if (user.getId() == id) {
				return user.getPosts();
			}

		}
		return null;
	}

	public List<Posts> addPostsforaUser(Integer id, Posts post) {
		for (User user : los) {
			if (user.getId() == id) {
				user.getPosts().add(post);
			}

		}

		// TODO Auto-generated method stub
		return null;
	}

	public Posts getParticulatPostsforaUser(Integer id, Integer pid) {
		for (User user : los) {
			if (user.getId() == id) {
				for (Posts posts : user.getPosts()) {
					if (posts.getPostID() == pid) {
						return posts;
					}

				}
			}

		}
		return null;
	}

	public User deleteUser(Integer id) {

		Iterator<User> users = los.iterator();
		while (users.hasNext()) {
			User user = users.next();
			if (user.getId() == id) {
				users.remove();
				return user;
			}

		}

		return null;
	}

}
