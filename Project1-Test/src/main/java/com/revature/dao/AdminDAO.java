package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.config.ConfigUtil;
import com.revature.pojo.Admin;


public class AdminDAO{   

public void saveAdmin(Admin admin) {
    Transaction t = null;
	 try (Session session = ConfigUtil.getSessionFactory().openSession()){
		 t = session.beginTransaction();
		 session.save(admin);
		 t.commit();
	 }catch(Exception e) {
		 if(t != null) {
			 t.rollback();
		 }
		 e.printStackTrace();
	 }
}

public void updateAdmin(Admin admin) {
    Transaction t = null;
    try (Session session = ConfigUtil.getSessionFactory().openSession()){
		 t = session.beginTransaction();
		 session.update(admin);
		 t.commit();
	 }catch(Exception e) {
		 if(t != null) {
			 t.rollback();
		 }
		 e.printStackTrace();
	 }
}

public void deleteAdmin(int id) {
    Transaction t = null;
    try (Session session = ConfigUtil.getSessionFactory().openSession()) {
		 t = session.beginTransaction();
		 
		 Admin admin = session.get(Admin.class, id);
		 if(admin != null) 
			 {session.delete(admin);}
		 t.commit();
	 }catch(Exception e) {
		 if(t != null) {
			 t.rollback();
		 }
		 e.printStackTrace();
	 }
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



public Admin getAdmin(int id) {
    Transaction t = null;
    Admin admin = null;
    try (Session session = ConfigUtil.getSessionFactory().openSession()){
		 t = session.beginTransaction();
		 
		 admin = session.get(Admin.class, id);
		 
		 t.commit();
	 }catch(Exception e) {
		 if(t != null) {
			 t.rollback();
		 }
		 e.printStackTrace();
	 }
    return admin;
}

@SuppressWarnings("unchecked")
public List<Admin> getAllAdmin() {
    Transaction t = null;
    List<Admin> listofAdmin = null;
    try (Session session = ConfigUtil.getSessionFactory().openSession()){
		 t = session.beginTransaction();
		 
		 listofAdmin = session.createQuery("from admin").getResultList();
		 
		 t.commit();
	 }catch(Exception e) {
		 if(t != null) {
			 t.rollback();
		 }
		 e.printStackTrace();
	 }
    return listofAdmin;
}
}

