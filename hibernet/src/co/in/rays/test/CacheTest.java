package co.in.rays.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import co.in.rays.pojo.User;

public class CacheTest {
	public static void main(String[] args) {
		firstCache();
		//secondCache();
		
	}


	private static void secondCache() {
	
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionFactory.openSession();

		User pojo = (User) s.get(User.class, 2);
		System.out.println(pojo.getId());
		System.out.println(pojo.getFname());
		System.out.println(pojo.getLname());
		System.out.println(pojo.getLoginId());
		System.out.println(pojo.getPassword());
		 
     //  s.evict(pojo);
       //s.clear();
		s.close();
		 sessionFactory.close();
		 SessionFactory sessionFactory1 = new Configuration().configure().buildSessionFactory();
		Session s1 = sessionFactory1.openSession();
		User pojo1 = (User) s1.get(User.class, 2);
		System.out.println(pojo1.getId());
		System.out.println(pojo1.getFname());
		System.out.println(pojo1.getLname());
		System.out.println(pojo1.getLoginId());
		System.out.println(pojo1.getPassword());
		 
		s1.close();

	}

	

	private static void firstCache() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionFactory.openSession();

		User pojo = (User) s.get(User.class, 2);
		System.out.println(pojo.getId());
		System.out.println(pojo.getFname());
		System.out.println(pojo.getLname());
		System.out.println(pojo.getLoginId());
		System.out.println(pojo.getPassword());
		 
        // s.evict(pojo);
      //   s.clear();
		//s.close();
	//	Session s = sessionFactory.openSession();
		User pojo1 = (User) s.get(User.class, 2);
		System.out.println(pojo1.getId());
		System.out.println(pojo1.getFname());
		System.out.println(pojo1.getLname());
		System.out.println(pojo1.getLoginId());
		System.out.println(pojo1.getPassword());
		    s.clear();
		    System.out.println(pojo1.getId());
		s.close();

	}

}
