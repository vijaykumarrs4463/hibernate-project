package employee.jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import employee.entity.Employee;

public class CreateEmployee {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session= factory.getCurrentSession();
			Employee emp1 = new Employee("Sachin","Rathod","TCS");
			Employee emp2 = new Employee("Lingaraj","Gudlanur","Infosys");
			Employee emp3 = new Employee("Ramesh","Patil","Accenture");
			
			session.beginTransaction();
			session.save(emp1);
			session.save(emp2);
			session.save(emp3);
			
			session.getTransaction().commit();
		}
		
		finally {
			factory.close();
		}

	}

}
