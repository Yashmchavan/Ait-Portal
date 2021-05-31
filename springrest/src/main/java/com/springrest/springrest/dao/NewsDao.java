package com.springrest.springrest.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.springrest.entities.News;


public interface NewsDao extends JpaRepository<News,Long>{

	List<News> findAll();

	News save(News news);

}
