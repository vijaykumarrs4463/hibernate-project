package employee.jdbc;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import employee.entity.Employee;

public class ReadEmployee {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();

	try{
		session = factory.getCurrentSession();
		session.beginTransaction();
		
//		int id=3;
//		Employee emp = session.get(Employee.class, id);
//		System.out.println(emp);
		
		List<Employee> elist = session.createQuery("from Employee e where e.company='Infosys'").getResultList();
		
		for(Employee emp:elist) {
			System.out.println(emp);
		}
		
		session.getTransaction().commit();
	}
	finally{
		factory.close();
	}
}}
