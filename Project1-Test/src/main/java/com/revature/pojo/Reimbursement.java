package com.revature.pojo;


	import java.sql.Timestamp;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;

	@Entity
	@Table (name = "reimbursement")
	public class Reimbursement {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		
		@Column(name="amount")
		private Double reimbAmount;
		
		@Column(name="submitted")
		private Timestamp reimSubmitted;
		
		@Column(name="resolved")
		private Timestamp reimResolved;
	
		@Column(name="author")
		private String reimbAuthor;
		
		@Column(name="description", length = 100)
		private String reimbDesc;
		
		@Column(name="status", length = 45)
		private String reimbStatus;
		
		@Column(name="type", length = 45)
		private String reimbType;
		
		public Reimbursement() {}

		public Reimbursement(int id, Double reimbAmount, Timestamp reimSubmitted, Timestamp reimResolved,
				String reimbAuthor, String reimbDesc, String reimbStatus, String reimbType) {
			super();
			this.id = id;
			this.reimbAmount = reimbAmount;
			this.reimSubmitted = reimSubmitted;
			this.reimResolved = reimResolved;
			this.reimbAuthor = reimbAuthor;
			this.reimbDesc = reimbDesc;
			this.reimbStatus = reimbStatus;
			this.reimbType = reimbType;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public Double getReimbAmount() {
			return reimbAmount;
		}

		public void setReimbAmount(Double reimbAmount) {
			this.reimbAmount = reimbAmount;
		}

		public Timestamp getReimSubmitted() {
			return reimSubmitted;
		}

		public static Timestamp setReimSubmitted(Timestamp reimSubmitted) {
			return reimSubmitted;
			//this.reimSubmitted = reimSubmitted;
		}

		public Timestamp getReimResolved() {
			return reimResolved;
		}

		public static Timestamp setReimResolved(Timestamp reimResolved) {
			return reimResolved;
			//this.reimResolved = reimResolved;
		}

		public String getReimbAuthor() {
			return reimbAuthor;
		}

		public void setReimbAuthor(String reimbAuthor) {
			this.reimbAuthor = reimbAuthor;
		}

		public String getReimbDesc() {
			return reimbDesc;
		}

		public void setReimbDesc(String reimbDesc) {
			this.reimbDesc = reimbDesc;
		}

		public String getReimbStatus() {
			return reimbStatus;
		}

		public static String setReimbStatus(String reimbStatus) {
			return reimbStatus;
//			this.reimbStatus = reimbStatus;
		}

		public String getReimbType() {
			return reimbType;
		}

		public void setReimbType(String reimbType) {
			this.reimbType = reimbType;
		}

		@Override
		public String toString() {
			return "Reimbursement [id=" + id + ", reimbAmount=" + reimbAmount + ", reimSubmitted=" + reimSubmitted
					+ ", reimResolved=" + reimResolved + ", reimbAuthor=" + reimbAuthor + ", reimbDesc=" + reimbDesc
					+ ", reimbStatus=" + reimbStatus + ", reimbType=" + reimbType + "]";
		}

		
	}