package model;

import java.util.ArrayList;
import java.util.Date;

public class ProfilePhoto {

	public String resourcePath;
	public ArrayList<String> likes;
	public Date uploadDate;

	public ProfilePhoto() {
		this.resourcePath = "No resources found";
		this.likes = new ArrayList<String>();
		this.uploadDate = new Date();
	}

	public ProfilePhoto(String resourcePath) {
		this.resourcePath = resourcePath;
		this.likes = new ArrayList<String>();
		this.uploadDate = new Date();
	}

	public String getResourcePath() {
		return resourcePath;
	}

	public void setResourcePath(String resourcePath) {
		this.resourcePath = resourcePath;
	}

	public ArrayList<String> getLikes() {
		return likes;
	}

	public void setLikes(ArrayList<String> likes) {
		this.likes = likes;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public void setLike(String username) {
		this.likes.add(username);
	}

	private int totalLikes() {
		int totalLikes = 0;
		for (int i = 0; i < likes.size(); i++) {
			totalLikes++;
		}
		return totalLikes;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("");
		sb.append("Profile Photo: " + resourcePath);
		sb.append("\t \t" + uploadDate);
		sb.append("\n Likes: " + totalLikes());
		return sb.toString();
	}
}
