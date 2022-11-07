package employee.jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import employee.entity.Employee;

public class UpdateEmployee {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session=factory.getCurrentSession();
			session.beginTransaction();
			
			Employee emp = session.get(Employee.class, 1);
			emp.setCompany("Google");
			
			session.getTransaction().commit();
		}
		finally {
		factory.close();
	}}

}
