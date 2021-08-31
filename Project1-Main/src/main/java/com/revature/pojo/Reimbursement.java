package com.revature.pojo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reimbursement")
public class Reimbursement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "amount", length = 10, precision = 2)
	private Double reimbAmount;

	@Column(name = "submitted")
//	@Temporal(TemporalType.TIMESTAMP)
	private Timestamp reimbSubmitted;

	@Column(name = "resolved")
//	@Temporal(TemporalType.DATE)
	private Timestamp reimbResolved;

	@Column(name = "author")
	private String reimbAuthor;

	@Column(name = "description", length = 100)
	private String reimbDesc;

	@Column(name = "status", length = 45)
	private String reimbStatus;

	@Column(name = "type", length = 45)
	private String reimbType;

	public Reimbursement() {

	}

	public Reimbursement(int id, double reimbAmount, Timestamp reimbSubmitted, Timestamp reimbResolved,
			String reimbAuthor, String reimbDesc, String reimbStatus, String reimbType) {
		super();
		this.id = id;
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
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

	public double getReimbAmount() {
		return reimbAmount;
	}

	public void setReimbAmount(double reimbAmount) {
		this.reimbAmount = reimbAmount;
	}

	public Timestamp getReimbSubmitted() {
		return reimbSubmitted;
	}

	public void setReimbSubmitted(Timestamp reimbSubmitted) {
		this.reimbSubmitted = reimbSubmitted;
	}

	public Timestamp getReimbResolved() {
		return reimbResolved;
	}

	public void setReimbResolved(Timestamp reimbResolved) {
		this.reimbResolved = reimbResolved;
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

	public void setReimbStatus(String reimbStatus) {
		this.reimbStatus = reimbStatus;
	}

	public String getReimbType() {
		return reimbType;
	}

	public void setReimbType(String reimbType) {
		this.reimbType = reimbType;
	}

	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", reimbAmount=" + reimbAmount + ", reimbSubmitted=" + reimbSubmitted
				+ ", reimbResolved=" + reimbResolved + ", reimbAuthor=" + reimbAuthor + ", reimbDesc=" + reimbDesc
				+ ", reimbStatus=" + reimbStatus + ", reimbType=" + reimbType + "]";
	}
}
