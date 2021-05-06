package Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public interface implDao {
	//連線方法
	static Session getDB()
	{
		Configuration con=new Configuration().configure();
		SessionFactory sf=con.buildSessionFactory();
		Session se=sf.openSession();
		return se;			
	}	
	
	//新增物件
	void add(Object o);//inject注入;injection
		
	//查詢物件
	Object query(int id);
	List<Object> queryAll();
	
	//修改物件
	void update(Object o);	
	
	//刪除物件	
	void delete(Object o);
}