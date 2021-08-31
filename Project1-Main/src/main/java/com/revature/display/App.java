package com.revature.display;

import java.sql.Timestamp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.revature.pojo.Admin;
import com.revature.pojo.Employee;
import com.revature.pojo.Reimbursement;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Proejct started...");

		// create a configuration object
		Configuration cfg = new Configuration();

		// read the configuration and load in the object
		cfg.configure("hibernate.cfg.xml");

		// create factory
		SessionFactory factory = cfg.buildSessionFactory();
		// open the session
		Session session = factory.openSession();
		// begin the transaction
		Transaction t = session.beginTransaction();

		// create employee
		Employee employee = new Employee();
		employee.setUsername("john");
		employee.setPassword("123");
		employee.setFirstName("John");
		employee.setLastName("Smith");
		employee.setEmail("j@gmail.com");

		// create admin
		Admin admin = new Admin();
		admin.setUsername("admin");
		admin.setPassword("admin");
		admin.setFirstName("admin");
		admin.setLastName("admin");
		admin.setEmail("admin@gmail.com");

		// create reimbursement
		Reimbursement reimb = new Reimbursement();
		reimb.setReimbAmount(100);
		reimb.setReimbSubmitted(new Timestamp(0));
		reimb.setReimbResolved(null);
		reimb.setReimbAuthor("pahn");
		reimb.setReimbDesc("testing amount");
		reimb.setReimbStatus("Pending");
		reimb.setReimbType("Loding");

		// save the employee
		session.save(employee);
		session.save(reimb);
		session.save(admin);

		// Fetch data
		Reimbursement reimb1 = session.get(Reimbursement.class, 1);
		System.out.println(reimb1);

		Reimbursement reimb2 = session.get(Reimbursement.class, 3);
		System.out.println(reimb2);

		// Address address3 = session.load(Address.class, 3);
		// System.out.println(address3);
//        

		// commit the transaction
		t.commit();
		// close the session
		session.close();

		System.out.println(factory);
		System.out.println(factory.isClosed());

	}
}