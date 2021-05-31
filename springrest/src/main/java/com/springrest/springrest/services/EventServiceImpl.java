package com.springrest.springrest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.EventDao;
import com.springrest.springrest.entities.Event;

@Service
public class EventServiceImpl implements EventService{
	
	@Autowired
	private EventDao eventDao;
	
	//events
		@Override
		public List<Event> getEvents() {
			
			return eventDao.findAll();
		}

		@Override
		public Event addEvent(Event event) {
			// TODO Auto-generated method stub
			eventDao.save(event);
			return event;
		}

//		@Override
		public Event updateEvent(Event event) {
			eventDao.save(event);
			return event;
		}
	//
//		@Override
		public void deleteEvent(long parseLong) {
			Event entity = eventDao.getOne(parseLong);
			eventDao.delete(entity);
			
		}
	//
		@Override
		public Event getEventt(long id) {
			return eventDao.findById(id).get();
		}
	
		




}
