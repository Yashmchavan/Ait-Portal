package com.springrest.springrest.entities;


import java.util.Date;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String event; 
	private String description;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date date;
	
	//@Temporal(TemporalType.DATE) 
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
	//private Date end_date;
	
	//@JsonFormat(pattern = "HH:mm:ss")
   // private LocalTime time;
	
	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Event(long id, String event, String description, Date date) {
		super();
		this.id = id;
		this.event = event;
		this.description = description;
		this.date = date;
		
	}

	@Column(name = "id", unique = true, nullable = false)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	 @Column(name = "event")
	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}
	 @Column(name = "description")
	public String getDescription() {
		return description;
	}

	 
	public void setDescription(String description) {
		this.description = description;
	}

	
	@Column(name = "date", length = 23)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", event=" + event + ", description=" + description + ", date=" + date
				+ "]";
	}
	

}
