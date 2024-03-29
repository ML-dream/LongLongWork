package com.wl.testaction.machineManage;


import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.wl.forms.Machine;
import com.wl.forms.MachineRepair;
import com.wl.tools.Sqlhelper;

public class MachineRepairSpecServlet extends HttpServlet {

	private static final long serialVersionUID = 2493319358099243522L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	    
	    String machineId = request.getParameter("machineId");
	
		String	CustomerSql = 
		    	"select A.machineId,C.machineName,repairPart,repairFactory,errorDate,repairDate,repairPrice,principal,repairDetail,A.memo,B.staff_name staffName " +
		    	"from machineRepair A " +
		    	"left join employee_info B on A.principal=B.staff_Code " +
		    	"left join machinfo C on A.machineId=C.machineId " +
		    	"where A.machineId=?";
		String[] params = {machineId};
		MachineRepair result = new MachineRepair();
		
		try {
			result = Sqlhelper.exeQueryBean(CustomerSql, params, MachineRepair.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("result", result);
		
		request.getRequestDispatcher("machineManage/editMachineRepair.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		doGet(request,response);
	}
}













