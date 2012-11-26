package net.mybecks.mongo;

import net.mybecks.pojo.Company;
import net.mybecks.pojo.Person;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;

public class MongoConnectionManager {
	private static final MongoConnectionManager INSTANCE = new MongoConnectionManager();

	private final Datastore db;
	public static final String DB_NAME = "personDB";

	private MongoConnectionManager() {
		try {
			Mongo m = new Mongo("localhost", 27017);
			db = new Morphia().map(Person.class).map(Company.class).createDatastore(m, DB_NAME);
			db.ensureIndexes();
		} catch (Exception e) {
			throw new RuntimeException("Error initializing mongo db", e);
		}
	}

	public static MongoConnectionManager getInstance() {
		return INSTANCE;
	}

	public Datastore getDb() {
		return db;
	}

}
