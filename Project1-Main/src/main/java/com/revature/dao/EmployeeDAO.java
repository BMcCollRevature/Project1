package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.pojo.Employee;
import com.revature.util.ConfigUtil;

public class EmployeeDAO {

	public void saveEmployee(Employee employee) {
		Transaction transaction = null;
		try (Session session = ConfigUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(employee);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	/**
	 * Update User
	 * 
	 * @param user
	 */
	public void updateEmployee(Employee employee) {
		Transaction transaction = null;
		try (Session session = ConfigUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.update(employee);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	/**
	 * Delete User
	 * 
	 * @param id
	 */
	public void deleteEmployee(int id) {

		Transaction transaction = null;
		try (Session session = ConfigUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// Delete a user object
			Employee employee = session.get(Employee.class, id);
			if (employee != null) {
				session.delete(employee);
				System.out.println("user is deleted");
			}

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	/**
	 * Get User By ID
	 * 
	 * @param id
	 * @return
	 */
	public Employee getEmployee(int id) {

		Transaction transaction = null;
		Employee user = null;
		try (Session session = ConfigUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			user = session.get(Employee.class, id);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return user;
	}

	/**
	 * Get all Users
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployee() {

		Transaction transaction = null;
		List<Employee> listOfEmployee = null;
		try (Session session = ConfigUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object

			listOfEmployee = session.createQuery("from Employee").getResultList();

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listOfEmployee;
	}

	public boolean validate(String username, String password) {

		Transaction transaction = null;
		Employee employee = null;
		try (Session session = ConfigUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			employee = (Employee) session.createQuery("FROM Employee E WHERE E.username = :username")
					.setParameter("username", username).uniqueResult();

			if (employee != null && employee.getPassword().equals(password)) {
				return true;
			}
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return false;
	}

}
