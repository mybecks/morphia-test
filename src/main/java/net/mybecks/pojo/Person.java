package net.mybecks.pojo;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Reference;

@Entity(value="persons", noClassnameStored=true)
public class Person {

	@Id
	private ObjectId id;
	private String name;
	private String surename;
	
	private String Email;
	
	@Reference
	private Company company;
	
	public ObjectId getId() {
		return id;
	}
	
	public void setId(ObjectId id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurename() {
		return surename;
	}
	
	public void setSurename(String surename) {
		this.surename = surename;
	}
	
	public String getEmail() {
		return Email;
	}
	
	public void setEmail(String eMail) {
		this.Email = eMail;
	}
	
	public Company getCompany() {
		return company;
	}
	
	public void setCompany(Company company) {
		this.company = company;
	}
	
	public Person withCompany(Company company) {
	    this.company = company;
	    return this;
	  }

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", surename=" + surename
				+ ", eMail=" + Email + ", company=" + company + "]";
	}
	
	
}
