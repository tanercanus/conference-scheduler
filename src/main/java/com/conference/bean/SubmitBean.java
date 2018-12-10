package com.conference.bean;

import org.hibernate.validator.constraints.NotEmpty;

public class SubmitBean {

	@NotEmpty
	String postInput;

	public String getPostInput() {
		return postInput;
	}

	public void setPostInput(String postInput) {
		this.postInput = postInput;
	}

}
