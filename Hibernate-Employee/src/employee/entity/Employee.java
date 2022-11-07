package employee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import employee.idgenerator.CustomIdGenerator;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator ="employee")
	@GenericGenerator(name ="employee",
					strategy = "employee.idgenerator.CustomIdGenerator",
					parameters ={
							@Parameter(name = CustomIdGenerator.INCREMENT_PARAM, value = "1"),
							@Parameter(name = CustomIdGenerator.PREFIX, value = "SSBJ_"),
							@Parameter(name = CustomIdGenerator.NUMBERFORMAT, value = "%04d"),
	})
	@Column(name="id")
	private String id;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="company")
	private String company;
	
	public Employee() {
		
	}
	
	public Employee(String firstName, String lastName, String company) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.company = company;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", company=" + company
				+ "]";
	}
	
}
