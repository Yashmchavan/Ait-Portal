package com.springrest.springrest.services;

import java.util.List;

import com.springrest.springrest.entities.News;

public interface NewsService {
	public News addNews(News news);
	public List<News> getNewss();
	public News updateNews(News news);
	public void deleteNews(long parseLong);
	public News getNewss(long id);

}
