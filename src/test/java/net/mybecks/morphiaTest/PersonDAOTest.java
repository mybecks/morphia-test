package net.mybecks.morphiaTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import net.mybecks.dao.PersonDAO;
import net.mybecks.dao.PersonDAOImpl;
import net.mybecks.mongo.MongoConnectionManager;
import net.mybecks.pojo.Company;
import net.mybecks.pojo.Person;

import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;

import com.google.code.morphia.dao.BasicDAO;

public class PersonDAOTest {

	private PersonDAO personDAO;
	private BasicDAO<Company, ObjectId> companyDAO;
	
	private final Company ibm = new Company().withName("IBM").withNumberOfEmployees(Long.valueOf(426751));
	private final Company samsung = new Company().withName("Samsung").withNumberOfEmployees(Long.valueOf(290000));
	
	@Before
	public void before() {
		Util.drop();
		personDAO = new PersonDAOImpl();
		
		companyDAO = new BasicDAO<Company, ObjectId>(Company.class, MongoConnectionManager.getInstance().getDb());
	    
		/**
		 * "Pre" store the company, so that they will haven an objectId, otherwise it will throw new Mapping Exception
		 * see here for more information: http://code.google.com/p/morphia/issues/detail?id=315
		 */
		ArrayList<Company> arrList = new ArrayList<Company>();
		arrList.add(ibm);
		arrList.add(samsung);
		
	    for (Company c : arrList) {
	      companyDAO.save(c);
	    }
	}

	private Person createPerson(){		
		Person person = new Person();
		person.setSurename("Sue");
		person.setName("Walker");
		person.setEmail("sue.walker@ibm.com");
		person.withCompany(ibm);
		
		personDAO.save(person);
		return person;
	}
	
	@Test
	public void testPersistance() {	
		Person person = createPerson();
		
		assertNotNull("Person saved must now have an id", person.getId());
	    person = personDAO.findPerson(person.getId());
	    assertNotNull("Person must have been retrieved", person); 
//	    assertTrue(order.getLines().size() == 1);
	    
	    // Update
//	    order.getLines().add(new LineItem().withLineNumber(order.getLines().size() + 1).withProduct(wii).withQuantity(2));
//	    orderDao.save(order);
//	    order = orderDao.find(order.getId());
//	    assertTrue(order.getLines().size() == 2);
	}

	@Test
	  public void query() {
	    createPerson();
	    List<Person> persons = personDAO.findPersonsByCompany(ibm);
	    assertTrue("Should have obtained a single order for the customer" , persons.size() == 1);
	    persons = personDAO.findPersonsByCompany(samsung);
	    assertTrue("Should not have found any orders for the customer" , persons.size() == 0);
	  }
}
