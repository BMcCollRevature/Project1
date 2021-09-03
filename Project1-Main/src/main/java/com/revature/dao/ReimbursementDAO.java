package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.pojo.Reimbursement;
import com.revature.util.ConfigUtil;

public class ReimbursementDAO {

	public void saveReimb(Reimbursement reimb) {
		Transaction t = null;
		try (Session session = ConfigUtil.getSessionFactory().openSession()) {
			t = session.beginTransaction();
			session.save(reimb);
			t.commit();
		} catch (Exception e) {
			if (t != null) {
				t.rollback();
			}
			e.printStackTrace();
		}
	}

	public void updateReimb(Reimbursement reimb) {
		Transaction t = null;
		try (Session session = ConfigUtil.getSessionFactory().openSession()) {
			t = session.beginTransaction();
			session.update(reimb);
			t.commit();
		} catch (Exception e) {
			if (t != null) {
				t.rollback();
			}
			e.printStackTrace();
		}
	}

	public void deleteReimb(int id) {
		Transaction t = null;
		try (Session session = ConfigUtil.getSessionFactory().openSession()) {
			t = session.beginTransaction();

			Reimbursement reimb = session.get(Reimbursement.class, id);
			if (reimb != null) {
				session.delete(reimb);
			}
			t.commit();
		} catch (Exception e) {
			if (t != null) {
				t.rollback();
			}
			e.printStackTrace();
		}
	}

	public Reimbursement getReimb(int id) {
		Transaction t = null;
		Reimbursement reimb = null;
		try (Session session = ConfigUtil.getSessionFactory().openSession()) {
			t = session.beginTransaction();

			reimb = session.get(Reimbursement.class, id);

			t.commit();
		} catch (Exception e) {
			if (t != null) {
				t.rollback();
			}
			e.printStackTrace();
		}
		return reimb;
	}

	@SuppressWarnings("unchecked")
	public List<Reimbursement> getAllReimb() {
		Transaction t = null;
		List<Reimbursement> listofReimbs = null;
		try (Session session = ConfigUtil.getSessionFactory().openSession()) {
			t = session.beginTransaction();

			listofReimbs = session.createQuery("from Reimbursement").getResultList();

			t.commit();
		} catch (Exception e) {
			if (t != null) {
				t.rollback();
			}
			e.printStackTrace();
		}
		return listofReimbs;
	}
}