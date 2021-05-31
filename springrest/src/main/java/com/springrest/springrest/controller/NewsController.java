package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.springrest.springrest.entities.News;
import com.springrest.springrest.services.NewsService;


@RestController
@RequestMapping("/news")
public class NewsController {
	
	@Autowired
	private NewsService newsService;
	
	//add the news
		@PostMapping("/add")
		public News addNews(@RequestBody News news)
		{
			return this.newsService.addNews(news);
		}
		
		//get the news
		@GetMapping("/all")
		public List<News> getNewss()
		{
			return this.newsService.getNewss();
		}
		
		//get news by id
		@GetMapping("/findById/{id}")
		public News getNewss(@PathVariable String id)
		{
			return this.newsService.getNewss(Long.parseLong(id));
		}
		
		
		
		
		
		
		
		//update the news
		@PutMapping("/update")
		public News updateUser(@RequestBody News news)
		{
			return this.newsService.updateNews(news);
		}
		
		
		
		
		//delete the news
		@DeleteMapping("/delete/{newsId}")
		//@CrossOrigin(origins = "http://localhost:4200")
		public ResponseEntity<HttpStatus> deleteNews(@PathVariable String newsId){
			try {
				this.newsService.deleteNews(Long.parseLong(newsId));
				return new ResponseEntity<>(HttpStatus.OK);
			}catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		
		
		
		
		
				
}
