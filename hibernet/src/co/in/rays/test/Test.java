package co.in.rays.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import co.in.rays.pojo.User;

public class Test {
	public static void main(String[] args) throws Exception {
		// testAdd();
		// testUpdate();
		// testDelete();
		// testGet();
		//testList();
		//testJoins();
		//testorderby();
		testHQL();
		
		
	}

	private static void testHQL() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionFactory.openSession();
		//Query q=s.createQuery("select count(*) from User");
		Query q=s.createQuery("select u.fcolour ,count(*) from Color u group by u.fcolour");
		List row=q.list();
		Iterator it = row.iterator(); 
		while(it.hasNext()) {
			Object[]pojo =(Object[]) it.next();
			System.out.print(pojo[0]+"==="+pojo[1]);
			System.out.println(" ");
		}
		//Object row1= row.get(0);
		
	//	System.out.println(row1);
		s.close();
	}

	private static void testorderby() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionFactory.openSession();
		Query q=s.createQuery("from User Where Lname like '%j%' order by Fname");
		List list =q.list();
		Iterator it = list.iterator();
		while(it.hasNext()){
			User pojo= (User) it.next();
			System.out.println(pojo.getId());
			System.out.println(pojo.getFname());
			System.out.println(pojo.getLname());
			System.out.println(pojo.getLoginId());
			System.out.println(pojo.getPassword());
			
		}
		s.close();
	}

	private static void testJoins() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionFactory.openSession();
		Query q= s.createQuery("select u.id,u.Fname,u.Lname, c.fcolour from User u, Color c where u.Fname=c.Fname");
		List list =q.list();
		Iterator it = list.iterator();
		while(it.hasNext()) {
			Object[] pojo= (Object[]) it.next();
			System.out.println(pojo[0]);
			System.out.println(pojo[1]);
			System.out.println(pojo[2]);
			System.out.println(pojo[3]);
		}
		s.close();
	}
	

	private static void testList() {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionFactory.openSession();
	//	Query q = s.createQuery("from User");
	//	Query q=s.createQuery("from User where Fname like 'r%'");
	//	Query q=s.createQuery(" select u.id from User u");
		Query q=s.createQuery(" select u.id,u.Fname from User u");
		List list =q.list();
		Iterator it = list.iterator();
		while(it.hasNext()) {
			Object[] pojo= (Object[]) it.next();
			System.out.println(pojo[0]);
			System.out.println(pojo[1]);
		}
		/*
		 * List list =q.list(); Iterator it = list.iterator(); while(it.hasNext()) {
		 * Integer pojo=(Integer) it.next(); System.out.println(pojo);
		 */
		/*List<User> list = q.list();
		Iterator<User> it = list.iterator();
		while (it.hasNext()) {
			User pojo = it.next();
			System.out.println(pojo.getId());
			System.out.println(pojo.getFname());
			System.out.println(pojo.getLname());
			System.out.println(pojo.getLoginId());
			System.out.println(pojo.getPassword());
			}
*/
		
		s.close();
	}

	private static void testGet() {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionFactory.openSession();

		User pojo = (User) s.get(User.class, 2);
		System.out.println(pojo.getId());
		System.out.println(pojo.getFname());
		System.out.println(pojo.getLname());
		System.out.println(pojo.getLoginId());
		System.out.println(pojo.getPassword());
		s.close();

	}

	private static void testDelete() {
		User pojo = new User();
		pojo.setId(5);
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		s.delete(pojo);
		tx.commit();
		s.close();

	}

	private static void testUpdate() {
		User pojo = new User();
		pojo.setId(1);
		pojo.setFname("ruchi");
		pojo.setLname("jain");
		pojo.setLoginId("ruchi4081.jain");
		pojo.setPassword("4081");
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		s.update(pojo);
		tx.commit();
		s.close();

	}

	public static void testAdd() throws Exception {
		User pojo = new User();
		pojo.setFname("ram");
		pojo.setLname("jain");
		pojo.setLoginId("ram.jain");
		pojo.setPassword("1234");
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		s.save(pojo);
		tx.commit();
		s.close();
	}

}
