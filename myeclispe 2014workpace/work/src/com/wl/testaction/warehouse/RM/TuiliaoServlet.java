package com.wl.testaction.warehouse.RM;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wl.forms.User;
import com.wl.tools.LlData;
import com.wl.tools.Sqlhelper;
import com.wl.tools.TlData;

public class TuiliaoServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		String data=request.getParameter("submitData");
		HashMap datamap = (HashMap)Test.JSON.Decode(data);
		String rmDate=(String) datamap.get("rmDate");
		String rmSheetid=(String) datamap.get("rmSheetid");
		String warehouseId=(String) datamap.get("warehouseId");
		String warehouseName=(String) datamap.get("warehouseName");
		String empId=(String) datamap.get("empId");
		String emp=(String) datamap.get("emp");
		String dept=(String) datamap.get("dept");
		String operatorId=(String) datamap.get("operatorId");
		String operator=(String) datamap.get("operator");
		String id=(String) datamap.get("id");
		String seq=(String) datamap.get("seq");
		String item_id1=(String) datamap.get("itemid_name1");
		String item_id2=(String) datamap.get("itemid_name2");
		String item_id3=(String) datamap.get("itemid_name3");
		String item_id4=(String) datamap.get("itemid_name4");
		String item_id5=(String) datamap.get("itemid_name5");
		String item_id6=(String) datamap.get("itemid_name6");
		String item_id7=(String) datamap.get("itemid_name7");
		String item_id8=(String) datamap.get("itemid_name8");
		String item_id9=(String) datamap.get("itemid_name9");
		String item_id10=(String) datamap.get("itemid_name10");
		
		 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		 String createTime = df.format(new Date());
		 String changeTime = df.format(new Date());
		    
		 HttpSession session = request.getSession();
		 String createPerson = ((User)session.getAttribute("user")).getStaffCode();
		 String changePerson = ((User)session.getAttribute("user")).getStaffCode();
		
		 if(item_id1!=""||item_id2!=""||item_id3!=""||item_id4!=""||item_id5!=""||item_id6!=""||item_id7!=""
				||item_id8!=""||item_id9!=""||item_id10!="")
			{
				String sql="insert into tuiliao values(to_date('"+rmDate+"','yyyy-mm-dd,hh24:mi:ss'),'"+rmSheetid+"','"+warehouseId+"','"+empId+"','"+dept+"','"+operatorId+"'," +
						"'"+createPerson+"',to_date('"+createTime+"','yyyy-mm-dd,hh24:mi:ss'),'"+changePerson+"',to_date('"+changeTime+"','yyyy-mm-dd,hh24:mi:ss'))";
//				String s1="CJ-001-"+createTime+"-";
//				String s2=checksheet_id.replaceAll(s1,"");
				String sqlsheet="insert into rm_sheetid values("+seq+",'"+id+"','"+rmSheetid+"')";
				System.out.println("sql="+sql);
				System.out.println("sqlsheet="+sqlsheet);
				try{
						Sqlhelper.executeUpdate(sql, null);
						Sqlhelper.executeUpdate(sqlsheet, null);
//						String json = "{\"result\":\"操作成功!\",\"status\":1}";
						//response.setCharacterEncoding("UTF-8");
//						response.getWriter().append(json).flush();
				}catch(Exception e){
//					String json = "{\"result\":\"操作失败!\",\"status\":0}";
					//response.setCharacterEncoding("UTF-8");
//					response.getWriter().append(json).flush();
					e.printStackTrace();
				}
			
	    try{
		 
			if(item_id1.length()>0){
			
			TlData.getTlData(request,datamap,rmSheetid,item_id1,
					"item_name1","item_type1","spec1","unit1","rm_num1","unitprice1",
					"price1","stock_id1","order_id1","issue_num1","memo1",warehouseId,createPerson,createTime,changePerson,changeTime);
			
			}
			if(item_id2.length()>0){
			TlData.getTlData(request,datamap,rmSheetid,item_id2,
					"item_name2","item_type2","spec2","unit2","rm_num2","unitprice2",
					"price2","stock_id2","order_id2","issue_num2","memo2",warehouseId,createPerson,createTime,changePerson,changeTime);
			
			}
			if(item_id3.length()>0){
			TlData.getTlData(request,datamap,rmSheetid,item_id3,
					"item_name3","item_type3","spec3","unit3","rm_num3","unitprice3",
					"price3","stock_id3","order_id3","issue_num3","memo3",warehouseId,createPerson,createTime,changePerson,changeTime);
			
			}
			if(item_id4.length()>0){
			TlData.getTlData(request,datamap,rmSheetid,item_id4,
					"item_name4","item_type4","spec4","unit4","rm_num4","unitprice4",
					"price4","stock_id4","order_id4","issue_num4","memo4",warehouseId,createPerson,createTime,changePerson,changeTime);
			
			}
			if(item_id5.length()>0){
			TlData.getTlData(request,datamap,rmSheetid,item_id5,
					"item_name5","item_type5","spec5","unit5","rm_num5","unitprice5",
					"price5","stock_id5","order_id5","issue_num5","memo5",warehouseId,createPerson,createTime,changePerson,changeTime);
			
			}
			if(item_id6.length()>0){
			TlData.getTlData(request,datamap,rmSheetid,item_id6,
					"item_name6","item_type6","spec6","unit6","rm_num6","unitprice6",
					"price6","stock_id6","order_id6","issue_num6","memo6",warehouseId,createPerson,createTime,changePerson,changeTime);
			
			}
			if(item_id7.length()>0){
			TlData.getTlData(request,datamap,rmSheetid,item_id7,
					"item_name7","item_type7","spec7","unit7","rm_num7","unitprice7",
					"price7","stock_id7","order_id7","issue_num7","memo7",warehouseId,createPerson,createTime,changePerson,changeTime);
			
			}
			if(item_id8.length()>0){
			TlData.getTlData(request,datamap,rmSheetid,item_id8,
					"item_name8","item_type8","spec8","unit8","rm_num8","unitprice8",
					"price8","stock_id8","order_id8","issue_num8","memo8",warehouseId,createPerson,createTime,changePerson,changeTime);
			
			}
			if(item_id9.length()>0){
			TlData.getTlData(request,datamap,rmSheetid,item_id9,
					"item_name9","item_type9","spec9","unit9","rm_num9","unitprice9",
					"price9","stock_id9","order_id9","issue_num9","memo9",warehouseId,createPerson,createTime,changePerson,changeTime);
			
			}
			if(item_id10.length()>0){
			TlData.getTlData(request,datamap,rmSheetid,item_id10,
					"item_name10","item_type10","spec10","unit10","rm_num10","unitprice10",
					"price10","stock_id10","order_id10","issue_num10","memo10",warehouseId,createPerson,createTime,changePerson,changeTime);
			
			}
		
			String json = "{\"result\":\"操作成功!\",\"status\":1}";
			//response.setCharacterEncoding("UTF-8");
			response.getWriter().append(json).flush();
			}catch(Exception e){
				String json = "{\"result\":\"操作失败!\",\"status\":0}";
				//response.setCharacterEncoding("UTF-8");
				response.getWriter().append(json).flush();
				e.printStackTrace();
			}
		}
	}

}
