package Dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Factory.SpFactory;
import Factory.sp1;
import Model.member;
import Model.porder;

public class memberDao implements implDao {

	public static void main(String[] args) {

		/*ApplicationContext a = new ClassPathXmlApplicationContext("sp1.xml");
		SpFactory sp = a.getBean("SF", SpFactory.class);

		sp.getPd().add(new porder("a", 1, 1, 1, new Date()));*/
		
		ApplicationContext a1 = new AnnotationConfigApplicationContext(sp1.class);
		SpFactory sp = a1.getBean("sf",SpFactory.class);
		
		sp.getPd().add(new porder("kk", 5, 1, 1, new Date()));
		
	}

	// 判斷帳號與密碼-->回傳boolean
	public static Boolean query(String username, String password) {
		Session se = implDao.getDB();
		String HQL = "from  member as m where m.username=?1 and m.password=?2";
		Query q = se.createQuery(HQL);
		q.setParameter(1, username);
		q.setParameter(2, password);

		List<member> l = q.list();

		boolean x = false;
		if (l.size() != 0)
			x = true;

		return x;

	}

	// 判斷帳號密碼-->回傳物件
	public static List<member> query2(String username, String password) {
		Session se = implDao.getDB();
		String HQL = "from  member as m where m.username=?1 and m.password=?2";
		Query q = se.createQuery(HQL);
		q.setParameter(1, username);
		q.setParameter(2, password);

		List<member> l = q.list();
		return l;
	}

	// 判斷帳號是否重複
	public static Boolean queryUsername(String username) {
		Session se = implDao.getDB();
		String HQL = "from  member as m where m.username=?1 ";
		Query q = se.createQuery(HQL);
		q.setParameter(1, username);

		List<member> l = q.list();

		boolean x = false;
		if (l.size() != 0)
			x = true;

		return x;
	}

	@Override
	public void add(Object o) {
		Session se = implDao.getDB();
		Transaction t = se.beginTransaction();
		se.save(o);
		t.commit();
		se.close();

	}

	@Override
	public Object query(int id) {
		Session se = implDao.getDB();
		member m = se.get(member.class, id);
		return m;
	}

	@Override
	public List<Object> queryAll() {
		Session se = implDao.getDB();
		String HQL = "from member";
		Query q = se.createQuery(HQL);
		List<Object> l = q.list();
		return l;
	}

	@Override
	public void update(Object o) {
		Session se = implDao.getDB();
		Transaction t = se.beginTransaction();
		se.update(o);
		t.commit();
		se.close();

	}

	@Override
	public void delete(Object o) {
		Session se = implDao.getDB();
		Transaction t = se.beginTransaction();
		se.delete(o);
		t.commit();
		se.close();

	}

}