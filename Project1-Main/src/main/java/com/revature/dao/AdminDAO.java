package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.pojo.Admin;
import com.revature.util.ConfigUtil;

public class AdminDAO {
	public void saveAdmin(Admin admin) {
		Transaction transaction = null;
		try (Session session = ConfigUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(admin);
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
	 * Update
	 * 
	 * @param user
	 */
	public void updateAdmin(Admin admin) {
		Transaction transaction = null;
		try (Session session = ConfigUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.update(admin);
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
	public void deleteAdmin(int id) {

		Transaction transaction = null;
		try (Session session = ConfigUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// Delete a user object
			Admin admin = session.get(Admin.class, id);
			if (admin != null) {
				session.delete(admin);
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
	public Admin getAdmin(int id) {

		Transaction transaction = null;
		Admin user = null;
		try (Session session = ConfigUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			user = session.get(Admin.class, id);
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
	public List<Admin> getAllAdmin() {

		Transaction transaction = null;
		List<Admin> listOfAdmin = null;
		try (Session session = ConfigUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object

			listOfAdmin = session.createQuery("from Admin").getResultList();

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listOfAdmin;
	}

	public boolean validate(String username, String password) {

		Transaction transaction = null;
		Admin admin = null;
		try (Session session = ConfigUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			admin = (Admin) session.createQuery("FROM admin A WHERE A.username = :username")
					.setParameter("username", username).uniqueResult();

			if (admin != null && admin.getPassword().equals(password)) {
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
