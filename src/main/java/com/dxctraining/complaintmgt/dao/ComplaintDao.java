package com.dxctraining.complaintmgt.dao;



import com.dxctraining.complaintmgt.entities.Complaint;

public interface ComplaintDao {
	public Complaint addComplaint(Complaint complaint);
	public Complaint findById(int id);
	
}
