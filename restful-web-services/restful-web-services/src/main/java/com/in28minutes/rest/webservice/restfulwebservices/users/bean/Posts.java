package com.in28minutes.rest.webservice.restfulwebservices.users.bean;

public class Posts {

	private Integer postID;
	private String postName;

	public Posts(Integer postID, String postName) {
		super();
		this.postID = postID;
		this.postName = postName;
	}

	public Integer getPostID() {
		return postID;
	}

	public void setPostID(Integer postID) {
		this.postID = postID;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	@Override
	public String toString() {
		return "Posts [postID=" + postID + ", postName=" + postName + "]";
	}

}
