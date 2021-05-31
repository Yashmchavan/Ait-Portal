package com.springrest.springrest.entities;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;



@Entity
@EntityListeners(AuditingEntityListener.class)
public class News {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(columnDefinition = "LONGTEXT")
	private String news;
	
	
    private String title;
	
	
	private Date createdDate;
	
	
	private Date modifiedDate;
	
	public News() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public News(long id, String news, String title,Date createdDate, Date modifiedDate) {
		super();
		this.id = id;
		this.news = news;
		this.title = title;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
	}





	

   public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNews() {
		return news;
	}
	public void setNews(String news) {
		this.news = news;
	}
	
	
	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public Date getCreatedDate() {
		return createdDate;
	}



	public void setCreatedDate(Date date) {
		this.createdDate = date;
	}



	public Date getModifiedDate() {
		return modifiedDate;
	}



	public void setModifiedDate(Date date) {
		this.modifiedDate = date;
	}




	@Override
	public String toString() {
		return "News [id=" + id + ", news=" + news + ", title=" + title + ", createdDate=" +  createdDate +",modifiedDate=\" +  modifiedDate +\"]";
	}

	
}
