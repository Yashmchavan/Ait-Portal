package com.springrest.springrest.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.NewsDao;
import com.springrest.springrest.entities.News;

@Service
public class NewsServiceImpl implements NewsService {
	@Autowired
	private NewsDao newsDao;

	//News 
		@Override
		public News addNews(News news) {
			news.setCreatedDate(new Date());
			news.setModifiedDate(new Date());
			return newsDao.save(news);
		}

		@Override
		public List<News> getNewss() {
			return newsDao.findAll();
		}

		@Override
		public News updateNews(News news) {
			news.setModifiedDate(new Date());
			newsDao.save(news);
			return news;
		}

		@Override
		public void deleteNews(long parseLong) {
			
			News entity = newsDao.getOne(parseLong);
			newsDao.delete(entity);
		}
		
		
		@Override
		public News getNewss(long id) {
			
			return newsDao.findById(id).get();
		}
		
		
		
		
		
		
}
