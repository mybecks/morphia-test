package net.mybecks.pojo;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

@Entity(value="companys", noClassnameStored=true)
public class Company {
	
	@Id
	private ObjectId id;
	
	private String name;
	
	private Long noEmployees;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	  public Company withName(String name) {
		    this.name = name;
		    return this;
		  }
		  
	
	public Long getNoEmployees() {
		return noEmployees;
	}
	
	public void setNoEmployees(Long noEmployees) {
		this.noEmployees = noEmployees;
	}

	public Company withNumberOfEmployees(Long noEmployees) {
	    this.noEmployees = noEmployees;
	    return this;
	  }
	
	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}	
	
	@Override
	public String toString() {
		return "Company [name=" + name + ", noEmployees=" + noEmployees + "]";
	}
}
