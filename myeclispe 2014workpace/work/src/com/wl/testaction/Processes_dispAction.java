/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.wl.testaction;

import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.wl.forms.Parts;
import com.wl.forms.Processes;
import com.wl.tools.Sqlhelper;

public class Processes_dispAction extends DispatchAction {

	public ActionForward show(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		Processes processesbean = (Processes) form;// TODO Auto-generated method stub
		String id = request.getParameter("id").toString();
		String sql = "select *from processes where id=?";
		String paras[]={id};
		ResultSet rs=null;
		try {
			rs = (ResultSet) Sqlhelper.executeQuery(sql, paras);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Processes processes=new Processes();
		try {
			while(rs.next()){
				processes.setProcess_id(rs.getString(1));
//				System.out.println(rs.getString(1));
				processes.setProcess_pid(rs.getString(2));
				processes.setProcess_name(rs.getString(3));
				processes.setStarttime(rs.getDate(4));
				processes.setEndtime(rs.getDate(5));
				processes.setPreparetime(rs.getDate(6));
				processes.setPlantime(rs.getDate(7));
				processes.setPeoplenm(rs.getInt(8));
				processes.setJobtype(rs.getString(9));
				processes.setPicnm(rs.getString(10));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("processesת����������");
		} finally{
			try {
				if(rs!=null){
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		for(int j=0;j<8;j++){
//			System.out.println(processes.getEndtime());
//		}
		System.out.println("����proces show dispaction���Ѿ�����");
		request.setAttribute("processes", processes);
		
		return mapping.findForward("processes");
	}
	
	
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Processes processes =(Processes) form;
		System.out.println("����add������");
		
		String process_id = request.getParameter("process_id");
		String process_name = request.getParameter("process_name");
		String starttime = request.getParameter("starttime");
		String endtime = request.getParameter("endtime");
		String preparetime = request.getParameter("preparetime");
		String plantime = request.getParameter("plantime");
		String peoplenm = request.getParameter("peoplenm");
		String jobtype = request.getParameter("jobtype");
		String picnm = request.getParameter("picnm");
		String process_pid = request.getParameter("process_pid");
		
		System.out.println(jobtype);
		System.out.println(process_name);
		
		String sql ="insert into processes values('"+process_id+"','"+process_pid+"','"+process_name+"',to_date('"+starttime+"','yyyy-mm-dd'),to_date('"+endtime+"','yyyy-mm-dd'),to_date('"+preparetime+"','yyyy-mm-dd'),to_date('"+plantime+"','yyyy-mm-dd'),"+peoplenm+",'"+jobtype+"','"+picnm+"')";
		
		System.out.println(sql);
		
		try {
			Sqlhelper.executeUpdate(sql, null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("���parts�쳣������");
			return mapping.findForward("err");
		}
		
		return mapping.findForward("addprocesses");
	}
	
	
	public ActionForward processList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		Processes processesbean = (Processes) form;// TODO Auto-generated method stub
		String pid = request.getParameter("id").toString();
		String sql = "select *from processes where pid=?";
		String paras[]={pid};
		ResultSet rs=null;
		try {
			rs = (ResultSet) Sqlhelper.executeQuery(sql, paras);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ArrayList<Processes> al = new ArrayList<Processes>();
		
		try {
			while(rs.next()){
				Processes processes=new Processes();
				processes.setProcess_id(rs.getString(1));
				processes.setProcess_pid(rs.getString(2));
				processes.setProcess_name(rs.getString(3));
				processes.setStarttime(rs.getDate(4));
				processes.setEndtime(rs.getDate(5));
				processes.setPreparetime(rs.getDate(6));
				processes.setPlantime(rs.getDate(7));
				processes.setPeoplenm(rs.getInt(8));
				processes.setJobtype(rs.getString(9));
				processes.setPicnm(rs.getString(10));
				al.add(processes);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("processesת����arraylist��������");
		} finally{
			try {
				if(rs!=null){
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		for(int j=0;j<8;j++){
//			System.out.println(processes.getEndtime());
//		}
		System.out.println("����proces show dispaction���Ѿ�����");
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("�ַ�ת���쳣������");
		}
		request.setAttribute("processesList", al);
		return mapping.findForward("processList");
	}
}