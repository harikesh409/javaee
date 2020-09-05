package com.example.rest.restfulwebservices.user;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description = "Post details of a particular user")
public class Post {
	@Id
	@GeneratedValue
	private Integer id;

	@NotNull
	@Size(min = 5, message = "Description must be atleast 5 characters.")
	@ApiModelProperty(value = "Description must be atleast 5 characters.", required = true)
	private String description;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@ApiModelProperty(value = "Particular user that the post has to be linked.", required = true)
	private User user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return String.format("Post [id=%s, description=%s]", id, description);
	}

}
