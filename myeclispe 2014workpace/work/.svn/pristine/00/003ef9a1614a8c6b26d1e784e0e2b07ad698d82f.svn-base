package com.wl.testaction.utils;

	import java.io.ByteArrayInputStream;
import java.io.FileInputStream;  
	import java.io.FileNotFoundException;  
	import java.io.FileOutputStream;  
	import java.io.IOException;  
import java.io.InputStream;
import java.io.OutputStream;  

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	  
 
	public class ExcelToOracleUtils {
	  
	    public static void main(String[] args) {  
	        // 文件所在路径  
	        String execelFile1="C://User//user//Desktop//PT1000C.xls";
	        //String execelFile = "C:/Book2003.xls" ;  
	        // 导入Excel  
            new ExcelToOracleUtils().impExcel(execelFile1) ;  
	        // 导出Excel  
//	        String expFilePath = "C:/testBook.xls" ;  
//	        new ExcelToOracleUtils().expExcel(expFilePath);  
	    }  
	      
	    /** 
	     * 导入Excel 
	     * @param execelFile 
	     */  
	    public static void impExcel(String input){  
	        try {  
	            // 构造 Workbook 对象，execelFile 是传入文件路径(获得Excel工作区)  
	            Workbook book = null;  
	            try {  
	                // Excel 2007获取方法  
                book = new XSSFWorkbook(new FileInputStream(input));  
	                book = new XSSFWorkbook(input);  
	            } catch (Exception ex) {  
	                // Excel 2003获取方法  
	                book = new HSSFWorkbook(new FileInputStream(input)); 

	            }  
	              
	            // 读取表格的第一个sheet页  
	            Sheet sheet = book.getSheetAt(0);  
	            // 定义 row、cell  
	            Row row0=sheet.getRow(0);
	            String orderId=row0.getCell(0).toString();
	            System.out.println(orderId);
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
	                if(row.getCell(0).toString().startsWith(orderId)){
	                	prefix=prefix+1;
	                	continue;
	                } else if (row.getCell(0).toString().trim().equals("序号")||row.getCell(0).toString()==""){
	                	continue;
	                } 
	                
                    String productId=orderId+"."+prefix+"/"+(int)Double.parseDouble(row.getCell(0).toString());
                    String drawingId=row.getCell(1).toString();
                    String productName=row.getCell(2).toString();
                    String productNum=row.getCell(3).toString();
                    String memo=row.getCell(8).toString();
                    System.out.println(productId);


	            }  
	        } catch (FileNotFoundException e) {  
	            e.printStackTrace();  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
	    }  
	      
	    public void expExcel(String expFilePath){  
	        OutputStream os = null ;  
	        Workbook book = null;  
	        try {  
	            // 输出流  
	            os = new FileOutputStream(expFilePath);  
	            // 创建工作区(97-2003)  
	            book = new HSSFWorkbook();  
	            // 创建第一个sheet页  
	            Sheet sheet= book.createSheet("test");  
	            // 生成第一行  
	            Row row = sheet.createRow(0);  
	            // 给第一行的第一列赋值  
	            row.createCell(0).setCellValue("column1");  
	            // 给第一行的第二列赋值  
	            row.createCell(1).setCellValue("column2");  
	            // 写文件  
	            book.write(os);  
	              
	        } catch (FileNotFoundException e) {  
	            e.printStackTrace();  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        } finally {  
	            // 关闭输出流  
	            try {  
	                os.close();  
	            } catch (IOException e) {  
	                e.printStackTrace();  
	            }  
	        }  
	          
	    }  
	}  

