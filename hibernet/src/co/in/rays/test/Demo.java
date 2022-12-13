package co.in.rays.test;

import java.util.Iterator;
import java.util.List;

import javax.sound.midi.Soundbank;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import co.in.rays.pojo.Color;
import co.in.rays.pojo.User;

public class Demo {

	public static void main(String[] args) {
		System.out.println("heell");
		// testAdd();
		// list();
		// testRestri();
		//testProj();
		//testAggr();
		testOr();
		}

	private static void testOr() {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionFactory.openSession();
		Criteria cr = s.createCriteria(User.class);
		cr.add(Restrictions.or(Restrictions.like("id",2), Restrictions.like("Fname","ruchi")));
		List list = cr.list();
		Iterator<User> it = list.iterator();
		while (it.hasNext()) {
			User pojo = it.next();
			System.out.println(pojo.getId());
			System.out.println(pojo.getFname());
			System.out.println(pojo.getLname());
			System.out.println(pojo.getLoginId());
			System.out.println(pojo.getPassword());
		}
		s.close();
	}

	private static void testAggr() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionFactory.openSession();
		Criteria cr = s.createCriteria(Color.class);
		ProjectionList p = Projections.projectionList();
		//p.add(Projections.count("id"));
		//p.add(Projections.groupProperty("fcolour"));
	//	p.add(Projections.count("fcolour"));
		//p.add(Projections.max("id"));
		//p.add(Projections.min("id"));
		p.add(Projections.avg("id"));
		cr.setProjection(p);
		List list = cr.list();
		 
		Double r= (Double) list.get(0); 
		System.out.println(r);
		
		/*
		 * int r= (int) list.get(0); System.out.println(r);
		 */
		 
		
			/*
			 * Iterator it = list.iterator(); while (it.hasNext()) { Object[]pojo =
			 * (Object[]) it.next(); System.out.println(pojo[0]);
			 * System.out.println(pojo[1]);
			 */
		  
		s.close();
	}

	private static void testProj() {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionFactory.openSession();
		Criteria cr = s.createCriteria(User.class);
		ProjectionList p = Projections.projectionList();
		p.add(Projections.property("Fname"));
		
		cr.setProjection(p);
		cr.add(Restrictions.like("Fname", "%a%"));
		cr.add(Restrictions.eq("id", 2));
		List list = cr.list();
		
		 
	
	  Iterator it = list.iterator(); 
	  while (it.hasNext()) { 
		  User pojo = (User) it.next();
	
			
			  System.out.println(pojo.getId());
			  System.out.println(pojo.getFname());
			  System.out.println(pojo.getLname());
			  System.out.println(pojo.getLoginId());
			  System.out.println(pojo.getPassword());
			 
	  }
	s.close();
	}

	



	private static void testRestri() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionFactory.openSession();
		Criteria cr = s.createCriteria(User.class);
		cr.add(Restrictions.like("Fname", "%a%"));
		cr.add(Restrictions.eq("id", 2));
		List list = cr.list();
		Iterator<User> it = list.iterator();
		while (it.hasNext()) {
			User pojo = it.next();
			System.out.println(pojo.getId());
			System.out.println(pojo.getFname());
			System.out.println(pojo.getLname());
			System.out.println(pojo.getLoginId());
			System.out.println(pojo.getPassword());
		}
		s.close();
	}

	private static void testAdd() {
		Color pojo = new Color();
		pojo.setFcolour("white");
		pojo.setFname("rohit");
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		s.save(pojo);
		tx.commit();
		s.close();
	}

	private static void list() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionFactory.openSession();
		Criteria cr = s.createCriteria(User.class);
		List list = cr.list();
		Iterator<User> it = list.iterator();
		while (it.hasNext()) {
			User pojo = it.next();
			System.out.println(pojo.getId());
			System.out.println(pojo.getFname());
			System.out.println(pojo.getLname());
			System.out.println(pojo.getLoginId());
			System.out.println(pojo.getPassword());
		}
		s.close();
	}

}
