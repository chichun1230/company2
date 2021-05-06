package Dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Factory.SpFactory;
import Model.member;
import Model.porder;

public class porderDao implements implDao{

	public static void main(String[] args) {
		/*porder p=(porder)new porderDao().query(5);
		new porderDao().delete(p);*/
		
		/*porder p=new porder("j",0,1,1,new Date());
		new porderDao().add(p);*/
		
		/*List<Object> l=new porderDao().queryAll();
		System.out.println(l);*/
		
//		ApplicationContext ac=new ClassPathXmlApplicationContext("sp1.xml");
//		SpFactory sp=ac.getBean("SF",SpFactory.class);
//		
		//新增
//		sp.getPd().add(new porder("a",1,1,1,new Date()));
		
		List<Object> l=new porderDao().querySum(1000, 2000);
		porder[] p=l.toArray(new porder[l.size()]);
		for(porder po:p) {
			System.out.println(po);
		}
		
		
		//測試update
//		porder p=(porder) new porderDao().query(3);
//		p.setProduct1(2);
//		p.setProduct2(5);
//		p.getSum();
//		
//		new porderDao().update(p);
	}

	@Override
	public void add(Object o) {
		Session se=implDao.getDB();
		Transaction t=se.beginTransaction();
		se.save(o);
		t.commit();
		se.close();
		
	}

	@Override
	public Object query(int id) {
		Session se = implDao.getDB();
		porder p = se.get(porder.class, id);
		return p;
	}

	@Override
	public List<Object> queryAll() {
		Session se=implDao.getDB();
		String HQL="from porder";
		Query q=se.createQuery(HQL);
		List<Object> l=q.list();
		return l;
	}
	
	public List<Object> querySum(int start,int end) {
		Session se=implDao.getDB();
		String HQL="from porder as p where p.sum>?1 and p.sum<?2";
		
		Query q=se.createQuery(HQL);
		q.setParameter(1, start);
		q.setParameter(2, end);
		List<Object> l=q.list();
		return l;
	}
	

	@Override
	public void update(Object o) {
		Session se=implDao.getDB();
		Transaction t=se.beginTransaction();
		se.update(o);
		t.commit();
		se.close();
		
	}

	@Override
	public void delete(Object o) {
		Session se=implDao.getDB();
		Transaction t=se.beginTransaction();
		se.delete(o);
		t.commit();
		se.close();
		
	}
	
	

}