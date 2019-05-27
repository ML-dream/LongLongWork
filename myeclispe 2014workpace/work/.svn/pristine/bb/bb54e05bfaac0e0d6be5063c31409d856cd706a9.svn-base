package com.wl.testaction.warehouse.productcheckin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.wl.forms.Checkout;
import com.wl.forms.PrDetail;
import com.wl.forms.ProductCheckin;
import com.wl.tools.ExportExcelUtil;
import com.wl.tools.Sqlhelper;
import com.wl.tools.StringUtil;

public class productCheckInExcel extends HttpServlet {

	
	public productCheckInExcel() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out = response.getWriter();
//		int pageNow=Integer.parseInt(request.getParameter("pageIndex"))+1;
//		int pageSize=Integer.parseInt(request.getParameter("pageSize"));
		int totalCount=0;
		String startDate=request.getParameter("startDate");
		String endDate=request.getParameter("endDate");
		String totalCountSql="";
		String checkinSql="";
		if(startDate.equals("")||endDate.equals("")){
			checkinSql="select E.staff_name whstaffName , d.staff_name as deliveryName, case b.status when 0 then '待审核' when 1 then '审核通过' when 2 then '审核不通过' end as statusName , c.user_name as createpersonName,b.*,b.checkinnum*b.unitprice as sumprice,c.*,d.*,e.*,t.*,f.*,g.* " +
					"from productcheckin b  left join sysusers C on C.staff_code=B.createperson " +
					"left join employee_info D on D.staff_code=B.deliveryid " +
					"left join employee_info E on E.staff_code=B.whstaffid " +
					"left join warehouse T on T.warehouse_id=B.warehouseid  " +
					"left join orders F on F.ORDER_ID = b.orderid " +
					"left join customer G on g.companyid = f.customer " +
					"where status>0  order by checkindate desc,checksheetid desc";
		}else{
			checkinSql="select E.staff_name whstaffName , d.staff_name as deliveryName,case b.status when 0 then '待审核' when 1 then '审核通过' when 2 then '审核不通过' end as statusName,  c.user_name as createpersonName,b.*,b.checkinnum*b.unitprice as sumprice,c.*,d.*,e.*,t.*,f.*,g.* " +
					"from productcheckin b  left join sysusers C on C.staff_code=B.createperson " +
					"left join employee_info D on D.staff_code=B.deliveryid " +
					"left join employee_info E on E.staff_code=B.whstaffid " +
					"left join warehouse T on T.warehouse_id=B.warehouseid  " +
					"left join orders F on F.ORDER_ID = b.orderid " +
					"left join customer G on g.companyid = f.customer " +
					"where status>0  and " +
					"checkindate between to_date('"+startDate+"','yyyy-mm-dd,hh24:mi:ss') and to_date('"+endDate+"','yyyy-mm-dd,hh24:mi:ss')"+
					" order by checkindate desc,checksheetid desc" ;
		}
		
		/*try{
			totalCount=Sqlhelper.exeQueryCountNum(totalCountSql, null);
		}catch(Exception e){
			e.printStackTrace();
		}*/
		
		
		List<ProductCheckin> resultList=new ArrayList<ProductCheckin>();
		try{
			resultList=Sqlhelper.exeQueryList(checkinSql, null, ProductCheckin.class);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		/*Logger logger = Logger.getLogger(productCheckInExcel.class);
        
        //使用默认的配置信息，不需要写log4j.properties
        BasicConfigurator.configure();
        //设置日志输出级别为info，这将覆盖配置文件中设置的级别
        logger.setLevel(Level.INFO);
        //下面的消息将被输出
        logger.info(resultList);*/
//        String json=PluSoft.Utils.JSON.Encode(resultList);
//        System.out.println(json);
		
		
		LinkedHashMap<String, String> liebiaoxiang = new LinkedHashMap<String, String>();
		liebiaoxiang.put("companyName", "客户名称");
		liebiaoxiang.put("checksheetId", "入库单号");
		liebiaoxiang.put("checkindate", "入库日期");
		liebiaoxiang.put("productId", "产品编号");
		liebiaoxiang.put("productName", "产品名称");
		
//		liebiaoxiang.put("deliveryName", "送货人");
		liebiaoxiang.put("drawingId", "图号");
		//liebiaoxiang.put("issueNum", "版本号");
		liebiaoxiang.put("spec", "规格");
		liebiaoxiang.put("checkinNum", "数量");
		liebiaoxiang.put("unitPrice", "单价");
		liebiaoxiang.put("sumPrice", "总价");
		liebiaoxiang.put("unit", "单位");
		liebiaoxiang.put("warehouseName", "库房");
		liebiaoxiang.put("orderId", "订单号");
		liebiaoxiang.put("statusName", "审核状态");
		liebiaoxiang.put("issueNum", "版本号");
		liebiaoxiang.put("productType", "类型");
		liebiaoxiang.put("createpersonName", "质检员");
		liebiaoxiang.put("lot", "批次");
		liebiaoxiang.put("qualityId", "质编号");
		liebiaoxiang.put("deliveryName", "送货人");
		liebiaoxiang.put("whstaffName", "仓管员");
		liebiaoxiang.put("warehouseName", "库房");
		liebiaoxiang.put("memo", "附录");
//		liebiaoxiang.put("unit", "单位");
//		liebiaoxiang.put("unit", "单位");
//		liebiaoxiang.put("unit", "单位");
//		liebiaoxiang.put("unit", "单位");
		
//		liebiaoxiang.put("tax", "销项税额");
//		liebiaoxiang.put("totalPrice", "税价合计");
		
		List<Integer> columnWidth = new ArrayList<Integer>();
		columnWidth.add(8000);
		columnWidth.add(6500);
		columnWidth.add(6500);
		columnWidth.add(5500);
		columnWidth.add(5500);
		columnWidth.add(6500);
		columnWidth.add(5500);
		columnWidth.add(5500);
		columnWidth.add(3500);
		columnWidth.add(3500);
		columnWidth.add(3500);
		columnWidth.add(3500);
		columnWidth.add(3500);
//		columnWidth.add(3500);
//		columnWidth.add(3500);
		
		
		
		ExportExcelUtil.exportExcel(request, response, liebiaoxiang, columnWidth, resultList);
		
	}

}
