/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.wl.testaction;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import JSOM.DB;
import JSOM.FandT;
import JSOM.JackSonTrans;

public class Task2JsonAction extends DispatchAction {

	public ActionForward showGT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		//String data= request.getParameter();
//		DB database2FandTLIst = new DB();
//		java.util.List<FandT> ftList = database2FandTLIst.getFandTList();
//		JackSonTrans jackSonTrans =new JackSonTrans();
//		try {
//			String json_String = jackSonTrans.JsonBack(ftList);
//			response.setCharacterEncoding("utf-8");
//			response.getWriter().write(json_String);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("Task2JsonAction转换异常！！！");
//		}
//
//		
//		jackSonTrans.PrintFandTList(ftList);
//		System.out.println(jackSonTrans.JsonBack(ftList));	
		

//		try {
//			response.getWriter().append(JackSonTrans.JsonBack(DB.getFandTList()));
//			System.out.println("执行到try语句了");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("Task2JsonAction 异常！！！");
//		}
		//DB.saveFandTList(JackSonTrans.ListBack(JackSonTrans.JsonBack(DB.getFandTList())));
		return mapping.findForward("wlgandt");
	}
}