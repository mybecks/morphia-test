package net.mybecks.dao;

import java.util.List;

import net.mybecks.mongo.MongoConnectionManager;
import net.mybecks.pojo.Company;
import net.mybecks.pojo.Person;

import org.bson.types.ObjectId;

import com.google.code.morphia.dao.BasicDAO;


public class PersonDAOImpl extends BasicDAO<Person, ObjectId> implements PersonDAO {

	public PersonDAOImpl(){
		super(Person.class, MongoConnectionManager.getInstance().getDb());
	}
		
	@Override
	public Person findPerson(ObjectId personId) {
		
		return get(personId);
	}

	@Override
	public List<Person> findAllPersons() {
		
		return find().asList();
	}

	@Override
	public List<Person> findPersonsByCompany(Company company) {
		return createQuery().field("company").equal(company).asList();
	}
}
