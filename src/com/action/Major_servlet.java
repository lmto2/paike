package com.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lm.hib.DataService;
import com.lm.hib.orm.TaMajor;



public class Major_servlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}
	
	//入口
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
        String actiontype=req.getParameter("type");
		
		if(actiontype.endsWith("majorList"))
		{
			majorList(req, res);
		}
		if(actiontype.endsWith("majorAdd"))
		{
			majorAdd(req, res);
		}
		if(actiontype.endsWith("majorDel"))
		{
			majorDel(req, res);
		}
		if(actiontype.endsWith("majorEdit"))
		{
			majorEdit(req, res);
		}
	}
	//专业显示
	public void majorList(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List<TaMajor> majorList=new ArrayList<TaMajor>();
		try
		{
			DataService ds=new DataService();
			Iterator<TaMajor> iterator=ds.listMajor().iterator();
			TaMajor major=new TaMajor();
			while(iterator.hasNext())
			{
				major=(TaMajor)(iterator.next());
				majorList.add(major);
		    }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		req.setAttribute("majorList", majorList);
		req.getRequestDispatcher("admin/major/majorList.jsp").forward(req, res);
			
		
	}
	//专业添加
	public void majorAdd(HttpServletRequest req,HttpServletResponse res)
	{
		String num=req.getParameter("mid");
		String name=req.getParameter("name");		
		String present=req.getParameter("jieshao");
		//String del="no";
		try{
			TaMajor major=new TaMajor();
			major.setMajorNumber(num);
			major.setMajorName(name);
			major.setMajorPresent(present);
			System.out.println("testmajoradd"+num);
			DataService th=new DataService();
			th.insertMajor(major);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		req.setAttribute("message", "添加操作成功");
		req.setAttribute("path", "major?type=majorList");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
		
	}
	//专业编辑
	public void majorEdit(HttpServletRequest req,HttpServletResponse res)
	{
		int id=Integer.parseInt(req.getParameter("id"));
		String num=req.getParameter("num");
		String name=req.getParameter("name");
		String present=req.getParameter("jieshao");

		TaMajor major=new TaMajor();
		major.setMajorId(id);
		major.setMajorName(name);
		major.setMajorNumber(num);
		major.setMajorPresent(present);
		try{
			DataService ds=new DataService();
			ds.editMajor(major);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		req.setAttribute("message", "修改操作成功");
		req.setAttribute("path", "major?type=majorList");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
		
	}
	//专业删除
	public void majorDel(HttpServletRequest req,HttpServletResponse res)
	{
		int id=Integer.parseInt(req.getParameter("id"));
		try{
			DataService ds=new DataService();
			ds.delMajor(id);
			System.out.println("testmajor1"+id);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		req.setAttribute("message", "删除操作成功");
		req.setAttribute("path", "major?type=majorList");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
		
		
	}
	//编码过滤器
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
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
