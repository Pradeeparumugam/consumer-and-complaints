package com.dxctraining.complaintmgt.service;

import java.util.List;

import com.dxctraining.complaintmgt.entities.Complaint;

public interface ComplaintService {
	public Complaint addComplaint(Complaint complaint);
	public Complaint findById(int id);
	public List<Complaint> findAll(int consumerid);
	
}
