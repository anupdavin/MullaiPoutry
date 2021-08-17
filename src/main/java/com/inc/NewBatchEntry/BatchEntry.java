package com.inc.NewBatchEntry;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.inc.DateScheduler.DateTimeInput;
import com.inc.ExcelEntry.ExcelEntry;
import com.inc.inputFromJSP.InputFromJSP;

public class BatchEntry {


	public ArrayList<String> newBatchEntry(HttpServletRequest request) {
		
		System.out.println("Inside newBatchEntry");
		
		/*
		//Input from JSP part
		InputFromJSP inputFromJSP = new InputFromJSP();
		ArrayList<String> inputFromNewBatchEntryJSP = 
				inputFromJSP.inputFromNewBatchEntryJSP(request);
			*/	
		
		String type_of_eggs = request.getParameter("type_of_eggs");
		System.out.println("type_of_eggs = "+type_of_eggs);
		
		String selected_row = request.getParameter("selected_row");
		System.out.println("selected_row = "+selected_row);
		
		String no_of_eggs = request.getParameter("no_of_eggs");
		System.out.println("no_of_eggs = "+no_of_eggs);

		
		
		System.out.println("date time part started");
		//DateTimeInput
		DateTimeInput dateTimeInput = new DateTimeInput();
		ArrayList<String> dateTimeSchedule= 
				dateTimeInput.dateTimeSchedule(request, type_of_eggs);
		System.out.println("date part completed");

		
		String batchName = dateTimeSchedule.get(0)+ dateTimeSchedule.get(3);
		System.out.println("batchName = "+batchName);

		String batchID = BatchIDGenerator.batchIdGenerator(batchName);
		System.out.println("batchID = "+batchID);
		
		  System.out.println();
		
		ArrayList<String> batchDetails = new ArrayList<String>() ;
		
		batchDetails.add(batchID);
		batchDetails.add(batchName);
		batchDetails.add(type_of_eggs);
		batchDetails.add(selected_row);
		batchDetails.add(no_of_eggs);
		batchDetails.add(dateTimeSchedule.get(0));
		batchDetails.add(dateTimeSchedule.get(1));
		batchDetails.add(dateTimeSchedule.get(2));
		batchDetails.add(dateTimeSchedule.get(3));
		
		//Excel entry part
		ExcelEntry.enterNewBatchDetailsToExcel(batchDetails);
		System.out.println("Excel entry part Completed");

		log(batchDetails); 
		
		return batchDetails;
	}
	
	private static void log(ArrayList<String> batchDetails) {
		for(int i=0;i<batchDetails.size();i++)
			System.out.println(batchDetails.get(i));
	}

}
