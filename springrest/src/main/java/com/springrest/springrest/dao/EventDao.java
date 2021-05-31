package com.springrest.springrest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.springrest.entities.Event;


public interface EventDao extends JpaRepository<Event,Long> {

	List<Event> findAll();
	
	

}
