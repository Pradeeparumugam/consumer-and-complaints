package com.dxctraining.complaintmgt.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Complaint {
	@Id
	private int id;
	
	private String desc;
	public Complaint(int id,String desc) {
		this.id=id;
		this.desc=desc;
	}
	public Complaint() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	@Override
	public int hashCode() {
		
		return id;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Complaint other = (Complaint) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
