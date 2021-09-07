package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.config.ConfigUtil;
import com.revature.pojo.Employee;




public class EmployeeDAO {

     public void saveEmployee(Employee employee) {
         Transaction t = null;
    	 try (Session session = ConfigUtil.getSessionFactory().openSession()){
    		 t = session.beginTransaction();
    		 session.save(employee);
    		 t.commit();
    	 }catch(Exception e) {
    		 if(t != null) {
    			 t.rollback();
    		 }
    		 e.printStackTrace();
    	 }
     }
     
     public void updateEmployee(Employee employee) {
         Transaction t = null;
         try (Session session = ConfigUtil.getSessionFactory().openSession()){
    		 t = session.beginTransaction();
    		 session.update(employee);
    		 t.commit();
    	 }catch(Exception e) {
    		 if(t != null) {
    			 t.rollback();
    		 }
    		 e.printStackTrace();
    	 }
     }
     
     public void deleteEmployee(int id) {
         Transaction t = null;
         try (Session session = ConfigUtil.getSessionFactory().openSession()) {
    		 t = session.beginTransaction();
    		 
    		 Employee employee = session.get(Employee.class, id);
    		 if(employee != null) 
    			 {session.delete(employee);}
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
    	    Employee employee = null;
    	    try (Session session = ConfigUtil.getSessionFactory().openSession()) {
    	        // start a transaction
    	        transaction = session.beginTransaction();
    	        // get an user object
    	        employee = (Employee) session.createQuery("FROM employee A WHERE A.username = :username")
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
     
     public Employee getEmployee(int id) {
         Transaction t = null;
         Employee employee = null;
         try (Session session = ConfigUtil.getSessionFactory().openSession()){
    		 t = session.beginTransaction();
    		 
    		 employee = session.get(Employee.class, id);
    		 
    		 t.commit();
    	 }catch(Exception e) {
    		 if(t != null) {
    			 t.rollback();
    		 }
    		 e.printStackTrace();
    	 }
         return employee;
     }
     
     @SuppressWarnings("unchecked")
     public List<Employee> getAllEmployee() {
         Transaction t = null;
         List<Employee> listofEmployee = null;
         try (Session session = ConfigUtil.getSessionFactory().openSession()){
    		 t = session.beginTransaction();
    		 
    		 listofEmployee = session.createQuery("from employee").getResultList();
    		 
    		 t.commit();
    	 }catch(Exception e) {
    		 if(t != null) {
    			 t.rollback();
    		 }
    		 e.printStackTrace();
    	 }
         return listofEmployee;
     }
}
