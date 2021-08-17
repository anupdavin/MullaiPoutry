package com.inc.NewBatchEntry;

import java.util.UUID;

public class BatchIDGenerator {

	  public static final String batchIdGenerator(String batchName){
	    
		  System.out.println("Inside batchIdGenerator");		  
		  
		//generate random UUIDs
	    UUID idOne = UUID.randomUUID();
	    log("Batch ID : "+batchName+"--" + idOne);
		
	    String batchID = batchName+"--" + idOne;
	    System.out.println("batchID = "+batchID);
	    
	    return batchID;
	  }
	  
	  private static void log(Object object){
	    System.out.println( String.valueOf(object) );
	  }

}
