package com.lm.hib;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.lm.hib.orm.*;


public class DataService {

	//------------------------------------teacher---------------------------------	
	//输出教师信息
	@SuppressWarnings("unchecked")
	public List<TaTeacher> listTea() throws HibernateException
	{
	Session session = HibernateSessionFactory.getSession();
	Transaction tx = session.beginTransaction(); //定义一个事务
	String sql = "select u from TaTeacher as u";
	Query query = session.createQuery(sql);
	List<TaTeacher> list = query.list();
	tx.commit(); //事务提交
	HibernateSessionFactory.closeSession();
	return list;
	}
	
	//------------------------------------train---------------------------------
	//把所有的用户信息返回给 List 中
	@SuppressWarnings("unchecked")
	public List<TaTrainPro> listTrain() throws HibernateException
	{
	Session session = HibernateSessionFactory.getSession();
	Transaction tx = session.beginTransaction(); //定义一个事务
	String sql = "select u from TaTrainPro as u";
	Query query = session.createQuery(sql);
	List<TaTrainPro> list = query.list();
	tx.commit(); //事务提交
	HibernateSessionFactory.closeSession();
	return list;
	}
	//添加培养方案
	public void insertTrain(TaTrainPro mytrain) throws HibernateException
	{
	Session session =HibernateSessionFactory.getSession();
	Transaction tx = session.beginTransaction(); //定义一个事务
	session.save(mytrain);
	tx.commit(); //事务提交
	HibernateSessionFactory.closeSession();
	}
	
