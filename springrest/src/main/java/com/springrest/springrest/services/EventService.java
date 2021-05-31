package com.springrest.springrest.services;

import java.util.List;

import com.springrest.springrest.entities.Event;

public interface EventService {
	//event
		public List<Event> getEvents();
		public Event addEvent(Event event);
		public Event updateEvent(Event event);
		public void deleteEvent(long parseLong);
		public Event getEventt(long id);

}
