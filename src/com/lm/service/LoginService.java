package com.lm.service;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;

import com.lm.hib.DataService;
import com.lm.hib.orm.*;
import com.dao.DB;
import com.orm.TAdmin;
import com.orm.Tbanji;
import com.orm.Tjiaoshi;
import com.orm.Tkecheng;
import com.orm.Tstu;
import com.orm.Ttea;

public class LoginService
{
	public String login(String userName,String userPw,int userType)
	{
		System.out.println("userType"+userType);
		try
		{
			Thread.sleep(700);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String result="no";
		
		if(userType==0)////系统管理员登陆
		{
			String sql="select * from t_admin where userName=? and userPw=?";
			Object[] params={userName,userPw};
			DB mydb=new DB();
			mydb.doPstm(sql, params);
			try 
			{
				ResultSet rs=mydb.getRs();
				boolean mark=(rs==null||!rs.next()?false:true);
				if(mark==false)
				{
					 result="no";
				}
				else
				{
					 result="yes";
					 TAdmin admin=new TAdmin();
					 admin.setUserId(rs.getInt("userId"));
					 admin.setUserName(rs.getString("userName"));
					 admin.setUserPw(rs.getString("userPw"));
					 WebContext ctx = WebContextFactory.get(); 
					 HttpSession session=ctx.getSession(); 
					 session.setAttribute("userType", 0);
		             session.setAttribute("admin", admin);
				}
				rs.close();
			} 
			catch (SQLException e)
			{
				System.out.println("登录失败！");
				e.printStackTrace();
			}
			finally
			{
				mydb.closed();
			}
			
		}
		
		
		if(userType==1)
		{
		}
		if(userType==2)
		{
			
		}
		return result;
	}

    public String adminPwEdit(String userPwNew)
    {
		System.out.println("DDDD");
    	try 
		{
			Thread.sleep(700);
		} 
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebContext ctx = WebContextFactory.get(); 
		HttpSession session=ctx.getSession(); 
		TAdmin admin=(TAdmin)session.getAttribute("admin");
		
		String sql="update t_admin set userPw=? where userId=?";
		Object[] params={userPwNew,admin.getUserId()};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		
		return "yes";
    }
 
    //////////////////////////////////////读取专业信息
    public List<TaMajor> majorAll()
    {
    	try
		{
			Thread.sleep(700);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}

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
		return majorList;
    }
    
    //读取班级
    public List<Tbanji> banjiAll()
    {
    	try
		{
			Thread.sleep(700);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
    	
    	List<Tbanji> banjiList=new ArrayList<Tbanji>();
		String sql="select * from t_banji where del='no'";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tbanji banji=new Tbanji();
				banji.setId(rs.getInt("id"));
				banji.setName(rs.getString("name"));
				banjiList.add(banji);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		return banjiList;
    }

//读取学生
    public List<Tstu> stuAll()
    {
    	try
		{
			Thread.sleep(700);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	List<Tstu> stuList=new ArrayList<Tstu>();
		String sql="select * from t_stu where del='no'";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tstu stu=new Tstu();
				stu.setId(rs.getInt("id"));
				stu.setXuehao(rs.getString("xuehao"));
				stuList.add(stu);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		return stuList;
    }
//读取课程
    public List<Tkecheng> kechengAll()
    {
    	try
		{
			Thread.sleep(700);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	List<Tkecheng> kechengList=new ArrayList<Tkecheng>();
		String sql="select * from t_kecheng where del='no'";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tkecheng kecheng=new Tkecheng();
				kecheng.setId(rs.getInt("id"));
				kecheng.setName(rs.getString("name"));
				kechengList.add(kecheng);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		return kechengList;
    }
    
    //读取教师
    public List<Ttea> teaAll()
    {
    	try
		{
			Thread.sleep(700);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	List<Ttea> teaList=new ArrayList<Ttea>();
		String sql="select * from t_tea where del='no'";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Ttea tea=new Ttea();
				tea.setId(rs.getInt("id"));
				tea.setName(rs.getString("name"));
				teaList.add(tea);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		return teaList;
    }
    
   //读取教室
    public List<Tjiaoshi> jiaoshiAll()
    {
    	try
		{
			Thread.sleep(700);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	List<Tjiaoshi> jiaoshiList=new ArrayList<Tjiaoshi>();
		String sql="select * from t_jiaoshi where del='no'";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tjiaoshi jiaoshi=new Tjiaoshi();
				jiaoshi.setId(rs.getInt("id"));
				jiaoshi.setName(rs.getString("name"));
				jiaoshiList.add(jiaoshi);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		return jiaoshiList;
    }
    
    //添加选课
    public String xuankeAdd(int stu_id,int kecheng_id)
    {
    	try
		{
			Thread.sleep(700);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String result="no";
		String sql="select * from t_stu_kecheng where stu_id=? and kecheng_id=?";
		Object[] params={stu_id,kecheng_id};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			if(rs.next()==true)
			{
				result="no";
			}
			else
			{
				result="yes";
				String sql1="insert into t_stu_kecheng values(?,?)";
				Object[] params1={stu_id,kecheng_id};
				mydb.doPstm(sql1, params1);
			}
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		return result;
    }
    
   //删除选课 
    public String xuankeDel(int stu_id,int kecheng_id)
    {
    	try
		{
			Thread.sleep(700);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String result="no";
		String sql="delete from t_stu_kecheng where stu_id=? and kecheng_id=?";
		Object[] params={stu_id,kecheng_id};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			int ii=mydb.getCount();
			if(ii==1)
			{
				result="yes";
			}
			else
			{
				result="no";
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		return result;
    }
    
}
