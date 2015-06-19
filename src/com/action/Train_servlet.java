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
import com.lm.hib.orm.TaTrainPro;


public class Train_servlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
        String actiontype=req.getParameter("type");
		if(actiontype.endsWith("trainList"))
		{
			trainList(req, res);
		}
		if(actiontype.endsWith("trainAdd"))
		{
			trainAdd(req, res);
		}
		if(actiontype.endsWith("trainDel"))
		{
			trainDel(req, res);
		}
		if(actiontype.endsWith("trainEdit"))
		{
			trainEdit(req, res);
		}	
	}
	//列表
	public void trainList(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List<TaTrainPro> trainList=new ArrayList<TaTrainPro>();
		try
		{
			DataService ds=new DataService();
			Iterator<TaTrainPro> iterator=ds.listTrain().iterator();
			TaTrainPro train=new TaTrainPro();
			while(iterator.hasNext())
			{
				train=(TaTrainPro)(iterator.next());
				trainList.add(train);
		    }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		req.setAttribute("trainList", trainList);
		req.getRequestDispatcher("admin/train/trainList.jsp").forward(req, res);
		
	}
	//添加培养方案
	public void trainAdd(HttpServletRequest req,HttpServletResponse res)
	{
		String name=req.getParameter("name");
		int major=Integer.parseInt(req.getParameter("major_id"));
		String term=req.getParameter("term");
		String present=req.getParameter("jieshao");
		//String del="no";
		try{
			TaTrainPro train=new TaTrainPro();
			train.setTrainProName(name);
			train.setStudyTerm(term);
			train.setMajorId(major);		
			train.setTrainProPresent(present);
			
			DataService th=new DataService();
			th.insertTrain(train);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		req.setAttribute("message", "添加操作成功");
		req.setAttribute("path", "train?type=trainList");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
		
	}
	//删除培养方案
	public void trainDel(HttpServletRequest req,HttpServletResponse res)
	{
		int id=Integer.parseInt(req.getParameter("id"));
		
		DataService ds=new DataService();
		ds.delTrain(id);
		req.setAttribute("message", "删除操作成功");
		req.setAttribute("path", "train?type=trainList");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
		
	}
	public void trainEdit(HttpServletRequest req,HttpServletResponse res)
	{
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String present=req.getParameter("jieshao");
		System.out.println("test333");
		TaTrainPro train=new TaTrainPro();
		train.setTrainProId(id);
		train.setTrainProName(name);		
		train.setTrainProPresent(present);
		
		DataService ds=new DataService();
		ds.editTrain(train);
		req.setAttribute("message", "修改操作成功");
		req.setAttribute("path", "train?type=trainList");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
		
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
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

}
