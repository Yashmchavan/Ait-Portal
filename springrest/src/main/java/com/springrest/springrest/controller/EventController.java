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

import com.springrest.springrest.entities.Event;
import com.springrest.springrest.services.EventService;


@RestController
@RequestMapping("/event")
public class EventController {
	@Autowired
	private EventService eventService;
	
	//get event
	@GetMapping("/all")
	public List<Event> getEvents()
	{
		return this.eventService.getEvents();
	}
	
	//add the event
			@PostMapping("/add")
			public Event addEvent(@RequestBody Event event)
			{
				return this.eventService.addEvent(event);
			}
			
//			//update the event
			@PutMapping("/update")
			
			public Event updateEvent(@RequestBody Event event)
			{
				return this.eventService.updateEvent(event);
			}
			
			
//			//delete the event
			@DeleteMapping("/delete/{Id}")
			
			public ResponseEntity<HttpStatus> deleteUser(@PathVariable String Id){
				try {
					this.eventService.deleteEvent(Long.parseLong(Id));
					return new ResponseEntity<>(HttpStatus.OK);
				}catch (Exception e) {
					return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}
//			
//			//get event by id
			@GetMapping("/findById/{id}")
			public Event getEventt(@PathVariable String id)
			{
				return this.eventService.getEventt(Long.parseLong(id));
			}

			
}
