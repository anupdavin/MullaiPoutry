package com.inc.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.DateScheduler.DateTimeInput;
import com.inc.ExcelEntry.ExcelEntry;
import com.inc.NewBatchEntry.BatchEntry;




/**
 * Servlet implementation class IncubatorServlet
 */
public class IncubatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IncubatorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		System.out.println("Inside doPost ");
		
		String page = request.getParameter("pageIdentifier");
		System.out.println("page = "+page);

		if (page.equalsIgnoreCase("newBatchEntryPage")){
			BatchEntry batchEntry = new BatchEntry();
			batchEntry.newBatchEntry(request);
			
		}
		
		/*		
		
		//Batch entry part
		BatchEntry batchEntry = new BatchEntry();
		ArrayList<String> batchDetails = 
				batchEntry.newBatchEntry(request,dateTimeSchedule);
		System.out.println("batch entry part completed");

		//Excel entry part
		ExcelEntry.enterNewBatchDetailsToExcel(batchDetails);
		System.out.println("Excel entry part Completed");
		
		//Maintenance part
		
		
		//Batch completion entry
		
		
		
		//JSP reply part
		
	*/	
		
		System.out.println("End of servlet");
		
	}

	

}