	//编辑培养方案
	public void editTrain(TaTrainPro mytrain) throws HibernateException
	{
		String hql="update TaTrainPro ttp set trainProName=:name,trainProPresent=:present where trainProId=:id";	
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction(); //定义一个事务
		Query query=session.createQuery(hql);
			query.setParameter("id", mytrain.getTrainProId());
			query.setParameter("name", mytrain.getTrainProName());
			query.setParameter("present", mytrain.getTrainProPresent());
		query.executeUpdate();
		tx.commit();
		
		HibernateSessionFactory.closeSession();		
	}
	//删除培养方案
	public void delTrain(int id) throws HibernateException
	{
		String hql="delete TaTrainPro where trainProId=:id";	
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction(); //定义一个事务
		Query query=session.createQuery(hql);
		query.setParameter("id", id);
		query.executeUpdate();
		tx.commit();
		HibernateSessionFactory.closeSession();		
	}
	//-----------------------------major----------------------------------------
	//输出专业信息
	@SuppressWarnings("unchecked")
	public List<TaMajor> listMajor() throws HibernateException
	{
	Session session = HibernateSessionFactory.getSession();
	Transaction tx = session.beginTransaction(); //定义一个事务
	String sql = "select u from TaMajor as u";
	Query query = session.createQuery(sql);
	List<TaMajor> list = query.list();
	tx.commit(); //事务提交
	HibernateSessionFactory.closeSession();
	return list;
	}
	//添加专业
	public void insertMajor(TaMajor mymajor) throws HibernateException
	{
	Session session =HibernateSessionFactory.getSession();
	Transaction tx = session.beginTransaction(); //定义一个事务
	session.save(mymajor);
	tx.commit(); //事务提交
	HibernateSessionFactory.closeSession();
	}
	//编辑专业
	public void editMajor(TaMajor mymajor) throws HibernateException
	{
		String hql="update TaMajor ttp set majorNumber=:num,majorName=:name,majorPresent=:present where majorId=:id";	
		try{
			Session session = HibernateSessionFactory.getSession();
			Transaction tx = session.beginTransaction(); //定义一个事务
			Query query=session.createQuery(hql);
				query.setParameter("id", mymajor.getMajorId());
				query.setParameter("num",mymajor.getMajorNumber());
				query.setParameter("name", mymajor.getMajorName());
				query.setParameter("present", mymajor.getMajorPresent());
			query.executeUpdate();
			tx.commit();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		HibernateSessionFactory.closeSession();		
	}
	//删除培养方案
	public void delMajor(int id) throws HibernateException
	{
		String hql="delete TaMajor where majorId=:id";	
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction(); //定义一个事务
		Query query=session.createQuery(hql);
		query.setParameter("id", id);
		System.out.println(id);
		query.executeUpdate();
		tx.commit();
		HibernateSessionFactory.closeSession();		
	}
	//-----------------------------class----------------------------------------
	//输出班级信息
	@SuppressWarnings("unchecked")
	public List<TaClass> listClass() throws HibernateException
	{
	Session session = HibernateSessionFactory.getSession();
	Transaction tx = session.beginTransaction(); //定义一个事务
	String sql = "select u from TaClass as u";
	Query query = session.createQuery(sql);
	List<TaClass> list = query.list();
	tx.commit(); //事务提交
	HibernateSessionFactory.closeSession();
	return list;
	}
	//添加班级
	public void insertClass(TaClass myclass) throws HibernateException
	{
	Session session =HibernateSessionFactory.getSession();
	Transaction tx = session.beginTransaction(); //定义一个事务
	session.save(myclass);
	tx.commit(); //事务提交
	HibernateSessionFactory.closeSession();
	}
	//编辑班级
	public void editClass(TaClass myclass) throws HibernateException
	{
		String hql="update TaClass tc set classNumber=:num,className=:name,majorId=:mjid where classId=:id";	
		try{
			Session session = HibernateSessionFactory.getSession();
			Transaction tx = session.beginTransaction(); //定义一个事务
			Query query=session.createQuery(hql);
				query.setParameter("id", myclass.getClassId());
				query.setParameter("mjid",myclass.getMajorId());
				query.setParameter("num",myclass.getClassNumber());
				query.setParameter("name", myclass.getClassName());
			query.executeUpdate();
			tx.commit();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		HibernateSessionFactory.closeSession();		
	}
	//删除班级
	public void delClass(int id) throws HibernateException
	{
		String hql="delete TaClass where classId=:id";	
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction(); //定义一个事务
		Query query=session.createQuery(hql);
		query.setParameter("id", id);
		System.out.println(id);
		query.executeUpdate();
		tx.commit();
		HibernateSessionFactory.closeSession();		
	}
	
	//-----------------------------roomtype----------------------------------------
	//输出教室类型
	@SuppressWarnings("unchecked")
	public List<TaRoomType> listRoomType() throws HibernateException
	{
	Session session = HibernateSessionFactory.getSession();
	Transaction tx = session.beginTransaction(); //定义一个事务
	String sql = "select u from TaRoomType as u";
	Query query = session.createQuery(sql);
	List<TaRoomType> list = query.list();
	tx.commit(); //事务提交
	HibernateSessionFactory.closeSession();
	return list;
	}
	//添加教室类型
	public void insertRoomtype(TaRoomType mytype) throws HibernateException
	{
	Session session =HibernateSessionFactory.getSession();
	Transaction tx = session.beginTransaction(); //定义一个事务
	System.out.println("test添加类型！:"+mytype.getTypeName());
	session.save(mytype);
	tx.commit(); //事务提交
	HibernateSessionFactory.closeSession();
	}
	//删除教室类型
	public void delRoomType(int id) throws HibernateException
	{
		String hql="delete TaRoomType where typeId=:id";	
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction(); //定义一个事务
		Query query=session.createQuery(hql);
		query.setParameter("id", id);
		System.out.println(id);
		query.executeUpdate();
		tx.commit();
		HibernateSessionFactory.closeSession();		
	}
	//编辑教室类型
	public void editRoomType(TaRoomType mytype) throws HibernateException
	{
		String hql="update TaRoomType tc set typeName=:name,userfor=:userfor where typeId=:id";	
		try{
			Session session = HibernateSessionFactory.getSession();
			Transaction tx = session.beginTransaction(); //定义一个事务
			Query query=session.createQuery(hql);
				query.setParameter("id", mytype.getTypeId());
				query.setParameter("name", mytype.getTypeName());
				query.setParameter("userfor", mytype.getUserfor());
			query.executeUpdate();
			tx.commit();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		HibernateSessionFactory.closeSession();		
	}
	
	
//尾部	
}
