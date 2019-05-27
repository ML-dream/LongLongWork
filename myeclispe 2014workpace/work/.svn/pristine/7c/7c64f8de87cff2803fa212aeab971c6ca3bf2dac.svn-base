package com.wl.testaction.orderManage;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cfmes.util.sql_data;

import com.wl.forms.Order;
import com.wl.forms.User;
import com.wl.testaction.utils.ExcelToOracleUtils;
import com.wl.testaction.utils.UploadUtils;
import com.wl.tools.ChineseCode;
import com.wl.tools.Sqlhelper;
import com.wl.tools.StringUtil;

public class ImpExcelToOracleServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    doPost(request,response);
	}

	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		Map<String, String> requestValueMap = new HashMap<String, String>();	
//		HttpSession session = request.getSession();
        String companyName = "AnShun";
//	    String changePerson = ((User)session.getAttribute("user")).getStaffCode();
	    
	    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	    String createTime = df.format(new Date());
	    String changeTime = df.format(new Date());
	    Date d = new Date();    
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");  
        String time = sdf.format(d);  
        
    	try {
			requestValueMap = UploadUtils.UploadLoadFile(request, response, companyName, requestValueMap);	//保存文件+得到request属性值
		} catch (FileUploadException e1) {
			String json = "{\"result\":\"文件太大，请检查文件上大小！！\"}";
			response.getWriter().append(json).flush();
			e1.printStackTrace();
		}
	   String orderId =ChineseCode.toUTF8(requestValueMap.get("orderId").trim());
	   String execlFile=ChineseCode.toUTF8(requestValueMap.get("execlFile").trim());
//	   ExcelToOracleUtils.impExcel(execlFile);

	   String Ordersql="select order_id orderId,order_date orderdate,to_char(Endtime,'yyyy-mm-dd HH24:mi:ss') endtime,createperson from orders t where t.order_id=?";
	   String[] params={orderId};
	   Order order=new Order();
	   try{
		  order=Sqlhelper.exeQueryBean(Ordersql, params, Order.class); 
	   }catch(Exception e){
		   e.printStackTrace();
	   }
	   
	   String  addOrderSql ="insert into order_detail (ORDER_ID,PRODUCT_ID,ISSUE_NUM,LOT,PURDUCT_NUM,B_time,E_time," +
	   		"  product_status,Fproduct_id,PRODUCT_NAME,Spec,DRAWINGID,createPerson," +
	   		"changeperson,createtime,changetime,cengci,productType,MEMO，barcode) "+
	        " values (?,?,?,?,?,to_date(?,'yyyy-mm-dd HH24:mi:ss')," +
	        "to_date(?,'yyyy-mm-dd HH24:mi:ss'),?,?,?,?,?,?,?,to_date(?,'yyyy-mm-dd HH24:mi:ss'),to_date(?,'yyyy-mm-dd HH24:mi:ss'),?,?,?,?) ";
      
	  
       
	   
       try {  
           // 构造 Workbook 对象，execelFile 是传入文件路径(获得Excel工作区)  
           Workbook book = null;  
           try {  
               // Excel 2007获取方法  
           book = new XSSFWorkbook(new FileInputStream(execlFile));   
           } catch (Exception ex) {  
               book = new HSSFWorkbook(new FileInputStream(execlFile)); 

           }  
             
           // 读取表格的第一个sheet页  
           Sheet sheet = book.getSheetAt(0);  
           // 定义 row、cell  
           Row row0=sheet.getRow(0);
           String orderIdPrefix=row0.getCell(0).toString();
           System.out.println(orderId);
           System.out.println(orderIdPrefix);
           Row row;  
           String cell;  
           int prefix=0;
           // 总共有多少行,从0开始  
           int totalRows = sheet.getLastRowNum() ;  
           // 循环输出表格中的内容,首先循环取出行,再根据行循环取出列  
           for (int i =1; i <= totalRows; i++) {  
               row = sheet.getRow(i);  
               // 处理空行  
               if(row == null){
                   continue ;
               }        
               // 总共有多少列,从0开始  
//               if(row.getCell(0).toString().trim().startsWith(orderIdPrefix)){
               if(row.getCell(0).toString().startsWith(orderIdPrefix)){
            	   System.out.println(row.getCell(0).toString());
               	prefix=prefix+1;
               	continue;
               } 
               if (row.getCell(0).toString().trim().equals("序号")||row.getCell(0).toString()==""){
               	continue;
               } 
              int first=(int)Double.parseDouble(row.getCell(0).toString());
              String first0=first+"";
              if(first>=0&&first<=9){
            	   first0="00"+first0; 
              }else if(first>=10&first<=99){
            	 first0="0"+first0;
              }     
               String productId=orderIdPrefix+"."+prefix+"/"+first0;
               String drawingId=row.getCell(1).toString();
               if (drawingId==""||drawingId.equals("")){
            	   drawingId=productId;
               }
               String productName=row.getCell(2).toString();
               String productNum=row.getCell(3).toString();
               if(productNum.contains("*")){
            	   String[] num=productNum.split("\\*");
            	   int result=Integer.parseInt(num[0])*Integer.parseInt(num[1]);
            	   productNum=result+"";
               }

               String memo=row.getCell(8).toString();
               String[] Params={orderId,productId,"1","1",productNum,order.getOrderDate(),order.getEndTime(),"0",
            		 orderId,productName,"1",drawingId,order.getCreatePerson(),order.getCreatePerson(),createTime,changeTime,"2","L",memo,productId};
              try{
            	Sqlhelper.executeUpdate(addOrderSql, Params);
              }catch(Exception e){
            	  e.printStackTrace();
              }

           }  
       } catch (FileNotFoundException e) {  
           e.printStackTrace();  
       } catch (IOException e) {  
           e.printStackTrace();  
       }  

     		
		String json = "{\"result\":\"操作成功!\"}";
		response.getWriter().append(json).flush();

	}


}
