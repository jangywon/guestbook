package com.nhn.service;

public class ArticleService {

	public void writeArticle(NewArticleCommand command) {
		System.out.println("command : " + command);
	}
}
