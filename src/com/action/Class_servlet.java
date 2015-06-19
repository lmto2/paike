package com.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.lm.service.OrmService;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lm.hib.DataService;
import com.lm.hib.orm.TaClass;


public class Class_servlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
        String actiontype=req.getParameter("type");
		if(actiontype.endsWith("classList"))
		{
			System.out.println("here1");
			classList(req, res);
		}
		if(actiontype.endsWith("classAdd"))
		{
			classAdd(req, res);
		}
		if(actiontype.endsWith("classDel"))
		{
			classDel(req, res);
		}
		if(actiontype.endsWith("classEdit"))
		{
			classEdit(req, res);
		}	
	}
	//输出班级信息
	public void classList(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List<TaClass> classList=new ArrayList<TaClass>();
		try
		{
			DataService ds=new DataService();
			Iterator<TaClass> iterator=ds.listClass().iterator();
			TaClass tclass=new TaClass();
			while(iterator.hasNext())
			{
				tclass=(TaClass)(iterator.next());
				tclass.setMajorName(OrmService.getMajorName(tclass.getMajorId()));			
				classList.add(tclass);
		    }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		req.setAttribute("classList", classList);
		req.getRequestDispatcher("admin/class/classList.jsp").forward(req, res);
		
		
	}
	//添加班级
	public void classAdd(HttpServletRequest req,HttpServletResponse res)
	{
		String name=req.getParameter("name");
		int major=Integer.parseInt(req.getParameter("major_id"));
		String num=req.getParameter("num");
		//String del="no";
		try{
			TaClass tclass=new TaClass();
			tclass.setClassNumber(num);
			tclass.setClassName(name);
			tclass.setMajorId(major);
			
			DataService th=new DataService();
			th.insertClass(tclass);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		req.setAttribute("message", "添加操作成功");
		req.setAttribute("path", "class?type=classList");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
		
	}
	//删除班级
	public void classDel(HttpServletRequest req,HttpServletResponse res)
	{
		int id=Integer.parseInt(req.getParameter("id"));
		
		DataService ds=new DataService();
		ds.delClass(id);
		req.setAttribute("message", "删除操作成功");
		req.setAttribute("path", "class?type=classList");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}
	//编辑班级
	public void classEdit(HttpServletRequest req,HttpServletResponse res)
	{
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		int major=Integer.parseInt(req.getParameter("major_id"));
		String num=req.getParameter("num");

		TaClass myclass=new TaClass();
		myclass.setClassId(id);
		myclass.setClassName(name);
		myclass.setMajorId(major);
		myclass.setClassNumber(num);
		System.out.println("shuju:"+id+"-"+name+"-"+major+"-"+num);
		DataService ds=new DataService();
		ds.editClass(myclass);
		req.setAttribute("message", "修改banji操作成功");
		req.setAttribute("path", "class?type=classList");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	public void dispatch(String targetURI,HttpServletRequest request,HttpServletResponse response) 
	{
		RequestDispatcher dispatch = getServletContext().getRequestDispatcher(targetURI);
		try 
		{
		    dispatch.forward(request, response);
		    return;
		} 
		catch (ServletException e) 
		{
                    e.printStackTrace();
		} 
		catch (IOException e) 
		{
			
		    e.printStackTrace();
		}
	}
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

}
