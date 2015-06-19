package com.lm.service;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.lm.hib.HibernateSessionFactory;
import com.lm.hib.orm.TaMajor;

public class OrmService
{
	@SuppressWarnings("unchecked")
	public static String getMajorName(int id)
	{
		String majorname="";
		
		String hql="from TaMajor where majorId=:id";
		System.out.println("here2:"+id);
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction(); //定义一个事务
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		List<TaMajor> list = query.list();
		tx.commit(); //事务提交
		Iterator<TaMajor> iterator=list.iterator();
		System.out.println(iterator.hasNext());
		majorname=((TaMajor) iterator.next()).getMajorName();
		HibernateSessionFactory.closeSession();
		return majorname;
	}
	
	
}
