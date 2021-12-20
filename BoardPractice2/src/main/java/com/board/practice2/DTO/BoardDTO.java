package com.board.practice2.DTO;

import java.sql.Timestamp;

public class BoardDTO {
	
	private int postNum;
	private String postTitle;
	private String postWriter;
	private String postContent;
	private Timestamp postTime;
	private int viewCount;
	private int commentCount;
	
	
	public int getPostNum() {
		return postNum;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public String getPostWriter() {
		return postWriter;
	}
	public String getPostContent() {
		return postContent;
	}
	public Timestamp getPostTime() {
		return postTime;
	}
	public int getViewCount() {
		return viewCount;
	}
	public int getCommentCount() {
		return commentCount;
	}
	public void setPostNum(int postNum) {
		this.postNum = postNum;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public void setPostWriter(String postWriter) {
		this.postWriter = postWriter;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public void setPostTime(Timestamp postTime) {
		this.postTime = postTime;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

}
