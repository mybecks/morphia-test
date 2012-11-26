package net.mybecks.morphiaTest;

import net.mybecks.mongo.MongoConnectionManager;

import com.mongodb.Mongo;


public final class Util {
  
  public static void drop() {
	    Mongo mongo = MongoConnectionManager.getInstance().getDb().getMongo();
	 	    
	     mongo.getDB(MongoConnectionManager.DB_NAME).dropDatabase();
	    
	  }
  
}
