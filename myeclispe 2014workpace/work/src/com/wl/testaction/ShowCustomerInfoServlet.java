package com.wl.testaction;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wl.tools.StringUtil;
import com.wl.forms.Customer;
import com.wl.forms.User;
import com.wl.tools.Sqlhelper;

public class ShowCustomerInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int pageNo=0;
	    int countPerPage=10;
	    int totalCount = 0;
	    String orderStr = "COMPANYID";
	    orderStr = StringUtil.isNullOrEmpty(request.getParameter("sortField"))?orderStr:request.getParameter("sortField");
	    pageNo = Integer.parseInt(request.getParameter("pageIndex"))+1;
	    countPerPage = Integer.parseInt(request.getParameter("pageSize"));
	    String customerName=StringUtil.isNullOrEmpty(request.getParameter("customerName"))?"":request.getParameter("customerName");
	    
	    HttpSession session = request.getSession();
		String userId = ((User)session.getAttribute("user")).getUserId();
	    
	    String totalCountSql = "select count(*) from customer where istogether='Y' and companyname like '%"+customerName+"%'";
	    try {
			totalCount = Sqlhelper.exeQueryCountNum(totalCountSql, null);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	    String CustomerSql= "";
	    CustomerSql = 
	    	"select COMPANYID,COMPANYNAME,FOUNDEINGTIME,EMPLLOYEENUM,TYPE,ADDRESS,POSTCODE,TELEPHONE," +
	    	"WEBADDRESS,HEADER,BUSINESS,ADVISE,C.Name typeName,connector,connectorTel " +
	    	"from (select A.*,ROWNUM row_num from (select EM.* from customer EM  where companyname like '%"+customerName+"%' order by "+orderStr+" asc) A where ROWNUM<="+(countPerPage*pageNo)+" and ISTOGETHER='Y' order by "+orderStr+") B " +
	    	"left join companytype C on B.TYPE=C.id " +
	    	"where row_num>="+((pageNo-1)*countPerPage+1)+" order by "+orderStr;
	
	    List<Customer> customerList = new ArrayList<Customer>();
	    try {
			customerList = Sqlhelper.exeQueryList(CustomerSql, null, Customer.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	    String json = PluSoft.Utils.JSON.Encode(customerList);
		json = "{\"total\":"+totalCount+",\"data\":"+json+"}";
		response.setCharacterEncoding("UTF-8");
		response.getWriter().append(json).flush();
		System.out.println(json);
	    
	    
//	    System.out.println("CustomerSql=="+CustomerSql);
//	    
//	    ResultSet CustomerRs =null;
//		try{
//			CustomerRs = Sqlhelper.executeQuery(CustomerSql, null);
//			List<Customer> customerList = new ArrayList<Customer>();
//			try {
//				while (CustomerRs.next()) {
//					Customer customer = new Customer();
//					
//					customer.setCompanyId(CustomerRs.getString(1));
//					customer.setCompanyName(CustomerRs.getString(2));
//					customer.setFoundingTime(CustomerRs.getString(3));
//					customer.setEmployeeNum(CustomerRs.getString(4));
//					customer.setType(CustomerRs.getString(5));
//					customer.setAddress(CustomerRs.getString(6));
//					customer.setPostCode(CustomerRs.getString(7));
//					customer.setTelephone(CustomerRs.getString(8));
//					customer.setWebAddress(CustomerRs.getString(9));
//					customer.setHeader(CustomerRs.getString(10));
//					customer.setBusiness(CustomerRs.getString(11));
//					customer.setAdvise(CustomerRs.getString(12));
//					customer.setTypeName(CustomerRs.getString(13));
//					customer.setConnector(CustomerRs.getString(14));
//					customer.setConnectorTel(CustomerRs.getString(15));
//					
//					customerList.add(customer);
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			String json = PluSoft.Utils.JSON.Encode(customerList);
//			
//			json = "{\"total\":"+totalCount+",\"data\":"+json+"}";
//			response.setCharacterEncoding("UTF-8");
//			response.getWriter().append(json).flush();
//			System.out.println(json);
//		}catch(Exception e){
//		}  finally{
//			try {
//				if(CustomerRs!=null){
//					CustomerRs.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		doGet(request,response);
	}
}













