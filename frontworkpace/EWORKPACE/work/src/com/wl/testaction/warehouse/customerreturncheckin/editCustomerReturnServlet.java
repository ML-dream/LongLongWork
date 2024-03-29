package com.wl.testaction.warehouse.customerreturncheckin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wl.forms.CustomerReturn;
import com.wl.tools.Sqlhelper;

public class editCustomerReturnServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public editCustomerReturnServlet() {
		super();
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html,charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String sheetId=request.getParameter("sheetId");
		String sql="select sheetid,returndate,orderid,B.companyid,B.connector,B.connectortel,C.companyname from customerreturn B " +
				"left join customer C on C.companyid=B.companyid  where sheetid='"+sheetId+"'";
		
		CustomerReturn customerreturn=new CustomerReturn();
		
		try{
			customerreturn=Sqlhelper.exeQueryBean(sql, null, CustomerReturn.class);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		request.setAttribute("customerreturn", customerreturn);
		request.getRequestDispatcher("/Checkin/editCustomerReturn.jsp").forward(request, response);
	}

}
