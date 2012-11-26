package net.mybecks.dao;

import java.util.List;

import net.mybecks.pojo.Company;
import net.mybecks.pojo.Person;

import org.bson.types.ObjectId;

import com.google.code.morphia.Key;

public interface PersonDAO {
	public Key<Person> save(Person person);
//	public WriteResult deletePerson(ObjectId id);
	public Person findPerson(ObjectId personId);
//	public Key<Person> updatePerson(Person Person);
	public List<Person> findAllPersons();
	public List<Person> findPersonsByCompany(Company company);
}
