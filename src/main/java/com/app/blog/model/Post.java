
package com.app.blog.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "post")
public class Post {

	public Post() {};
	
	private String title;
	private String description;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
