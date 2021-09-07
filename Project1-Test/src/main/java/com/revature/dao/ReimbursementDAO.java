package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.config.ConfigUtil;
import com.revature.pojo.Reimbursement;

public class ReimbursementDAO {
	   
     
     public void saveReimbursement(Reimbursement reimb) {  
         Transaction t = null;
    	 try(Session session = ConfigUtil.getSessionFactory().openSession()){
    		 t = session.beginTransaction();
    		 session.save(reimb);
    		 t.commit();
    	 }catch(Exception e) {
    		 if(t != null) {
    			 t.rollback();
    		 }
    		 e.printStackTrace();
    	 }
     }
     
     public void updateReimbursement(Reimbursement reimb) {
         Transaction t = null;
         try (Session session = ConfigUtil.getSessionFactory().openSession()){
    		 t = session.beginTransaction();
    		 session.update(reimb);
    		 t.commit();
    	 }catch(Exception e) {
    		 if(t != null) {
    			 t.rollback();
    		 }
    		 e.printStackTrace();
    	 }
     }
     
     public void deleteReimbursement(int id) {
         Transaction t = null;
         try (Session session = ConfigUtil.getSessionFactory().openSession()){
    		 t = session.beginTransaction();
    		 
    		 Reimbursement reimb = session.get(Reimbursement.class, id);
    		 if(reimb != null) 
    			 {session.delete(reimb);}
    		 t.commit();
    	 }catch(Exception e) {
    		 if(t != null) {
    			 t.rollback();
    		 }
    		 e.printStackTrace();
    	 }
     }
     
     public Reimbursement getReimbursement(int id) {
         Transaction t = null;
         Reimbursement reimb = null;
         try (Session session = ConfigUtil.getSessionFactory().openSession()){
    		 t = session.beginTransaction();
    		 
    		 reimb = session.get(Reimbursement.class, id);
    		 
    		 t.commit();
    	 }catch(Exception e) {
    		 if(t != null) {
    			 t.rollback();
    		 }
    		 e.printStackTrace();
    	 }
         return reimb;
     }
     
     @SuppressWarnings("unchecked")
     public List<Reimbursement> getAllReimbursement() {
         Transaction t = null;
         List<Reimbursement> listofReimbs = null;
         try (Session session = ConfigUtil.getSessionFactory().openSession()){
    		 t = session.beginTransaction();
    		 
    		 listofReimbs = session.createQuery("from reimbursement").getResultList();
    		 
    		 t.commit();
    	 }catch(Exception e) {
    		 if(t != null) {
    			 t.rollback();
    		 }
    		 e.printStackTrace();
    	 }
         return listofReimbs;
     }
}
