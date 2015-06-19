package com.action;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lm.hib.DataService;
import com.lm.hib.orm.TaRoomType;

public class RoomType_servlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5171678959958209036L;
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
        String actiontype=req.getParameter("type");
		if(actiontype.endsWith("roomtypeList"))
		{
			System.out.println("here1");
			roomtypeList(req, res);
		}
		if(actiontype.endsWith("roomtypeAdd"))
		{
			roomtypeAdd(req, res);
		}
		if(actiontype.endsWith("roomtypeDel"))
		{
			roomtypeDel(req, res);
		}
		if(actiontype.endsWith("roomtypeEdit"))
		{
			roomtypeEdit(req, res);
		}	
	}
	public void roomtypeList(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List<TaRoomType> roomtypeList=new ArrayList<TaRoomType>();
		try
		{
			DataService ds=new DataService();
			Iterator<TaRoomType> iterator=ds.listRoomType().iterator();
			TaRoomType roomtype=new TaRoomType();
			while(iterator.hasNext())
			{
				roomtype=(TaRoomType)(iterator.next());			
				roomtypeList.add(roomtype);
		    }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		req.setAttribute("roomtypeList", roomtypeList);
		req.getRequestDispatcher("admin/classroom/roomtypeList.jsp").forward(req, res);
		
		
	}
	public void roomtypeAdd(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String name=req.getParameter("name");
		String userfor=req.getParameter("userfor");
		try{
			TaRoomType roomtype=new TaRoomType();
			roomtype.setTypeName(name);
			roomtype.setUserfor(userfor);
			DataService th=new DataService();
			th.insertRoomtype(roomtype);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		req.setAttribute("message", "添加操作成功");
		req.setAttribute("path", "roomtype?type=roomtypeList");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
		
	}
	public void roomtypeDel(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		int id=Integer.parseInt(req.getParameter("id"));
		try{
			DataService ds=new DataService();
			ds.delRoomType(id);
			System.out.println("roomtypedel:"+id);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		req.setAttribute("message", "删除操作成功");
		req.setAttribute("path", "roomtype?type=roomtypeList");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
		
	}
	public void roomtypeEdit(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String userfor=req.getParameter("userfor");

		TaRoomType roomtype=new TaRoomType();
		roomtype.setTypeId(id);
		roomtype.setTypeName(name);
		roomtype.setUserfor(userfor);
		try{
			DataService ds=new DataService();
			ds.editRoomType(roomtype);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		req.setAttribute("message", "修改操作成功");
		req.setAttribute("path", "roomtype?type=roomtypeList");
		
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
	
//尾部
}
